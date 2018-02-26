package br.ufg.inf.mestrado.hermeswidget.ontologies;
/* CVS $Id: $ */
 
import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.rdf.model.*;

 
/**
 * Vocabulary definitions from qu.owl 
 * @author Auto-generated by schemagen on 19 mai 2017 00:35 
 */
public class QU {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://purl.oclc.org/NET/ssnx/qu/qu#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>A Reference to the QuantityKind that represents the base quantity dimension 
     *  in the factor.</p>
     */
    public static final ObjectProperty baseDimension = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#baseDimension" );
    
    /** <p>Ordered set of QuantityKind that specifies the base quantities of the system 
     *  of quantities. This is a subset of the complete quantityKind list. The base 
     *  quantities define the basis for the quantity dimension of a kind of quantity.</p>
     */
    public static final ObjectProperty baseQuantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#baseQuantityKind" );
    
    /** <p>Ordered set of Unit that specifies the base units of the system of units. 
     *  A "base unit" is defined in [VIM] as a "measurement unit that is adopted by 
     *  convention for a base quantity," i.e. it is the (preferred) unit in which 
     *  base quantities of the associated systemOfQuantities are expressed.</p>
     */
    public static final ObjectProperty baseUnit = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#baseUnit" );
    
    /** <p>Derived ordered set of Dimension. The actual dimension of a QuantityKind depends 
     *  on the list of baseQuantityKind that are specified in an actual SystemOfQuantities, 
     *  see the DerivedDimensions constraint.</p>
     */
    public static final ObjectProperty dimension = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#dimension" );
    
    /** <p>Rational number that specifies the factor in the dimension conversion relationship.</p> */
    public static final ObjectProperty dimensionFactor = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#dimensionFactor" );
    
    /** <p>Specification of the associated QuantityKind.</p> */
    public static final ObjectProperty factorQuantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#factorQuantityKind" );
    
    /** <p>A generalization relationship between two kinds of quantities.</p> */
    public static final ObjectProperty generalQuantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#generalQuantityKind" );
    
    /** <p>Ordered set of Prefix that specifies the prefixes for multiples and submultiples 
     *  of units in the system</p>
     */
    public static final ObjectProperty prefix = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#prefix" );
    
    /** <p>Specification of the associated ProeprtyType.</p> */
    public static final ObjectProperty propertyType = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#propertyType" );
    
    /** <p>Quantities attached to a system.</p> */
    public static final ObjectProperty quantityComponent = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#quantityComponent" );
    
    /** <p>Specification of the associated QuantityKind.</p> */
    public static final ObjectProperty quantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#quantityKind" );
    
    /** <p>Rational number that specifies the factor in the quantity conversion relationship.</p> */
    public static final ObjectProperty quantityKindFactor = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#quantityKindFactor" );
    
    /** <p>Specifies the unit with respect to which the ConversionBasedUnit is defined.</p> */
    public static final ObjectProperty referenceUnit = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#referenceUnit" );
    
    /** <p>Specification of a Scale that is associated to the QuantityKind.</p> */
    public static final ObjectProperty scale = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#scale" );
    
    /** <p>Ordered set of ScaleValueDefinition that specifies the defined numerical value(s) 
     *  and textual definition(s) for the measurement scale.</p>
     */
    public static final ObjectProperty scaleValueDefinition = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#scaleValueDefinition" );
    
    /** <p>A specialization relationship between two kinds of quantities.</p> */
    public static final ObjectProperty specificQuantityKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#specificQuantityKind" );
    
    /** <p>Reference to the SystemOfQuantities for which the units are specified.</p> */
    public static final ObjectProperty systemOfQuantities = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#systemOfQuantities" );
    
    /** <p>Specification of the associated Unit.</p> */
    public static final ObjectProperty unit = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#unit" );
    
    /** <p>Ordered set of Unit that specifies the units that are known in the system.</p> */
    public static final ObjectProperty unitComponent = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#unitComponent" );
    
    /** <p>Rational number that specifies the factor in the unit conversion relationship.</p> */
    public static final ObjectProperty unitFactor = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#unitFactor" );
    
    /** <p>Specification of the associated Unit "Kind".</p> */
    public static final ObjectProperty unitKind = m_model.createObjectProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#unitKind" );
    
    /** <p>A code is a string that uniquely identifies an individual.</p> */
    public static final DatatypeProperty code = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#code" );
    
    /** <p>Rational number that specifies the factor in the unit conversion relationship.</p> */
    public static final DatatypeProperty conversionFactor = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#conversionFactor" );
    
    /** <p>Rational number that specifies the offset in the unit conversion relationship.</p> */
    public static final DatatypeProperty conversionOffset = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#conversionOffset" );
    
    /** <p>URI that references an external definition.</p> */
    public static final DatatypeProperty definitionURI = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#definitionURI" );
    
    /** <p>Textual description</p> */
    public static final DatatypeProperty description = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#description" );
    
