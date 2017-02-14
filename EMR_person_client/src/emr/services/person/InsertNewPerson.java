
package emr.services.person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertNewPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertNewPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="new_person" type="{http://person.services.emr}personBean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertNewPerson", propOrder = {
    "newPerson"
})
public class InsertNewPerson {

    @XmlElement(name = "new_person")
    protected PersonBean newPerson;

    /**
     * Gets the value of the newPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PersonBean }
     *     
     */
    public PersonBean getNewPerson() {
        return newPerson;
    }

    /**
     * Sets the value of the newPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonBean }
     *     
     */
    public void setNewPerson(PersonBean value) {
        this.newPerson = value;
    }

}
