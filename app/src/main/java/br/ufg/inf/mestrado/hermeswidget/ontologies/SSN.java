package br.ufg.inf.mestrado.hermeswidget.ontologies;

/* CVS $Id: $ */
 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*;
 
/**
 * Vocabulary definitions from C:\Users\Ernesto\Dropbox\UFG\ORIENTACAO\REUNIOES\REUNIAO 12 (02-02-2015)\SSN Ontology\ssn.owl
 * @author Auto-generated by schemagen on 19 Fev 2015 11:40 
 */
public class SSN {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.oclc.org/NET/ssnx/ssn#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>Relation between a Platform and any Systems (e.g., Sensors) that are attached 
     *  to the Platform.</p>
     */
    public static final ObjectProperty attachedSystem = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#attachedSystem" );
    
    /** <p>Relation between a deployment and the platform on which the system was deployed.</p> */
    public static final ObjectProperty deployedOnPlatform = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#deployedOnPlatform" );
    
    /** <p>Relation between a deployment and the deployed system.</p> */
    public static final ObjectProperty deployedSystem = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#deployedSystem" );
    
    /** <p>Has part relation between a deployment process and its constituent processes.</p> */
    public static final ObjectProperty deploymentProcessPart = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#deploymentProcessPart" );
    
    /** <p>A relation from a sensor to the Stimulus that the sensor can detect. The Stimulus 
     *  itself will be serving as a proxy for (see isProxyOf) some observable property.</p>
     */
    public static final ObjectProperty detects = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#detects" );
    
    public static final ObjectProperty endTime = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#endTime" );
    
    /** <p>A relation between an observation and the entity whose quality was observed. 
     *  For example, in an observation of the weight of a person, the feature of interest 
     *  is the person and the quality is weight.</p>
     */
    public static final ObjectProperty featureOfInterest = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#featureOfInterest" );
    
    /** <p>A relation between some aspect of a sensing entity and a property. For example, 
     *  from a sensor to the properties it can observe, or from a deployment to the 
     *  properties it was installed to observe. Also from a measurement capability 
     *  to the property the capability is described for. (Used in conjunction with 
     *  ofFeature).</p>
     */
    public static final ObjectProperty forProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#forProperty" );
    
    /** <p>Relation between a System and a Deployment, recording that the System/Sensor 
     *  was deployed in that Deployment.</p>
     */
    public static final ObjectProperty hasDeployment = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasDeployment" );
    
    public static final ObjectProperty hasInput = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasInput" );
    
    /** <p>Relation from a Sensor to a MeasurementCapability describing the measurement 
     *  properties of the sensor.</p>
     */
    public static final ObjectProperty hasMeasurementCapability = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasMeasurementCapability" );
    
    /** <p>Relation from a MeasurementCapability to a MeasurementProperty. For example, 
     *  to an accuracy (see notes at MeasurementCapability).</p>
     */
    public static final ObjectProperty hasMeasurementProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasMeasurementProperty" );
    
    /** <p>Relation from an OperatingRange to a Property. For example, to a battery lifetime.</p> */
    public static final ObjectProperty hasOperatingProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasOperatingProperty" );
    
    /** <p>Relation from a System to an OperatingRange describing the normal operating 
     *  environment of the System.</p>
     */
    public static final ObjectProperty hasOperatingRange = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasOperatingRange" );
    
    public static final ObjectProperty hasOutput = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasOutput" );
    
    /** <p>A relation between a FeatureOfInterest and a Property of that feature.</p> */
    public static final ObjectProperty hasProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasProperty" );
    
    /** <p>Haspart relation between a system and its parts.</p> */
    public static final ObjectProperty hasSubSystem = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasSubSystem" );
    
    /** <p>Relation from a SurvivalRange to a Property describing the survial range of 
     *  a system. For example, to the temperature extreme that a system can withstand 
     *  before being considered damaged.</p>
     */
    public static final ObjectProperty hasSurvivalProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasSurvivalProperty" );
    
    /** <p>A Relation from a System to a SurvivalRange.</p> */
    public static final ObjectProperty hasSurvivalRange = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasSurvivalRange" );
    
    public static final ObjectProperty hasValue = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#hasValue" );
    
    /** <p>A relation between the description of an algorithm, procedure or method and 
     *  an entity that implements that method in some executable way. For example, 
     *  between a scientific measuring method and a sensor the senses via that method.</p>
     */
    public static final ObjectProperty implementedBy = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#implementedBy" );
    
