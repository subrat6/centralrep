
package org.uddi.digitalindiatx.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.digitalindiatx.types.UddiPayment;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://uddi.org/digitalindiatx/types}to-account"/>
 *         &lt;element ref="{http://uddi.org/digitalindiatx/types}from-account"/>
 *         &lt;element ref="{http://uddi.org/digitalindiatx/types}balance"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "toAccount",
    "fromAccount",
    "balance"
})
@XmlRootElement(name = "pay")
public class Pay {

    @XmlElement(name = "to-account", namespace = "http://uddi.org/digitalindiatx/types", required = true)
    protected UddiPayment toAccount;
    @XmlElement(name = "from-account", namespace = "http://uddi.org/digitalindiatx/types", required = true)
    protected UddiPayment fromAccount;
    @XmlElement(namespace = "http://uddi.org/digitalindiatx/types")
    protected double balance;

    /**
     * Gets the value of the toAccount property.
     * 
     * @return
     *     possible object is
     *     {@link UddiPayment }
     *     
     */
    public UddiPayment getToAccount() {
        return toAccount;
    }

    /**
     * Sets the value of the toAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UddiPayment }
     *     
     */
    public void setToAccount(UddiPayment value) {
        this.toAccount = value;
    }

    /**
     * Gets the value of the fromAccount property.
     * 
     * @return
     *     possible object is
     *     {@link UddiPayment }
     *     
     */
    public UddiPayment getFromAccount() {
        return fromAccount;
    }

    /**
     * Sets the value of the fromAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link UddiPayment }
     *     
     */
    public void setFromAccount(UddiPayment value) {
        this.fromAccount = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     */
    public void setBalance(double value) {
        this.balance = value;
    }

}
