
package org.uddi.digitalindiatx.types;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.uddi.digitalindiatx.types package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Balance_QNAME = new QName("http://uddi.org/digitalindiatx/types", "balance");
    private final static QName _ToAccount_QNAME = new QName("http://uddi.org/digitalindiatx/types", "to-account");
    private final static QName _Recept_QNAME = new QName("http://uddi.org/digitalindiatx/types", "recept");
    private final static QName _FromAccount_QNAME = new QName("http://uddi.org/digitalindiatx/types", "from-account");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.uddi.digitalindiatx.types
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayRecept }
     * 
     */
    public PayRecept createPayRecept() {
        return new PayRecept();
    }

    /**
     * Create an instance of {@link UddiPayment }
     * 
     */
    public UddiPayment createUddiPayment() {
        return new UddiPayment();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uddi.org/digitalindiatx/types", name = "balance")
    public JAXBElement<Double> createBalance(Double value) {
        return new JAXBElement<Double>(_Balance_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UddiPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uddi.org/digitalindiatx/types", name = "to-account")
    public JAXBElement<UddiPayment> createToAccount(UddiPayment value) {
        return new JAXBElement<UddiPayment>(_ToAccount_QNAME, UddiPayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayRecept }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uddi.org/digitalindiatx/types", name = "recept")
    public JAXBElement<PayRecept> createRecept(PayRecept value) {
        return new JAXBElement<PayRecept>(_Recept_QNAME, PayRecept.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UddiPayment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://uddi.org/digitalindiatx/types", name = "from-account")
    public JAXBElement<UddiPayment> createFromAccount(UddiPayment value) {
        return new JAXBElement<UddiPayment>(_FromAccount_QNAME, UddiPayment.class, null, value);
    }

}