    /** <p>A relation between an entity that implements a method in some executable way 
     *  and the description of an algorithm, procedure or method. For example, between 
     *  a Sensor and the scientific measuring method that the Sensor uses to observe 
     *  a Property.</p>
     */
    public static final ObjectProperty implements_ = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#implements" );
    
    /** <p>Describes the prevailing environmental conditions for MeasurementCapabilites, 
     *  OperatingConditions and SurvivalRanges. Used for example to say that a sensor 
     *  has a particular accuracy in particular conditions. (see also MeasurementCapability)</p>
     */
    public static final ObjectProperty inCondition = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#inCondition" );
    
    /** <p>Relation between a Platform and a Deployment, recording that the object was 
     *  used as a platform for a system/sensor for a particular deployment: as in 
     *  this PhysicalObject is acting as a Platform inDeployment Deployment.</p>
     */
    public static final ObjectProperty inDeployment = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#inDeployment" );
    
    /** <p>Relation between a producer and a produced entity: for example, between a 
     *  sensor and the produced output.</p>
     */
    public static final ObjectProperty isProducedBy = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#isProducedBy" );
    
    /** <p>Relation between a FeatureOfInterest and a Property (a Quality observable 
     *  by a sensor) of that feature.</p>
     */
    public static final ObjectProperty isPropertyOf = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#isPropertyOf" );
    
    /** <p>A relation from a Stimulus to the Property that the Stimulus is serving as 
     *  a proxy for. For example, the expansion of the quicksilver is a stimulus that 
     *  serves as a proxy for temperature, or an increase or decrease in the spinning 
     *  of cups on a wind sensor is serving as a proxy for wind speed.</p>
     */
    public static final ObjectProperty isProxyFor = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#isProxyFor" );
    
    /** <p>Relation between a Sensor and Observations it has made.</p> */
    public static final ObjectProperty madeObservation = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#madeObservation" );
    
    /** <p>Relation linking an Observation (i.e., a description of the context, the Situation, 
     *  in which the observatioin was made) and a Result, which contains a value representing 
     *  the value associated with the observed Property.</p>
     */
    public static final ObjectProperty observationResult = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observationResult" );
    
    /** <p>The result time is the time when the procedure associated with the observation 
     *  act was applied.The result time shall describe the time when the result became 
     *  available, typically when the procedure associated with the observation was 
     *  completed For some observations this is identical to the phenomenonTime. However, 
     *  there are important cases where they differ.[O&amp;M]</p>
     */
    public static final ObjectProperty observationResultTime = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observationResultTime" );
    
    /** <p>The sampling time is the time that the result applies to the feature-of-interest. 
     *  This is the time usually required for geospatial analysis of the result.Rebadged 
     *  as phenomenon time in [O&amp;M]. The phenomenon time shall describe the time 
     *  that the result applies to the property of the feature-of-interest. This is 
     *  often the time of interaction by a sampling procedure or observation procedure 
     *  with a real-world feature.</p>
     */
    public static final ObjectProperty observationSamplingTime = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observationSamplingTime" );
    
    public static final ObjectProperty observedBy = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observedBy" );
    
    /** <p>Relation linking an Observation to the Property that was observed. The observedProperty 
     *  should be a Property (hasProperty) of the FeatureOfInterest (linked by featureOfInterest) 
     *  of this observation.</p>
     */
    public static final ObjectProperty observedProperty = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observedProperty" );
    
    /** <p>Relation between a Sensor and a Property that the sensor can observe. Note 
     *  that, given the DUL modelling of Qualities, a sensor defined with 'observes 
     *  only Windspeed' technically links the sensor to particular instances of Windspeed, 
     *  not to the concept itself - OWL can't express concept-concept relations, only 
     *  individual-individual. The property composition ensures that if an observation 
     *  is made of a particular quality then one can infer that the sensor observes 
     *  that quality.</p>
     */
    public static final ObjectProperty observes = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#observes" );
    
    /** <p>A relation between some aspect of a sensing entity and a feature. For example, 
     *  from a sensor to the features it can observe properties of, or from a deployment 
     *  to the features it was installed to observe. Also from a measurement capability 
     *  to the feature the capability is described for. (Used in conjunction with 
     *  forProperty).</p>
     */
    public static final ObjectProperty ofFeature = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#ofFeature" );
    
