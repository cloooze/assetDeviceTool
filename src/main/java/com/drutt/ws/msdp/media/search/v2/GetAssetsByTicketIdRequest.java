
package com.drutt.ws.msdp.media.search.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="ticketId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="langCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startNum" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sortItem" type="{http://ws.drutt.com/msdp/media/search/v2}sortItem" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="includeItems" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ticketId",
    "deviceId",
    "langCode",
    "startNum",
    "pageSize",
    "sortItem",
    "includeItems"
})
@XmlRootElement(name = "getAssetsByTicketIdRequest")
public class GetAssetsByTicketIdRequest {

    @XmlElement(required = true)
    protected String ticketId;
    protected String deviceId;
    @XmlElement(required = true)
    protected String langCode;
    protected Integer startNum;
    protected Integer pageSize;
    protected List<SortItem> sortItem;
    protected String includeItems;

    /**
     * Gets the value of the ticketId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketId() {
        return ticketId;
    }

    /**
     * Sets the value of the ticketId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketId(String value) {
        this.ticketId = value;
    }

    /**
     * Gets the value of the deviceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the value of the deviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceId(String value) {
        this.deviceId = value;
    }

    /**
     * Gets the value of the langCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLangCode() {
        return langCode;
    }

    /**
     * Sets the value of the langCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLangCode(String value) {
        this.langCode = value;
    }

    /**
     * Gets the value of the startNum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartNum() {
        return startNum;
    }

    /**
     * Sets the value of the startNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartNum(Integer value) {
        this.startNum = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPageSize(Integer value) {
        this.pageSize = value;
    }

    /**
     * Gets the value of the sortItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSortItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SortItem }
     * 
     * 
     */
    public List<SortItem> getSortItem() {
        if (sortItem == null) {
            sortItem = new ArrayList<SortItem>();
        }
        return this.sortItem;
    }

    /**
     * Gets the value of the includeItems property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeItems() {
        return includeItems;
    }

    /**
     * Sets the value of the includeItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeItems(String value) {
        this.includeItems = value;
    }

}
