package br.ufg.inf.mestrado.hermeswidget.client.sensor.bloodPressure;

import android.util.Log;

import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//import br.ufg.inf.mestrado.hermesbase.HermesBaseManager;
import br.ufg.inf.mestrado.hermeswidget.client.sensor.general.HermesWidgetSensorClient;
import br.ufg.inf.mestrado.hermeswidget.client.services.HWRepresentationServiceSensor;
//import br.ufg.inf.mestrado.hermeswidget.client.utils.HWLog;
import com.hp.hpl.jena.ontology.OntModel;
import br.ufg.inf.mestrado.hermeswidget.client.utils.ReaderCSV;
import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;
import br.ufg.inf.mestrado.hermeswidgetmobile.MainActivity;

/**
 * @author Ernesto
 */

public class HWSensorBloodPressure extends HermesWidgetSensorClient {

    //	private HermesBaseManager hermesBaseManager;
    private HWRepresentationServiceSensor representationService;

    //private HashMap<String, String> objects;

    private ScheduledExecutorService threadPoolMedidas = null;

    private InputStream registroMimic;
    private File registroMimicFile;

    private String nomeRegistro;

    private int tempoTotalMedida = 0;

    private int intervalos = 0;

    private OntModel[] cache;

    private int tamCache;

    private Writer recordRDF;

    long tTotalRepresentation;

    public HWSensorBloodPressure(File registroAtual, String tempo[]) {
        this.registroMimicFile = registroAtual;
        this.nomeRegistro = registroAtual.getName();
        this.startConfigurationService("./settings/topics_bloodPressure.json");
        //this.hermesBaseManager = this.getCommunicationService();
        this.representationService = this.getRepresentationService();
        this.tempoTotalMedida = Integer.parseInt(tempo[0])+4;
        this.intervalos = Integer.parseInt(tempo[1]);
    }