    /** <p>Relation between a System (e.g., a Sensor) and a Platform. The relation locates 
     *  the sensor relative to other described entities entities: i.e., the Sensor 
     *  s1's location is Platform p1. More precise locations for sensors in space 
     *  (relative to other entities, where attached to another entity, or in 3D space) 
     *  are made using DOLCE's Regions (SpaceRegion).</p>
     */
    public static final ObjectProperty onPlatform = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#onPlatform" );
    
    /** <p>Relation linking an Observation to the adjudged quality of the result. This 
     *  is of course complimentary to the MeasurementCapability information recorded 
     *  for the Sensor that made the Observation.</p>
     */
    public static final ObjectProperty qualityOfObservation = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#qualityOfObservation" );
    
    /** <p>A (measurement) procedure is a detailed description of a measurement according 
     *  to one or more measurement principles and to a given measurement method, based 
     *  on a measurement model and including any calculation to obtain a measurement 
     *  result [VIM 2.6]</p>
     */
    public static final ObjectProperty sensingMethodUsed = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#sensingMethodUsed" );
    
    public static final ObjectProperty startTime = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/ssn#startTime" );
    
    /** <p>The closeness of agreement between the value of an observation and the true 
     *  value of the observed quality.</p>
     */
    public static final OntClass Accuracy = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Accuracy" );
    
    /** <p>Total useful life of a battery.</p> */
    public static final OntClass BatteryLifetime = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#BatteryLifetime" );
    
    /** <p>Used to specify ranges for qualities that act as conditions on a system/sensor's 
     *  operation. For example, wind speed of 10-60m/s is expressed as a condition 
     *  linking a quality, wind speed, a unit of measurement, metres per second, and 
     *  a set of values, 10-60, and may be used as the condition on a MeasurementProperty, 
     *  for example, to state that a sensor has a particular accuracy in that condition.</p>
     */
    public static final OntClass Condition = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Condition" );
    
    /** <p>The ongoing Process of Entities (for the purposes of this ontology, mainly 
     *  sensors) deployed for a particular purpose. For example, a particular Sensor 
     *  deployed on a Platform, or a whole network of Sensors deployed for an observation 
     *  campaign. The deployment may have sub processes, such as installation, maintenance, 
     *  addition, and decomissioning and removal.</p>
     */
    public static final OntClass Deployment = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Deployment" );
    
    /** <p>Place to group all the various Processes related to Deployment. For example, 
     *  as well as Deplyment, installation, maintenance, deployment of further sensors 
     *  and the like would all be classified under DeploymentRelatedProcess.</p>
     */
    public static final OntClass DeploymentRelatedProcess = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#DeploymentRelatedProcess" );
    
    /** <p>An observed value for which the probability of falsely claiming the absence 
     *  of a component in a material is β, given a probability α of falsely claiming 
     *  its presence.</p>
     */
    public static final OntClass DetectionLimit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#DetectionLimit" );
    
    /** <p>A device is a physical piece of technology - a system in a box. Devices may 
     *  of course be built of smaller devices and software components (i.e. systems 
     *  have components).</p>
     */
    public static final OntClass Device = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Device" );
    
    /** <p>A, continuous or incremental, change in the reported values of observations 
     *  over time for an unchanging quality.</p>
     */
    public static final OntClass Drift = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Drift" );
    
    /** <p>A feature is an abstraction of real world phenomena (thing, person, event, 
     *  etc).</p>
     */
    public static final OntClass FeatureOfInterest = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#FeatureOfInterest" );
    
    /** <p>The smallest possible time between one observation and the next.</p> */
    public static final OntClass Frequency = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Frequency" );
    
    /** <p>Any information that is provided to a process for its use [MMI OntDev]</p> */
    public static final OntClass Input = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Input" );
    
    /** <p>The time between a request for an observation and the sensor providing a result.</p> */
    public static final OntClass Latency = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Latency" );
    
    /** <p>Schedule of maintenance for a system/sensor in the specified conditions.</p> */
    public static final OntClass MaintenanceSchedule = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#MaintenanceSchedule" );
    
    /** <p>Collects together measurement properties (accuracy, range, precision, etc) 
     *  and the environmental conditions in which those properties hold, representing 
     *  a specification of a sensor's capability in those conditions. The conditions 
     *  specified here are those that affect the measurement properties, while those 
     *  in OperatingRange represent the sensor's standard operating conditions, including 
     *  conditions that don't affect the observations.</p>
     */
    public static final OntClass MeasurementCapability = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#MeasurementCapability" );
    
