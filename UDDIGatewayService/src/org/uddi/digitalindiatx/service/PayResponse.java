
package org.uddi.digitalindiatx.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.uddi.digitalindiatx.types.PayRecept;


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
 *         &lt;element ref="{http://uddi.org/digitalindiatx/types}recept"/>
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
    "recept"
})
@XmlRootElement(name = "payResponse")
public class PayResponse {

    @XmlElement(namespace = "http://uddi.org/digitalindiatx/types", required = true)
    protected PayRecept recept;

    /**
     * Gets the value of the recept property.
     * 
     * @return
     *     possible object is
     *     {@link PayRecept }
     *     
     */
    public PayRecept getRecept() {
        return recept;
    }

    /**
     * Sets the value of the recept property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayRecept }
     *     
     */
    public void setRecept(PayRecept value) {
        this.recept = value;
    }

}