    public HWSensorBloodPressure(InputStream registroAtual, String nome, String tempo[]) {
        this.registroMimic = registroAtual;
        this.nomeRegistro = nome;
//        this.startConfigurationService("./settings/topics_bloodPressure.json");
        //this.hermesBaseManager = this.getCommunicationService();
        this.representationService = this.getRepresentationService();
        this.tempoTotalMedida = Integer.parseInt(tempo[0])+4;
        this.intervalos = Integer.parseInt(tempo[1]);
        this.tamCache = Integer.parseInt(tempo[2]);

        cache = new OntModel[tamCache];
        int contadorCache = 0;
        for(int i = 0; i < tamCache; i++)
            cache[i] = null;


        this.recordRDF = new StringWriter();

        ReaderCSV reader = new ReaderCSV(this.registroMimic);

        // int totalLinhas = reader.getLinhas().size();
        List<String[]> listaComSinaisVitais = reader.getLinhas().subList(4, tempoTotalMedida);

        //Log.i("HERMES WIDGET", listaComSinaisVitais.get(0)[0]);

        int totalThreads = (listaComSinaisVitais.size()) / this.intervalos;

        // Prepara o pool de threads
        // threadPoolMedidas =
        // Executors.newScheduledThreadPool(reader.getLinhas().size());
        threadPoolMedidas = Executors.newScheduledThreadPool(totalThreads);

        //Log.i("HERMES WIDGET", "Total threads: " + totalThreads);

        int posicaoSistolica = 0;
        int posicaoDiastolica = 0;
        int posicaoMedia = 0;
        String[] cabecalho = reader.getLinhas().get(0);
        int contador = 0;
        for (String colunaCabecalho : cabecalho) {
            if (colunaCabecalho.equals("'ABPsys'")) {
                posicaoSistolica = contador;
            } else if (colunaCabecalho.equals("'ABPdias'")) {
                posicaoDiastolica = contador;
            } else if (colunaCabecalho.equals("'ABPmean'")) {
                posicaoMedia = contador;
            }
            contador++;
        }
        //Log.i("HERMES WIDGET", "...ABPsys = " + posicaoSistolica);
        //Log.i("HERMES WIDGET", "...ABPdias = " + posicaoDiastolica);
       //Log.i("HERMES WIDGET", "...ABPmean = " + posicaoMedia);

        if (posicaoSistolica != 0) {

            String log = "Hermes Widget Sensor Blood Pressure for patient ---> "
                    + nomeRegistro
                    + " started! Date: "
                    + new Date().toString();
//            HWLog.recordLog(log);

            //Log.i("HERMES WIDGET", log + "\n");

            int posicaoExtensao = nomeRegistro.lastIndexOf('.');

            String recordIdAtual = nomeRegistro.substring(0, posicaoExtensao);

            //Log.i("HERMES WIDGET", recordIdAtual);

            // System.out.println("Inicio do monitoramento do paciente...");

            // Laco para verificar os metadados de cada paciente e as
            // informacoes de leitura dos sinais vitais

            int contadorPres = 0;
            int contadorLinhas = 0;
            int contadorThreads = 1;
            for (String[] medicaoAtual : listaComSinaisVitais) {
                if (contadorLinhas % this.intervalos == 0) {

                    // int segundos = Integer.valueOf(medicaoAtual[0]);
                    float segfloat = Float.valueOf(medicaoAtual[0]);
                    int segundos = Math.round(segfloat);

                    int contadorP = contadorPres++;

                    //System.out.println(medicaoAtual[posicaoSistolica] +" - "+ contadorP);

                    // Diastolica e Sistolica
                    String medicaoComposta[] = {medicaoAtual[posicaoDiastolica].substring(0, medicaoAtual[posicaoDiastolica].lastIndexOf('.')),
                            medicaoAtual[posicaoSistolica].substring(0, medicaoAtual[posicaoSistolica].lastIndexOf('.'))};

                    HWTransferObject hermesWidgetTO = representationService.startRepresentationSensor(
                            "pressao_arterial.ttl",
                            Integer.toString(segundos),
                            "PresSang",
                            contadorP,
                            "VSO_0000005",
                            null,
                            medicaoComposta,
                            "mmHg",
                            recordIdAtual
                    );

					/*
					// Distolica
					representationService.representMonitoringVitalSign(
							"pressao_sanguinea.ttl", "MonitoringBloodPressure",
							Integer.toString(segundos), "PresSang", contadorP,
							"VSO_0000005", "hasMonitoringBloodPressure",
							"isMeasurementBloodPressure",
							"valueDiastolicBloodPressure",
							medicaoAtual[posicaoDiastolica],
							"unitBloodPressure", "mmHg", recordIdAtual,
							medicaoAtual[posicaoMedia]);
					*/

					/*
					// Sistolica.
					int posicaoDecimal = medicaoAtual[posicaoSistolica]
							.lastIndexOf('.');
					String medidaInteira = medicaoAtual[posicaoSistolica]
							.substring(0, posicaoDecimal);
					representationService
							.getModeloMedicaoSinalVital()
							.add(representationService.getNovaMedicaoAferida(),
									ResourceFactory.createProperty(HWRepresentationServiceVitalSign
											.getDefaultNamespace()
											+ "valueSystolicBloodPressure"),
									ResourceFactory.createTypedLiteral(new Integer(
											Integer.parseInt(medidaInteira))));
					*/


                    hermesWidgetTO.setThreadAtual(contadorThreads);
                    hermesWidgetTO.setTotalThreads(totalThreads);

                    // REMOVENDO O HERMES BASE
//                    threadPoolMedidas.schedule(this.getNotificationService(hermesBaseManager, hermesWidgetTO), segundos, TimeUnit.SECONDS);

                    //threadPoolMedidas.schedule(this.getNotificationService(hermesWidgetTO), segundos, TimeUnit.SECONDS);

                }

                // if (contadorLinhas==0)
                // representationService.modeloMedicaoSinalVital.write(System.out,
                // "TURTLE");
                //

                // Guarda em cache as ultimas N representações em formato OntModel
                //cache[contadorCache] = representationService.getModeloMedicaoSinalVital();
                //contadorCache = (contadorCache+1) % tamCache;

                representationService.modeloMedicaoSinalVital.write(this.recordRDF, "TURTLE");

                representationService.setModeloMedicaoSinalVital(null);

                contadorThreads++;
            }
            contadorLinhas++;
        }
        //MainActivity.setCache(cache);
    }

    public Writer getRecordRDF() {
        return this.recordRDF;
    }
}
