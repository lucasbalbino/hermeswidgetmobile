package br.ufg.inf.mestrado.hermeswidget.client.sensor.heartRate;

import com.hp.hpl.jena.ontology.OntModel;

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
import br.ufg.inf.mestrado.hermeswidget.client.utils.HWLog;
import br.ufg.inf.mestrado.hermeswidget.client.utils.ReaderCSV;
import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;
import br.ufg.inf.mestrado.hermeswidgetmobile.MainActivity;

/**
 * @author Ernesto
 */

public class HWSensorHeartRate extends HermesWidgetSensorClient {

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

    public HWSensorHeartRate(File registroAtual, String tempo[]) {
        this.registroMimicFile = registroAtual;
        this.startConfigurationService("./settings/topics_heartRate.json");
//		this.hermesBaseManager = this.getCommunicationService();
        this.representationService = this.getRepresentationService();
        this.tempoTotalMedida = Integer.parseInt(tempo[0]);
        this.intervalos = Integer.parseInt(tempo[1]);
        //this.objects = objects;
    }

    public HWSensorHeartRate(InputStream registroAtual, String nome, String tempo[]) {
        this.registroMimic = registroAtual;
        this.nomeRegistro = nome;
//		this.startConfigurationService("./settings/topics_heartRate.json");
//		this.hermesBaseManager = this.getCommunicationService();
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
        int totalThreads = (listaComSinaisVitais.size()) / this.intervalos;

        // Prepara o pool de threads
        threadPoolMedidas = Executors.newScheduledThreadPool(totalThreads);

        int posicaoSinalVital = 0;
        String[] cabecalho = reader.getLinhas().get(0);
        int contador = 0;
        for (String colunaCabecalho : cabecalho) {
            if (colunaCabecalho.equals("'PULSE'")) {
                posicaoSinalVital = contador;
            }
            contador++;
        }

        if (posicaoSinalVital != 0) {

            String log = "Hermes Widget Sensor Heart Rate for patient ---> "
                    + this.nomeRegistro + " started! Date: "
                    + new Date().toString();
//            HWLog.recordLog(log);


            int posicaoExtensao = nomeRegistro.lastIndexOf('.');
            String recordIdAtual = nomeRegistro.substring(0, posicaoExtensao);

            // Laco para verificar os metadados de cada paciente e as
            // informacoes de leitura dos sinais vitais
            int contadorHeartRate = 0;
            int contadorLinhas = 0;
            int contadorThreads = 1;
            for (String[] medicaoAtual : listaComSinaisVitais) {
                if (contadorLinhas % this.intervalos == 0) {
                    // int segundos = Integer.valueOf(medicaoAtual[0]);
                    float segfloat = Float.valueOf(medicaoAtual[0]);
                    int segundos = Math.round(segfloat);

                    int contadorHR = contadorHeartRate++;

                    //System.out.println(medicaoAtual[posicaoSinalVital] +" - "+ contadorHR);

                    HWTransferObject hermesWidgetTO = representationService.startRepresentationSensor(
                            "frequencia_pulso.ttl",
                            Integer.toString(segundos),
                            "FreqPulso",
                            contadorHR,
                            "VSO_0000030",
                            medicaoAtual[posicaoSinalVital].substring(0, medicaoAtual[posicaoSinalVital].lastIndexOf('.')),
                            null,
                            "bpm",
                            recordIdAtual
                    );

                    hermesWidgetTO.setThreadAtual(contadorThreads);
                    hermesWidgetTO.setTotalThreads(totalThreads);

                    // REMOVENDO O HERMES BASE
//					threadPoolMedidas.schedule(this.getNotificationService(
//							hermesBaseManager, hermesWidgetTO), segundos,
//							TimeUnit.SECONDS);

                   // threadPoolMedidas.schedule(this.getNotificationService(hermesWidgetTO), segundos,
                           // TimeUnit.SECONDS);

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
        }
        MainActivity.setCache(cache);
    }

    public Writer getRecordRDF() {
        return this.recordRDF;
    }

}
