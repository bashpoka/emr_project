
package emr.services.person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for session complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="session">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remember_me" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="session_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="session_string" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "session", propOrder = {
    "rememberMe",
    "sessionId",
    "sessionString",
    "userId"
})
public class Session {

    @XmlElement(name = "remember_me")
    protected int rememberMe;
    @XmlElement(name = "session_id")
    protected int sessionId;
    @XmlElement(name = "session_string")
    protected String sessionString;
    @XmlElement(name = "user_id")
    protected int userId;

    /**
     * Gets the value of the rememberMe property.
     * 
     */
    public int getRememberMe() {
        return rememberMe;
    }

    /**
     * Sets the value of the rememberMe property.
     * 
     */
    public void setRememberMe(int value) {
        this.rememberMe = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     */
    public void setSessionId(int value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the sessionString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionString() {
        return sessionString;
    }

    /**
     * Sets the value of the sessionString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionString(String value) {
        this.sessionString = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(int value) {
        this.userId = value;
    }

}
