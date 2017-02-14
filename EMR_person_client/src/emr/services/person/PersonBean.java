
package emr.services.person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="birth_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="curr_add" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="father_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marital_stat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mother_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nat_id_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="person_id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="person_type" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="phone_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pmnt_add" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="spouse_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personBean", propOrder = {
    "birthDate",
    "currAdd",
    "email",
    "fatherName",
    "maritalStat",
    "motherName",
    "name",
    "natIdNo",
    "password",
    "personId",
    "personType",
    "phoneNo",
    "pmntAdd",
    "sex",
    "spouseName"
})
public class PersonBean {

    @XmlElement(name = "birth_date")
    protected String birthDate;
    @XmlElement(name = "curr_add")
    protected String currAdd;
    protected String email;
    @XmlElement(name = "father_name")
    protected String fatherName;
    @XmlElement(name = "marital_stat")
    protected int maritalStat;
    @XmlElement(name = "mother_name")
    protected String motherName;
    protected String name;
    @XmlElement(name = "nat_id_no")
    protected String natIdNo;
    protected String password;
    @XmlElement(name = "person_id")
    protected int personId;
    @XmlElement(name = "person_type")
    protected int personType;
    @XmlElement(name = "phone_no")
    protected String phoneNo;
    @XmlElement(name = "pmnt_add")
    protected String pmntAdd;
    protected int sex;
    @XmlElement(name = "spouse_name")
    protected String spouseName;

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the currAdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrAdd() {
        return currAdd;
    }

    /**
     * Sets the value of the currAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrAdd(String value) {
        this.currAdd = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the fatherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * Sets the value of the fatherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherName(String value) {
        this.fatherName = value;
    }

    /**
     * Gets the value of the maritalStat property.
     * 
     */
    public int getMaritalStat() {
        return maritalStat;
    }

    /**
     * Sets the value of the maritalStat property.
     * 
     */
    public void setMaritalStat(int value) {
        this.maritalStat = value;
    }

    /**
     * Gets the value of the motherName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotherName() {
        return motherName;
    }

    /**
     * Sets the value of the motherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotherName(String value) {
        this.motherName = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the natIdNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNatIdNo() {
        return natIdNo;
    }

    /**
     * Sets the value of the natIdNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNatIdNo(String value) {
        this.natIdNo = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the personId property.
     * 
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Sets the value of the personId property.
     * 
     */
    public void setPersonId(int value) {
        this.personId = value;
    }

    /**
     * Gets the value of the personType property.
     * 
     */
    public int getPersonType() {
        return personType;
    }

    /**
     * Sets the value of the personType property.
     * 
     */
    public void setPersonType(int value) {
        this.personType = value;
    }

    /**
     * Gets the value of the phoneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * Sets the value of the phoneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNo(String value) {
        this.phoneNo = value;
    }

    /**
     * Gets the value of the pmntAdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmntAdd() {
        return pmntAdd;
    }

    /**
     * Sets the value of the pmntAdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmntAdd(String value) {
        this.pmntAdd = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     */
    public int getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     */
    public void setSex(int value) {
        this.sex = value;
    }

    /**
     * Gets the value of the spouseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * Sets the value of the spouseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpouseName(String value) {
        this.spouseName = value;
    }

}
