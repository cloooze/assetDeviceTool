
package com.drutt.ws.msdp.media.management.v3;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MediaManagementService", targetNamespace = "http://ws.drutt.com/msdp/media/management/v3", wsdlLocation = "http://10.1.10.5:8081/repository/wsdl/mngapi-v3.wsdl")
public class MediaManagementService
    extends Service
{

    private final static URL MEDIAMANAGEMENTSERVICE_WSDL_LOCATION;
    private final static WebServiceException MEDIAMANAGEMENTSERVICE_EXCEPTION;
    private final static QName MEDIAMANAGEMENTSERVICE_QNAME = new QName("http://ws.drutt.com/msdp/media/management/v3", "MediaManagementService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://127.0.0.1:8081/repository/wsdl/mngapi-v3.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MEDIAMANAGEMENTSERVICE_WSDL_LOCATION = url;
        MEDIAMANAGEMENTSERVICE_EXCEPTION = e;
    }

    public MediaManagementService() {
        super(__getWsdlLocation(), MEDIAMANAGEMENTSERVICE_QNAME);
    }

    public MediaManagementService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MEDIAMANAGEMENTSERVICE_QNAME, features);
    }

    public MediaManagementService(URL wsdlLocation) {
        super(wsdlLocation, MEDIAMANAGEMENTSERVICE_QNAME);
    }

    public MediaManagementService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MEDIAMANAGEMENTSERVICE_QNAME, features);
    }

    public MediaManagementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MediaManagementService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MediaManagementApi
     */
    @WebEndpoint(name = "MediaMngServiceImplPort")
    public MediaManagementApi getMediaMngServiceImplPort() {
        return super.getPort(new QName("http://ws.drutt.com/msdp/media/management/v3", "MediaMngServiceImplPort"), MediaManagementApi.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MediaManagementApi
     */
    @WebEndpoint(name = "MediaMngServiceImplPort")
    public MediaManagementApi getMediaMngServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.drutt.com/msdp/media/management/v3", "MediaMngServiceImplPort"), MediaManagementApi.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MEDIAMANAGEMENTSERVICE_EXCEPTION!= null) {
            throw MEDIAMANAGEMENTSERVICE_EXCEPTION;
        }
        return MEDIAMANAGEMENTSERVICE_WSDL_LOCATION;
    }

}
