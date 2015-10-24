
package com.drutt.ws.msdp.media.search.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="group">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.drutt.com/msdp/media/search/v2}metaAssociated">
 *       &lt;sequence>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deviceFiltered" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="deviceCompatible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="preferredItem" type="{http://ws.drutt.com/msdp/media/search/v2}item" minOccurs="0"/>
 *         &lt;element name="item" type="{http://ws.drutt.com/msdp/media/search/v2}item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "group", propOrder = {
    "type",
    "deviceFiltered",
    "deviceCompatible",
    "preferredItem",
    "item"
})
public class Group
    extends MetaAssociated
{

    @XmlElement(required = true)
    protected String type;
    protected boolean deviceFiltered;
    protected boolean deviceCompatible;
    protected Item preferredItem;
    protected List<Item> item;

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
     * Gets the value of the deviceFiltered property.
     * 
     */
    public boolean isDeviceFiltered() {
        return deviceFiltered;
    }

    /**
     * Sets the value of the deviceFiltered property.
     * 
     */
    public void setDeviceFiltered(boolean value) {
        this.deviceFiltered = value;
    }

    /**
     * Gets the value of the deviceCompatible property.
     * 
     */
    public boolean isDeviceCompatible() {
        return deviceCompatible;
    }

    /**
     * Sets the value of the deviceCompatible property.
     * 
     */
    public void setDeviceCompatible(boolean value) {
        this.deviceCompatible = value;
    }

    /**
     * Gets the value of the preferredItem property.
     * 
     * @return
     *     possible object is
     *     {@link Item }
     *     
     */
    public Item getPreferredItem() {
        return preferredItem;
    }

    /**
     * Sets the value of the preferredItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Item }
     *     
     */
    public void setPreferredItem(Item value) {
        this.preferredItem = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