    /** <p>Rational number that specifies the exponent of the power to which the unit 
     *  is raised.</p>
     */
    public static final DatatypeProperty exponent = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#exponent" );
    
    /** <p>Specifies the unit conversion relationship in some expression syntax.</p> */
    public static final DatatypeProperty expression = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#expression" );
    
    public static final DatatypeProperty name = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#name" );
    
    /** <p>Specifies the numerical value.</p> */
    public static final DatatypeProperty numericalValue = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#numericalValue" );
    
    /** <p>Short symbolic name.</p> */
    public static final DatatypeProperty symbol = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#symbol" );
    
    /** <p>Symbolic expression of the quantity dimension's product of powers, in terms 
     *  of symbols of the kinds of quantity that represent the base kinds of quantity 
     *  and their exponents.</p>
     */
    public static final DatatypeProperty symbolicExpression = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#symbolicExpression" );
    
    /** <p>Specifies the multiple or submultiple multiplication factor.</p> */
    public static final DatatypeProperty unitMultipleFactor = m_model.createDatatypeProperty( "http://purl.oclc.org/NET/ssnx/qu/qu#unitMultipleFactor" );
    
    /** <p>A ConversionBasedUnit is an abstract classifier that is a Unit that represents 
     *  a measurement unit that is defined with respect to another reference unit 
     *  through an explicit conversion relationship.</p>
     */
    public static final OntClass ConversionBasedUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#ConversionBasedUnit" );
    
    /** <p>A DerivedQuantityKind is a QuantityKind that represents a kind of quantity 
     *  that is defined as a product of powers of one or more other kinds of quantity. 
     *  A DerivedQuantityKind may also be used to define a synonym kind of quantity 
     *  for another kind of quantity. For example "velocity" can be specified as the 
     *  product of "length" to the power one times "time" to the power minus one, 
     *  and subsequently "speed" can be specified as "velocity" to the power one.</p>
     */
    public static final OntClass DerivedQuantityKind = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#DerivedQuantityKind" );
    
    /** <p>A DerivedUnit is a Unit that represents a measurement unit that is defined 
     *  as a product of powers of one or more other measurement units. For example 
     *  the measurement unit "metre per second" for "velocity" is specified as the 
     *  product of "metre" to the power one times "second" to the power minus one</p>
     */
    public static final OntClass DerivedUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#DerivedUnit" );
    
    /** <p>A Dimension represents the [VIM] concept of 'quantity dimension' that is defined 
     *  as 'expression of the dependence of a quantity on the base quantities of a 
     *  system of quantities as a product of powers of factors corresponding to the 
     *  base quantities, omitting any numerical factor.' For example in the ISQ the 
     *  quantity dimension of 'force' is denoted by dim F = L�M�T^2, where 'F' 
     *  is the symbol for 'force', and 'L', 'M', 'T' are the symbols for the ISQ base 
     *  quantities 'length', 'mass' and 'time' respectively. The Dimension of any 
     *  QuantityKind can be derived through the algorithm that is defined in C.5.3.20 
     *  with SystemOfQuantities. The actual Dimension for a given QuantityKind depends 
     *  on the choice of baseQuantityKind specified in a SystemOfQuantities.</p>
     */
    public static final OntClass Dimension = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#Dimension" );
    
    /** <p>A DimensionFactor represents a factor in the product of powers that defines 
     *  a Dimension.</p>
     */
    public static final OntClass DimensionFactor = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#DimensionFactor" );
    
    /** <p>A GeneralConversionUnit is a ConversionBasedUnit that represents a measurement 
     *  unit that is defined with respect to another reference measurement unit through 
     *  a conversion relationship expressed in some syntax through a general mathematical 
     *  expression. The unit conversion relationship is defined by the following equation: 
     *  valueRU / valueCU = f(valueRU, valueCU) where: valueRU is the quantity value 
     *  expressed in the referenceUnit, and, valueCU is the quantity value expressed 
     *  in the GeneralConversionUnit, and, f(valueRU, valueCU) is a mathematical expression 
     *  that includes valueRU and valueCU.</p>
     */
    public static final OntClass GeneralConversionUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#GeneralConversionUnit" );
    
    /** <p>A LinearConversionUnit is a ConversionBasedUnit that represents a measurement 
     *  unit that is defined with respect to another measurement reference unit through 
     *  a linear conversion relationship with a conversion factor. The unit conversion 
     *  relationship is defined by the following equation: valueRU = factor � valueCU, 
     *  where: valueRU is the quantity value expressed in the referenceUnit, and, 
     *  valueCU is the quantity value expressed in the LinearConversionUnit.</p>
     */
    public static final OntClass LinearConversionUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#LinearConversionUnit" );
    
    /** <p>A Prefix represents a named multiple or submultiple multiplication factor 
     *  used in the specification of a PrefixedUnit. A SystemOfUnits may specify a 
     *  set of prefixes.</p>
     */
    public static final OntClass Prefix = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#Prefix" );
    
