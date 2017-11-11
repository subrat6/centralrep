
package org.uddi.digitalindiatx.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UddiGateWayManager", targetNamespace = "http://uddi.org/digitalindiatx/service", wsdlLocation = "file:/E:/DataStructuresprogram/newworkspace/UDDIGatewayService/WebContent/WEB-INF/UddiGateWayManager.wsdl")
public class UddiGateWayManager_Service
    extends Service
{

    private final static URL UDDIGATEWAYMANAGER_WSDL_LOCATION;
    private final static WebServiceException UDDIGATEWAYMANAGER_EXCEPTION;
    private final static QName UDDIGATEWAYMANAGER_QNAME = new QName("http://uddi.org/digitalindiatx/service", "UddiGateWayManager");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/E:/DataStructuresprogram/newworkspace/UDDIGatewayService/WebContent/WEB-INF/UddiGateWayManager.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        UDDIGATEWAYMANAGER_WSDL_LOCATION = url;
        UDDIGATEWAYMANAGER_EXCEPTION = e;
    }

    public UddiGateWayManager_Service() {
        super(__getWsdlLocation(), UDDIGATEWAYMANAGER_QNAME);
    }

    public UddiGateWayManager_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), UDDIGATEWAYMANAGER_QNAME, features);
    }

    public UddiGateWayManager_Service(URL wsdlLocation) {
        super(wsdlLocation, UDDIGATEWAYMANAGER_QNAME);
    }

    public UddiGateWayManager_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, UDDIGATEWAYMANAGER_QNAME, features);
    }

    public UddiGateWayManager_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UddiGateWayManager_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UddiGateWayManager
     */
    @WebEndpoint(name = "UddiGateWayManagerSOAPPort")
    public UddiGateWayManager getUddiGateWayManagerSOAPPort() {
        return super.getPort(new QName("http://uddi.org/digitalindiatx/service", "UddiGateWayManagerSOAPPort"), UddiGateWayManager.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UddiGateWayManager
     */
    @WebEndpoint(name = "UddiGateWayManagerSOAPPort")
    public UddiGateWayManager getUddiGateWayManagerSOAPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://uddi.org/digitalindiatx/service", "UddiGateWayManagerSOAPPort"), UddiGateWayManager.class, features);
    }

    private static URL __getWsdlLocation() {
        if (UDDIGATEWAYMANAGER_EXCEPTION!= null) {
            throw UDDIGATEWAYMANAGER_EXCEPTION;
        }
        return UDDIGATEWAYMANAGER_WSDL_LOCATION;
    }

}
