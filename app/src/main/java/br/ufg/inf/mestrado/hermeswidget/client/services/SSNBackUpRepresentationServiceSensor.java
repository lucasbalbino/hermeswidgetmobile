package br.ufg.inf.mestrado.hermeswidget.client.services;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import br.ufg.inf.mestrado.hermeswidget.manager.transferObject.HWTransferObject;
import br.ufg.inf.mestrado.hermeswidget.ontologies.M3;
import br.ufg.inf.mestrado.hermeswidget.ontologies.SSN;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
import android.util.Log;

public class SSNBackUpRepresentationServiceSensor extends HWRepresentationService {

    private HWTransferObject hermesWidgetTO = null;

    //private OntModel ontModelObservation;
    //private AllDifferent allDiff;

    public SSNBackUpRepresentationServiceSensor() {

    }

	/*
	public HWRepresentationServiceSensor(OntModel ontModel) {
		ontModelObservation = ontModel;
	}
	*/

    public HWTransferObject startRepresentationSensor(String nomeModelo, String instanteMedidaColetada, String abreveaturaSinalVital,
                                                      int contadorSinalVital, String nomeClasseSinalVital, String medidaColetada, String[] medidaComposta, String unidadeMedida, String idPaciente) {

        criarModeloRDFDeArquivo("./mimic/modelos/" + nomeModelo);

		/*
		if (allDiff == null) {
			allDiff = modeloMedicaoSinalVital.createAllDifferent();
		}
		*/

        modeloMedicaoSinalVital = ModelFactory.createOntologyModel();
        modeloMedicaoSinalVital.setNsPrefix("ssn","http://purl.oclc.org/NET/ssnx/ssn#");
        modeloMedicaoSinalVital.setNsPrefix("m3-lite","http://purl.org/iot/vocab/m3-lite#");

        //String[] sensorOutput = {"sensorOutput_"+nomeClasseSinalVital};
        String sensorOutput = "sensorOutput-" + nomeClasseSinalVital;
        String observationValue = "observationValue";

        Object[] values;
        if (abreveaturaSinalVital == "PresSang") {
            Object[] v = medidaComposta;
            values = v;
        } else {
            Object[] v = {medidaColetada};
            values = v;
        }


        modeloMedicaoSinalVital = representObservation(abreveaturaSinalVital, "property-" + abreveaturaSinalVital, "sensor-" + nomeClasseSinalVital, sensorOutput, "observation-" + abreveaturaSinalVital, observationValue, values, unidadeMedida, idPaciente);


        //if (contadorSinalVital == 0)
        //modeloMedicaoSinalVital.write(System.out, "TURTLE");

        ByteArrayOutputStream baosContextoFiltrado = new ByteArrayOutputStream();
        modeloMedicaoSinalVital.write(baosContextoFiltrado, tipoSerializacao, caminhoSchemaOntologico);
        byte[] byteArray = baosContextoFiltrado.toByteArray();


        // Configura transfer object

        hermesWidgetTO = new HWTransferObject();

        // ALTERACAO
        // hermesWidgetTO.setIdEntidade(idPaciente+"_"+nomeClasseSinalVital);
        hermesWidgetTO.setIdEntidade("person" + idPaciente);

        hermesWidgetTO.setNomeTopico(nomeClasseSinalVital);
        hermesWidgetTO.setComplementoTopico("");
        hermesWidgetTO.setContexto(byteArray);
        hermesWidgetTO.setCaminhoOntologia(caminhoSchemaOntologico);
        hermesWidgetTO.setTipoSerializacao(tipoSerializacao);
        if (!abreveaturaSinalVital.equals("PresSang")) {
            hermesWidgetTO.setSensorValue(medidaColetada);
        } else {
            hermesWidgetTO.setSensorValue(medidaComposta[0] + " e " + medidaComposta[1]);
        }

		/* Depreciado
		Calendar calendarMedida = Calendar.getInstance();
		calendarMedida.setTime(instanteMedida);
		int segundosMinuto = calendarMedida.get(Calendar.MINUTE) * 60;
		int instanteFinal = segundosMinuto + calendarMedida.get(Calendar.SECOND);
		*/
        return hermesWidgetTO;
    }

