
package emr.services.person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createSessionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createSessionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="created_session" type="{http://person.services.emr}session" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createSessionResponse", propOrder = {
    "createdSession"
})
public class CreateSessionResponse {

    @XmlElement(name = "created_session")
    protected Session createdSession;

    /**
     * Gets the value of the createdSession property.
     * 
     * @return
     *     possible object is
     *     {@link Session }
     *     
     */
    public Session getCreatedSession() {
        return createdSession;
    }

    /**
     * Sets the value of the createdSession property.
     * 
     * @param value
     *     allowed object is
     *     {@link Session }
     *     
     */
    public void setCreatedSession(Session value) {
        this.createdSession = value;
    }

}
