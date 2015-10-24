
package com.drutt.ws.msdp.media.search.v2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="result" type="{http://ws.drutt.com/msdp/media/search/v2}asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lastRow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="totalRows" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "result",
    "lastRow",
    "totalRows"
})
@XmlRootElement(name = "searchAssetsResponse")
public class SearchAssetsResponse {

    protected List<Asset> result;
    protected int lastRow;
    protected int totalRows;

    /**
     * Gets the value of the result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Asset }
     * 
     * 
     */
    public List<Asset> getResult() {
        if (result == null) {
            result = new ArrayList<Asset>();
        }
        return this.result;
    }

    /**
     * Gets the value of the lastRow property.
     * 
     */
    public int getLastRow() {
        return lastRow;
    }

    /**
     * Sets the value of the lastRow property.
     * 
     */
    public void setLastRow(int value) {
        this.lastRow = value;
    }

    /**
     * Gets the value of the totalRows property.
     * 
     */
    public int getTotalRows() {
        return totalRows;
    }

    /**
     * Sets the value of the totalRows property.
     * 
     */
    public void setTotalRows(int value) {
        this.totalRows = value;
    }

}