    /** <p>An identifiable and observable characteristic of a sensor's observations or 
     *  ability to make observations.</p>
     */
    public static final OntClass MeasurementProperty = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#MeasurementProperty" );
    
    /** <p>The set of values that the sensor can return as the result of an observation 
     *  under the defined conditions with the defined measurement properties. (If 
     *  no conditions are specified or the conditions do not specify a range for the 
     *  observed qualities, the measurement range is to be taken as the condition 
     *  for the observed qualities.)</p>
     */
    public static final OntClass MeasurementRange = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#MeasurementRange" );
    
    /** <p>An Observation is a Situation in which a Sensing method has been used to estimate 
     *  or calculate a value of a Property of a FeatureOfInterest. Links to Sensing 
     *  and Sensor describe what made the Observation and how; links to Property and 
     *  Feature detail what was sensed; the result is the output of a Sensor; other 
     *  metadata details times etc.</p>
     */
    public static final OntClass Observation = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Observation" );
    
    /** <p>The value of the result of an Observation. An Observation has a result which 
     *  is the output of some sensor, the result is an information object that encodes 
     *  some value for a Feature.</p>
     */
    public static final OntClass ObservationValue = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#ObservationValue" );
    
    /** <p>Power range in which system/sensor is expected to operate.</p> */
    public static final OntClass OperatingPowerRange = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#OperatingPowerRange" );
    
    /** <p>An identifiable characteristic of the environmental and other conditions in 
     *  which the sensor is intended to operate. May include power ranges, power sources, 
     *  standard configurations, attachments and the like.</p>
     */
    public static final OntClass OperatingProperty = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#OperatingProperty" );
    
    /** <p>The environmental conditions and characteristics of a system/sensor's normal 
     *  operating environment. Can be used to specify for example the standard environmental 
     *  conditions in which the sensor is expected to operate (a Condition with no 
     *  OperatingProperty), or how the environmental and other operating properties 
     *  relate: i.e., that the maintenance schedule or power requirements differ according 
     *  to the conditions.</p>
     */
    public static final OntClass OperatingRange = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#OperatingRange" );
    
    /** <p>Any information that is reported from a process. [MMI OntDev]</p> */
    public static final OntClass Output = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Output" );
    
    /** <p>An Entity to which other Entities can be attached - particuarly Sensors and 
     *  other Platforms. For example, a post might act as the Platform, a bouy might 
     *  act as a Platform, or a fish might act as a Platform for an attached sensor.</p>
     */
    public static final OntClass Platform = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Platform" );
    
    /** <p>The closeness of agreement between replicate observations on an unchanged 
     *  or similar quality value: i.e., a measure of a sensor's ability to consitently 
     *  reproduce an observation.</p>
     */
    public static final OntClass Precision = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Precision" );
    
    /** <p>A process has an output and possibly inputs and, for a composite process, 
     *  describes the temporal and dataflow dependencies and relationships amongst 
     *  its parts. [SSN XG]</p>
     */
    public static final OntClass Process = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Process" );
    
    /** <p>An observable Quality of an Event or Object. That is, not a quality of an 
     *  abstract entity as is also allowed by DUL's Quality, but rather an aspect 
     *  of an entity that is intrinsic to and cannot exist without the entity and 
     *  is observable by a sensor.</p>
     */
    public static final OntClass Property = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Property" );
    
    /** <p>The smallest difference in the value of a quality being observed that would 
     *  result in perceptably different values of observation results.</p>
     */
    public static final OntClass Resolution = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Resolution" );
    
    /** <p>The time between a (step) change inthe value of an observed quality and a 
     *  sensor (possibly with specified error) 'settling' on an observed value.</p>
     */
    public static final OntClass ResponseTime = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#ResponseTime" );
    
    /** <p>Selectivity is a property of a sensor whereby it provides observed values 
     *  for one or more qualities such that the values of each quality are independent 
     *  of other qualities in the phenomenon, body, or substance being investigated.</p>
     */
    public static final OntClass Selectivity = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Selectivity" );
    
    /** <p>Sensing is a process that results in the estimation, or calculation, of the 
     *  value of a phenomenon.</p>
     */
    public static final OntClass Sensing = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Sensing" );
    
