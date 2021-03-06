package br.ufg.inf.mestrado.hermeswidget.ontologies;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*;

/**
 * Vocabulary definitions from iot-lite.owl 
 * @author Auto-generated by schemagen on 27 mar 2018 14:30 
 */
public class IoT_Lite {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>The ontology's owl:versionInfo as a string</p> */
    public static final String VERSION_INFO = "0.4";
    
    /** <p>A device is exposed by a service.</p> */
    public static final ObjectProperty exposedBy = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#exposedBy" );
    
    /** <p>For service-oriented queries. The inverse of exposedBy.</p> */
    public static final ObjectProperty exposes = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#exposes" );
    
    /** <p>Links the devices with their attributes.</p> */
    public static final ObjectProperty hasAttribute = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasAttribute" );
    
    /** <p>Links the devices with their coverages.</p> */
    public static final ObjectProperty hasCoverage = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasCoverage" );
    
    /** <p>Links any concept with metadata about that concept.</p> */
    public static final ObjectProperty hasMetadata = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasMetadata" );
    
    /** <p>Links a sensor or an attribute with the quantity kind it measures (e.g. A 
     *  sensor -sensor1- measures temperature: sensor1 hasQuantityKind temperature).</p>
     */
    public static final ObjectProperty hasQuantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasQuantityKind" );
    
    /** <p>Links a sensor with a sensing device the same way as SSN.</p> */
    public static final ObjectProperty hasSensingDevice = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasSensingDevice" );
    
    /** <p>Links the sensor with the units of the quantity kind it measures (e.g. A sensor 
     *  -sensor1- measures temperature in Celsius: senso1 hasUnit celsius).</p>
     */
    public static final ObjectProperty hasUnit = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#hasUnit" );
    
    /** <p>Defines the associations between objects and sensors (e.g. A table (object) 
     *  has an attribute (temperature at the table) which is associated with a sensor 
     *  (the temperature sensor of the room).</p>
     */
    public static final ObjectProperty isAssociatedWith = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#isAssociatedWith" );
    
    /** <p>This defines that a devices system is a subsystem of another system. For example, 
     *  a multi-sensor device is a subsystem of a smart building testbed. This is 
     *  the inverse of the SSN object property "hasSubSystem". It allows a graph to 
     *  start from a subsystem. This is useful for resource-centric graphs.</p>
     */
    public static final ObjectProperty isSubSystemOf = m_model.createObjectProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#isSubSystemOf" );
    
    /** <p>Endpoint of the service. It is usually a URL where the service is available.</p> */
    public static final DatatypeProperty endpoint = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#endpoint" );
    
    /** <p>The ID of the Device or Entity</p> */
    public static final DatatypeProperty id = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#id" );
    
    /** <p>Interface Description of the service, e.g WADL, WSDL, NGSI9 etc.</p> */
    public static final DatatypeProperty interfaceDescription = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#interfaceDescription" );
    
    /** <p>Defines the type of interface of the service endpoint, e.g. RESTful, NGSI-9, 
     *  MQTT, CoAP etc.</p>
     */
    public static final DatatypeProperty interfaceType = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#interfaceType" );
    
    /** <p>Is the Device mobile? This can be used by an IoT management platform to enable 
     *  tracking of the device's location.</p>
     */
    public static final DatatypeProperty isMobile = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#isMobile" );
    
    /** <p>Is the IoT Service exposing the Resource, or associated with the Entity, online?</p> */
    public static final DatatypeProperty isOnline = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#isOnline" );
    
    /** <p>Defines the type pf the metadata value (e.g. resolution of the sensor).</p> */
    public static final DatatypeProperty metadataType = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#metadataType" );
    
    /** <p>Value of the metadata</p> */
    public static final DatatypeProperty metadataValue = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#metadataValue" );
    
    /** <p>Specifies the radius of a circle coverage defined by a point -the center of 
     *  the circle- and its radius.</p>
     */
    public static final DatatypeProperty radius = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#radius" );
    
    /** <p>Relative Altitude can be used in place of an absolute altitude, especially 
     *  in buildings, where it makes more sense to locate by levels or floors. For 
     *  example the value "0" would indicate "ground floor", and "1" would indicate 
     *  "1st floor" and so on.</p>
     */
    public static final AnnotationProperty altRelative = m_model.createAnnotationProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#altRelative" );
    
    /** <p>Relative Location is used to provide a place for where the Device is in. For 
     *  example, Geonames URIs can be used to represent a place, city, area, or region. 
     *  For "University of Surrey" this would be "http://sws.geonames.org/6695971/"</p>
     */
    public static final AnnotationProperty relativeLocation = m_model.createAnnotationProperty( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#relativeLocation" );
    
    /** <p>Device that can actuate over an object or QuantityKind.</p> */
    public static final OntClass ActuatingDevice = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#ActuatingDevice" );
    
    /** <p>An attribute of an IoT object that can be exposed by an IoT service (i.e. 
     *  a room (IoT Object) has a temperature (Attribute), that can be exposed by 
     *  a temperature sensor (IoT device).</p>
     */
    public static final OntClass Attribute = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Attribute" );
    
    /** <p>Circle coverage it needs the location of the sensor as the centre of the circle 
     *  and the radius as a DataProperty.</p>
     */
    public static final OntClass Circle = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Circle" );
    
    /** <p>The coverage of an IoT device (i.e. a temperature sensor inside a room has 
     *  a coverage of that room).</p>
     */
    public static final OntClass Coverage = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Coverage" );
    
    /** <p>Any object that is relevant from a user or application perspective. (IoT-A 
     *  Definition)</p>
     */
    public static final OntClass Entity = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Entity" );
    
    /** <p>Class used to describe properties that cannot be described by QuantityKind 
     *  and Units. i.e. the resolution of a sensor.</p>
     */
    public static final OntClass Metadata = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Metadata" );
    
    /** <p>IoT entity</p> */
    public static final OntClass Object = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Object" );
    
    /** <p>The coverage is made up by linking several points by strait lines.</p> */
    public static final OntClass Polygon = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Polygon" );
    
    /** <p>The coverage is made up by giving two points which are the opposite corners 
     *  of a rectangle.</p>
     */
    public static final OntClass Rectangle = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Rectangle" );
    
    /** <p>Service provided by an IoT Device</p> */
    public static final OntClass Service = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#Service" );
    
    /** <p>Tag Device such as QR code or bar code.</p> */
    public static final OntClass TagDevice = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#TagDevice" );
    

    public static final OntClass VirtualEntity = m_model.createClass( "http://purl.oclc.org/NET/UNIS/fiware/iot-lite#VirtualEntity" );
    
}