    private OntModel representObservation(String sinal, String property, String sensor, String sensorOutput, String observation, String observationValue, Object[] values, String unidadeMedida, String feature) {
		/*
		Set<String> chaves = HermesWidgetObjects.getPacientes().keySet();
		for (String chave : chaves)
		{
			if(chave != null)
				System.out.println(chave + HermesWidgetObjects.getPacientes().get(chave));
		}
		*/

        //HermesWidgetObjects object = new HermesWidgetObjects();

        String featureIRI; // +"-"+ UUID.randomUUID().toString();
		/*
		if (!object.getObjects().isEmpty() && object.getObjects().containsKey(property)) {
			featureIRI = object.getObjects().get(property);
		} else {
			featureIRI = SSN.NS + feature +"-"+ UUID.randomUUID().toString();
			object.getObjects().put(feature, featureIRI);
		}*/
        // NOVO
        featureIRI = SSN.NS + feature;

        String propertyIRI; // +"-"+ UUID.randomUUID().toString();
		/*
		if (!object.getObjects().isEmpty() && object.getObjects().containsKey(property)) {
			propertyIRI = object.getObjects().get(property);
		} else {
			propertyIRI = SSN.NS + property +"-"+ UUID.randomUUID().toString();
			object.getObjects().put(property, propertyIRI);
		}
		*/
        // NOVO
        propertyIRI = SSN.NS + property;

        String sensorIRI = SSN.NS + sensor + "-" + UUID.randomUUID().getMostSignificantBits();
        //String observationIRI = SSN.NS + observation +"-"+ UUID.randomUUID().toString();

        Resource featureOfInterestResource = modeloMedicaoSinalVital
                .createResource(featureIRI)
                .addProperty(RDF.type, SSN.FeatureOfInterest);

        /**
         * An observable Quality of an Event or Object. That is, not a quality
         * of an abstract entity as is also allowed by DUL's Quality, but rather
         * an aspect of an entity that is intrinsic to and cannot exist without
         * the entity and is observable by a sensor.
         */
        Resource propertyResource = modeloMedicaoSinalVital
                .createResource(propertyIRI)
                .addProperty(RDF.type, SSN.Property);

        /**
         * A sensor can do (implements) sensing: that is, a sensor is any entity
         * that can follow a sensing method and thus observe some Property of a
         * FeatureOfInterest. Sensors may be physical devices, computational
         * methods, a laboratory setup with a person following a method, or any
         * other thing that can follow a Sensing Method to observe a Property.
         */
        Resource sensorResource = modeloMedicaoSinalVital
                .createResource(sensorIRI)
                .addProperty(RDF.type, SSN.SensingDevice)
                .addProperty(SSN.observes, propertyResource);

        //allDiff.addDistinctMember(sensorResource);

        /**
         * A sensor outputs a piece of information (an observed value), the
         * value itself being represented by an ObservationValue.
         */

        //Resource[] sensorOutputResource = new Resource[sensorOutput.length];
        Resource sensorOutputResource;

        //for (int i = 0; i < values.length; i++) {
        sensorOutputResource = modeloMedicaoSinalVital
                .createResource(SSN.NS + sensorOutput + "-" + UUID.randomUUID().getMostSignificantBits())
                .addProperty(RDF.type, SSN.SensorOutput)
                .addProperty(SSN.isProducedBy, sensorResource);
        //}

        /**
         * An Observation is a Situation in which a Sensing method has been used
         * to estimate or calculate a value of a Property of a
         * FeatureOfInterest. Links to Sensing and Sensor describe what made the
         * Observation and how; links to Property and Feature detail what was
         * sensed; the result is the output of a Sensor; other metadata details
         * times etc.
         */

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        DatatypeFactory df;
        Date dateTime = calendar.getTime();
//        XMLGregorianCalendar dateTime = null;
//        try {
//            df = DatatypeFactory.newInstance();
//            dateTime = df.newXMLGregorianCalendar(calendar);
//        } catch (DatatypeConfigurationException e) {
//            e.printStackTrace();
//        }


        //for (int i = 0; i < values.length; i++) {
        modeloMedicaoSinalVital.createResource(SSN.NS + observation + "-" + UUID.randomUUID().getMostSignificantBits())
                .addProperty(RDF.type, SSN.Observation)
                .addProperty(SSN.observedBy, sensorResource)
                .addProperty(SSN.observedProperty, propertyResource)
                .addProperty(SSN.observationResult, sensorOutputResource)
                .addProperty(SSN.featureOfInterest, featureOfInterestResource)
                .addProperty(SSN.observationResultTime, modeloMedicaoSinalVital.createTypedLiteral(dateTime.toString(), XSDDatatype.XSDdateTime));
        //}


        if (sinal == "Temp") {
            sensorOutputResource.addProperty(SSN.hasValue,
                    modeloMedicaoSinalVital.createResource(SSN.NS + observationValue + "-" + UUID.randomUUID().getMostSignificantBits())
                            .addProperty(RDF.type, SSN.ObservationValue)
                            .addProperty(SSN.hasOutputValue, modeloMedicaoSinalVital.createTypedLiteral(values[0], XSDDatatype.XSDfloat))
                            .addProperty(SSN.hasOutputUnit, M3.DegreeCelsius)
            );
        } else if (sinal == "PresSang") {

            String uri = SSN.NS + observationValue + "-" + UUID.randomUUID().getMostSignificantBits();
            for (int i = 0; i < values.length; i++) {
                if (i == 0) {
                    sensorOutputResource.addProperty(SSN.hasValue,
                            modeloMedicaoSinalVital.createResource(uri)
                                    .addProperty(RDF.type, SSN.ObservationValue)
                                    .addProperty(SSN.hasOutputValueAux, modeloMedicaoSinalVital.createTypedLiteral(values[i], XSDDatatype.XSDnonNegativeInteger))
                                    .addProperty(SSN.hasOutputUnit, M3.MmHg)
                    );

                } else {
                    sensorOutputResource.addProperty(SSN.hasValue,
                            modeloMedicaoSinalVital.createResource(uri)
                                    .addProperty(RDF.type, SSN.ObservationValue)
                                    .addProperty(SSN.hasOutputValue, modeloMedicaoSinalVital.createTypedLiteral(values[i], XSDDatatype.XSDnonNegativeInteger))
                                    .addProperty(SSN.hasOutputUnit,  M3.MmHg)
                    );
                }

            }
        }else if (sinal == "FreqPulso") {
            sensorOutputResource.addProperty(SSN.hasValue,
                    modeloMedicaoSinalVital.createResource(SSN.NS + observationValue + "-" + UUID.randomUUID().getMostSignificantBits())
                            .addProperty(RDF.type, SSN.ObservationValue)
                            .addProperty(SSN.hasOutputValue, modeloMedicaoSinalVital.createTypedLiteral(values[0], XSDDatatype.XSDfloat))
                            .addProperty(SSN.hasOutputUnit, M3.BeatPerMinute)
            );

        }else if (sinal == "SatOxig") {
            sensorOutputResource.addProperty(SSN.hasValue,
                    modeloMedicaoSinalVital.createResource(SSN.NS + observationValue + "-" + UUID.randomUUID().getMostSignificantBits())
                            .addProperty(RDF.type, SSN.ObservationValue)
                            .addProperty(SSN.hasOutputValue, modeloMedicaoSinalVital.createTypedLiteral(values[0], XSDDatatype.XSDfloat))
                            .addProperty(SSN.hasOutputUnit, M3.Percent)
            );

        }
        else
        {
//				String aux = String.valueOf(values[i]);
//				int aux2 = Integer.parseUnsignedInt(aux);

            //int aux = Integer.parseInt((String) values[i]);
            sensorOutputResource.addProperty(SSN.hasValue,
                    modeloMedicaoSinalVital.createResource(SSN.NS + observationValue + "-" + UUID.randomUUID().getMostSignificantBits())
                            .addProperty(RDF.type, SSN.ObservationValue)
                            .addProperty(SSN.hasOutputValue, modeloMedicaoSinalVital.createTypedLiteral(values[0], XSDDatatype.XSDnonNegativeInteger))
                            .addProperty(SSN.hasOutputUnit, modeloMedicaoSinalVital.createTypedLiteral(unidadeMedida, XSDDatatype.XSDstring))
            );

        }

        return modeloMedicaoSinalVital;
    }

