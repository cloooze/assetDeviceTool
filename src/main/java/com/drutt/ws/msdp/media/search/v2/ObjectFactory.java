
package com.drutt.ws.msdp.media.search.v2;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.drutt.ws.msdp.media.search.v2 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.drutt.ws.msdp.media.search.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchAssetsRequest }
     * 
     */
    public SearchAssetsRequest createSearchAssetsRequest() {
        return new SearchAssetsRequest();
    }

    /**
     * Create an instance of {@link Asset }
     * 
     */
    public Asset createAsset() {
        return new Asset();
    }

    /**
     * Create an instance of {@link SearchAssetsResponse }
     * 
     */
    public SearchAssetsResponse createSearchAssetsResponse() {
        return new SearchAssetsResponse();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link Meta }
     * 
     */
    public Meta createMeta() {
        return new Meta();
    }

    /**
     * Create an instance of {@link GetAssetsByTicketIdRequest }
     * 
     */
    public GetAssetsByTicketIdRequest createGetAssetsByTicketIdRequest() {
        return new GetAssetsByTicketIdRequest();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link Group }
     * 
     */
    public Group createGroup() {
        return new Group();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link SortItem }
     * 
     */
    public SortItem createSortItem() {
        return new SortItem();
    }

    /**
     * Create an instance of {@link GetAssetsByTicketIdResponse }
     * 
     */
    public GetAssetsByTicketIdResponse createGetAssetsByTicketIdResponse() {
        return new GetAssetsByTicketIdResponse();
    }

    /**
     * Create an instance of {@link WSException }
     * 
     */
    public WSException createWSException() {
        return new WSException();
    }

}