    /** <p>A Prefix represents a named multiple or submultiple multiplication factor 
     *  used in the specification of a PrefixedUnit. A SystemOfUnits may specify a 
     *  set of prefixes.</p>
     */
    public static final OntClass PrefixedUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#PrefixedUnit" );
    
    /** <p>A PropertyKind is a meta-property which helps to characterise categories of 
     *  properties e.g. scalar, vector</p>
     */
    public static final OntClass PropertyKind = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#PropertyKind" );
    
    /** <p>A QuantityKind is an abstract classifier that represents the [VIM] concept 
     *  of "kind of quantity" that is defined as "aspect common to mutually comparable 
     *  quantities." A QuantityKind represents the essence of a quantity without any 
     *  numerical value or unit. Quantities of the same kind within a given system 
     *  of quantities have the same quantity dimension. However, quantities of the 
     *  same dimension are not necessarily of the same kind.</p>
     */
    public static final OntClass QuantityKind = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#QuantityKind" );
    
    /** <p>A QuantityKindFactor represents a factor in the product of powers that defines 
     *  a DerivedQuantityKind.</p>
     */
    public static final OntClass QuantityKindFactor = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#QuantityKindFactor" );
    
    /** <p>A Scale represents the [VIM] concept of a "measurement scale" that is defined 
     *  as an "ordered set of quantity values of quantities of a given kind of quantity 
     *  used in ranking, according to magnitude, quantities of that kind." A Scale 
     *  specifies one or more fixed values that have a specific significance in the 
     *  definition of the associating QuantityKind. For example the "thermodynamic 
     *  temperature" kind of quantity is defined by specifying the values of 0 and 
     *  273.16 kelvin as the temperatures of absolute zero and the triple point of 
     *  water respectively. A Scale does not always need to specify a unit. For example 
     *  the "Rockwell C Hardness Scale" or the "Beaufort Wind Force Scale" are ordinal 
     *  scales that do not have a particular associated unit. Similarly, subjective 
     *  scales for a "priority" or "risk" kind of quantity with e.g. value definitions 
     *  0 for "low", 1 for "medium" and 3 for "high" do not have a particular associated 
     *  unit.</p>
     */
    public static final OntClass Scale = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#Scale" );
    
    /** <p>A ScaleValueDefinition represents a specific value for a measurement scale.</p> */
    public static final OntClass ScaleValueDefinition = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#ScaleValueDefinition" );
    
    /** <p>A SimpleQuantityKind is a QuantityKind that represents a kind of quantity 
     *  that does not depend on any other QuantityKind. Typically a base quantity 
     *  would be specified as a SimpleQuantityKind.</p>
     */
    public static final OntClass SimpleQuantityKind = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#SimpleQuantityKind" );
    
    /** <p>A SimpleUnit is a Unit that represents a measurement unit that does not depend 
     *  on any other Unit. Typically a base unit would be specified as a SimpleUnit.</p>
     */
    public static final OntClass SimpleUnit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#SimpleUnit" );
    
    /** <p>A SpecializedQuantityKind is a QuantityKind that represents a kind of quantity 
     *  that is a specialization of another kind of quantity. For example, "distance", 
     *  "width", "depth", "radius" and "wavelength" can all be specified as specializations 
     *  of the "length" SimpleQuantityKind.</p>
     */
    public static final OntClass SpecializedQuantityKind = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#SpecializedQuantityKind" );
    
    /** <p>A SystemOfQuantities represents the [VIM] concept of 'system of quantities' 
     *  that is defined as a 'set of quantities together with a set of non-contradictory 
     *  equations relating those quantities'. It collects a list of QuantityKind that 
     *  specifies the kinds of quantity that are known in the system. The International 
     *  System of Quantities (ISQ) is an example of a SystemOfQuantities, defined 
     *  in ISO 31 and ISO/IEC 80000.</p>
     */
    public static final OntClass SystemOfQuantities = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#SystemOfQuantities" );
    
    /** <p>A SystemOfUnits represents the [VIM] concept of 'system of units' that is 
     *  defined as 'set of base units and derived units, together with their multiples 
     *  and submultiples, defined in accordance with given rules, for a given system 
     *  of quantities'. It collects a list of Unit that are known in the system. A 
     *  SysML SystemOfUnits only optionally defines multiples and submultiples.</p>
     */
    public static final OntClass SystemOfUnits = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#SystemOfUnits" );
    
    /** <p>A Unit is an abstract classifier that represents the [VIM] concept of "measurement 
     *  unit" that is defined as "real scalar quantity, defined and adopted by convention, 
     *  with which any other quantity of the same kind can be compared to express 
     *  the ratio of the two quantities as a number."</p>
     */
    public static final OntClass Unit = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#Unit" );
    
    /** <p>A UnitFactor represents a factor in the product of powers that defines a DerivedUnit.</p> */
    public static final OntClass UnitFactor = m_model.createClass( "http://purl.oclc.org/NET/ssnx/qu/qu#UnitFactor" );
    
}