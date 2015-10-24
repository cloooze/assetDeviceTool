
package com.drutt.ws.msdp.media.search.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="item">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.drutt.com/msdp/media/search/v2}metaAssociated">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contentType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="downloadUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accessUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="giftUri" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="devicePreferred" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="referencedItem" type="{http://ws.drutt.com/msdp/media/search/v2}item" minOccurs="0"/>
 *         &lt;element name="device" type="{http://ws.drutt.com/msdp/media/search/v2}device" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "item", propOrder = {
    "type",
    "uri",
    "contentType",
    "filename",
    "size",
    "downloadUri",
    "accessUri",
    "giftUri",
    "devicePreferred",
    "referencedItem",
    "device"
})
public class Item
    extends MetaAssociated
{

    protected String type;
    @XmlElement(required = true)
    protected String uri;
    @XmlElement(required = true)
    protected String contentType;
    @XmlElement(required = true)
    protected String filename;
    protected long size;
    @XmlElement(required = true)
    protected String downloadUri;
    @XmlElement(required = true)
    protected String accessUri;
    @XmlElement(required = true)
    protected String giftUri;
    protected Boolean devicePreferred;
    protected Item referencedItem;
    @XmlElement(nillable = true)
    protected List<Device> device;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContentType(String value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the downloadUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadUri() {
        return downloadUri;
    }

    /**
     * Sets the value of the downloadUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadUri(String value) {
        this.downloadUri = value;
    }

    /**
     * Gets the value of the accessUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessUri() {
        return accessUri;
    }

    /**
     * Sets the value of the accessUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessUri(String value) {
        this.accessUri = value;
    }

    /**
     * Gets the value of the giftUri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGiftUri() {
        return giftUri;
    }

    /**
     * Sets the value of the giftUri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGiftUri(String value) {
        this.giftUri = value;
    }

    /**
     * Gets the value of the devicePreferred property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDevicePreferred() {
        return devicePreferred;
    }

    /**
     * Sets the value of the devicePreferred property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDevicePreferred(Boolean value) {
        this.devicePreferred = value;
    }

    /**
     * Gets the value of the referencedItem property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getReferencedItem() {
        return referencedItem;
    }

    /**
     * Sets the value of the referencedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setReferencedItem(Item value) {
        this.referencedItem = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the device property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDevice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Device }
     * 
     * 
     */
    public List<Device> getDevice() {
        if (device == null) {
            device = new ArrayList<Device>();
        }
        return this.device;
    }

}