	/*
	public Resource getObservation() {
		return this.observationResource;
	}
	*/

	/*
	public static void main(String[] args) {

		OntModel ontModel = ModelFactory.createOntologyModel();
		HWRepresentationServiceSensor rs = new HWRepresentationServiceSensor(ontModel);

		String[] sensorOutputBloodPressure = {"SystolicBloodPressureSensorOutput", "DiastolicBloodPressureSensorOutput"};
		String[] observationValueBloodPressure = {"SystolicBloodPressureObservationValue", "DiastolicBloodPressureObservationValue"};


		Object[] valuesBloodPressure1 = {133, 84};
		ontModel = rs.representObservation("BloodPressure", "BloodPressureSensor001", sensorOutputBloodPressure, "BloodPressureObservation001", observationValueBloodPressure, valuesBloodPressure1, "teste");

		//ontModel.write(System.out, "TURTLE");

		//System.out.println("\n\n");

		rs = new HWRepresentationServiceSensor(ontModel);


		Object[] valuesBloodPressure2 = {120, 80};
		ontModel = rs.representObservation("BloodPressure", "BloodPressureSensor002", sensorOutputBloodPressure, "BloodPressureObservation002", observationValueBloodPressure, valuesBloodPressure2, "teste");

		ontModel.write(System.out, "TURTLE");

		System.out.println("\n\n");

	}
	*/