    /** <p>A sensing device is a device that implements sensing.</p> */
    public static final OntClass SensingDevice = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SensingDevice" );
    
    /** <p>Sensitivity is the quotient of the change in a result of sensor and the corresponding 
     *  change in a value of a quality being observed.</p>
     */
    public static final OntClass Sensitivity = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Sensitivity" );
    
    /** <p>A sensor can do (implements) sensing: that is, a sensor is any entity that 
     *  can follow a sensing method and thus observe some Property of a FeatureOfInterest. 
     *  Sensors may be physical devices, computational methods, a laboratory setup 
     *  with a person following a method, or any other thing that can follow a Sensing 
     *  Method to observe a Property.</p>
     */
    public static final OntClass Sensor = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Sensor" );
    
    /** <p>A data sheet records properties of a sensor. A data sheet might describe for 
     *  example the accuracy in various conditions, the power use, the types of connectors 
     *  that the sensor has, etc. Generally a sensor's properties are recorded directly 
     *  (with hasMeasurementCapability, for example), but the data sheet can be used 
     *  for example to record the manufacturers specifications verses observed capabilites, 
     *  or if more is known than the manufacturer specifies, etc. The data sheet is 
     *  an information object about the sensor's properties, rather than a direct 
     *  link to the actual properties themselves.</p>
     */
    public static final OntClass SensorDataSheet = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SensorDataSheet" );
    
    /** <p>An Event in the real world that 'triggers' the sensor. The properties associated 
     *  to the stimulus may be different to eventual observed property. It is the 
     *  event, not the object that triggers the sensor.</p>
     */
    public static final OntClass SensorInput = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SensorInput" );
    
    /** <p>A sensor outputs a piece of information (an observed value), the value itself 
     *  being represented by an ObservationValue.</p>
     */
    public static final OntClass SensorOutput = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SensorOutput" );
    
    /** <p>An Event in the real world that 'triggers' the sensor. The properties associated 
     *  to the stimulus may be different to eventual observed property. It is the 
     *  event, not the object that triggers the sensor.</p>
     */
    public static final OntClass Stimulus = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#Stimulus" );
    
    /** <p>An identifiable characteristic that represents the extent of the sensors useful 
     *  life. Might include for example total battery life or number of recharges, 
     *  or, for sensors that are used only a fixed number of times, the number of 
     *  observations that can be made before the sensing capability is depleted.</p>
     */
    public static final OntClass SurvivalProperty = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SurvivalProperty" );
    
    /** <p>The conditions a sensor can be exposed to without damage: i.e., the sensor 
     *  continues to operate as defined using MeasurementCapability. If, however, 
     *  the SurvivalRange is exceeded, the sensor is 'damaged' and MeasurementCapability 
     *  specifications may no longer hold.</p>
     */
    public static final OntClass SurvivalRange = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SurvivalRange" );
    
    /** <p>System is a unit of abstraction for pieces of infrastructure (and we largely 
     *  care that they are) for sensing. A system has components, its subsystems, 
     *  which are other systems.</p>
     */
    public static final OntClass System = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#System" );
    
    /** <p>Total useful life of a sensor/system (expressed as total life since manufacture, 
     *  time in use, number of operations, etc.).</p>
     */
    public static final OntClass SystemLifetime = m_model.createClass( "http://purl.oclc.org/NET/ssnx/ssn#SystemLifetime" );
    
    
    /**
     * Acrescentadas para HW
     */
    
    public static final DatatypeProperty hasQuantityValue = m_model.createDatatypeProperty("http://purl.oclc.org/NET/ssnx/ssn#hasQuantityValue" );
    
    public static final AnnotationProperty identifier = m_model.createAnnotationProperty("http://purl.oclc.org/NET/ssnx/ssn#identifier");
    
    public static final DatatypeProperty hasOutputValue = m_model.createDatatypeProperty("http://purl.oclc.org/NET/ssnx/ssn#hasOutputValue" );
    public static final DatatypeProperty hasOutputValueAux = m_model.createDatatypeProperty("http://purl.oclc.org/NET/ssnx/ssn#hasOutputValueAux" );
    public static final DatatypeProperty hasOutputUnit = m_model.createDatatypeProperty("http://purl.oclc.org/NET/ssnx/ssn#hasOutputUnit" );
    
    
}