    public void setModeloMedicaoSinalVital(OntModel modeloMedicaoSinalVital) {
        this.modeloMedicaoSinalVital = modeloMedicaoSinalVital;
    }

    public OntModel getModeloMedicaoSinalVital(){
        return this.modeloMedicaoSinalVital;
    }


    public HWTransferObject getDataTransferObject(String idPaciente, String nomeClasseSinalVital, String complementoTopico, byte[] medidaByteArray, String valorMedidaColetada, String instanteMedidaColetada) {

        hermesWidgetTO = new HWTransferObject();

        // ALTERACAO
        // hermesWidgetTO.setIdEntidade(idPaciente+"_"+nomeClasseSinalVital);
        hermesWidgetTO.setIdEntidade("person" + idPaciente);

        hermesWidgetTO.setNomeTopico(nomeClasseSinalVital);
        hermesWidgetTO.setComplementoTopico(complementoTopico);
        hermesWidgetTO.setContexto(medidaByteArray);
        hermesWidgetTO.setCaminhoOntologia(caminhoSchemaOntologico);
        hermesWidgetTO.setTipoSerializacao(tipoSerializacao);
        hermesWidgetTO.setSensorValue(valorMedidaColetada);

		/* Depreciado
		Calendar calendarMedida = Calendar.getInstance();
		calendarMedida.setTime(instanteMedida);
		int segundosMinuto = calendarMedida.get(Calendar.MINUTE) * 60;
		int instanteFinal = segundosMinuto + calendarMedida.get(Calendar.SECOND);
		*/
        return hermesWidgetTO;

//		threadPoolMedidas.schedule(new HermesWidgetThreadMeasurementNotification(hermesBaseManager, hermesWidgetTO), instanteFinal, TimeUnit.MINUTES);
    }

}