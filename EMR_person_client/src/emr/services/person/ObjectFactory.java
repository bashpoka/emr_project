
package emr.services.person;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the emr.services.person package. 
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

    private final static QName _UpdatePerson_QNAME = new QName("http://person.services.emr", "updatePerson");
    private final static QName _GetSessionByIdResponse_QNAME = new QName("http://person.services.emr", "getSessionByIdResponse");
    private final static QName _CheckSession_QNAME = new QName("http://person.services.emr", "checkSession");
    private final static QName _GetSessionById_QNAME = new QName("http://person.services.emr", "getSessionById");
    private final static QName _CreateSession_QNAME = new QName("http://person.services.emr", "createSession");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://person.services.emr", "checkSessionResponse");
    private final static QName _DeleteSessionResponse_QNAME = new QName("http://person.services.emr", "deleteSessionResponse");
    private final static QName _CreateSessionResponse_QNAME = new QName("http://person.services.emr", "createSessionResponse");
    private final static QName _InsertNewPersonResponse_QNAME = new QName("http://person.services.emr", "insertNewPersonResponse");
    private final static QName _InsertNewPerson_QNAME = new QName("http://person.services.emr", "insertNewPerson");
    private final static QName _DeleteSession_QNAME = new QName("http://person.services.emr", "deleteSession");
    private final static QName _GetPersonByIdResponse_QNAME = new QName("http://person.services.emr", "getPersonByIdResponse");
    private final static QName _GetPersonById_QNAME = new QName("http://person.services.emr", "getPersonById");
    private final static QName _UpdatePersonResponse_QNAME = new QName("http://person.services.emr", "updatePersonResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: emr.services.person
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeleteSession }
     * 
     */
    public DeleteSession createDeleteSession() {
        return new DeleteSession();
    }

    /**
     * Create an instance of {@link InsertNewPerson }
     * 
     */
    public InsertNewPerson createInsertNewPerson() {
        return new InsertNewPerson();
    }

    /**
     * Create an instance of {@link GetSessionById }
     * 
     */
    public GetSessionById createGetSessionById() {
        return new GetSessionById();
    }

    /**
     * Create an instance of {@link CreateSession }
     * 
     */
    public CreateSession createCreateSession() {
        return new CreateSession();
    }

    /**
     * Create an instance of {@link UpdatePersonResponse }
     * 
     */
    public UpdatePersonResponse createUpdatePersonResponse() {
        return new UpdatePersonResponse();
    }

    /**
     * Create an instance of {@link GetPersonByIdResponse }
     * 
     */
    public GetPersonByIdResponse createGetPersonByIdResponse() {
        return new GetPersonByIdResponse();
    }

    /**
     * Create an instance of {@link GetPersonById }
     * 
     */
    public GetPersonById createGetPersonById() {
        return new GetPersonById();
    }

    /**
     * Create an instance of {@link DeleteSessionResponse }
     * 
     */
    public DeleteSessionResponse createDeleteSessionResponse() {
        return new DeleteSessionResponse();
    }

    /**
     * Create an instance of {@link CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link GetSessionByIdResponse }
     * 
     */
    public GetSessionByIdResponse createGetSessionByIdResponse() {
        return new GetSessionByIdResponse();
    }

    /**
     * Create an instance of {@link CheckSession }
     * 
     */
    public CheckSession createCheckSession() {
        return new CheckSession();
    }

    /**
     * Create an instance of {@link UpdatePerson }
     * 
     */
    public UpdatePerson createUpdatePerson() {
        return new UpdatePerson();
    }

    /**
     * Create an instance of {@link InsertNewPersonResponse }
     * 
     */
    public InsertNewPersonResponse createInsertNewPersonResponse() {
        return new InsertNewPersonResponse();
    }

    /**
     * Create an instance of {@link CreateSessionResponse }
     * 
     */
    public CreateSessionResponse createCreateSessionResponse() {
        return new CreateSessionResponse();
    }

    /**
     * Create an instance of {@link PersonBean }
     * 
     */
    public PersonBean createPersonBean() {
        return new PersonBean();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "updatePerson")
    public JAXBElement<UpdatePerson> createUpdatePerson(UpdatePerson value) {
        return new JAXBElement<UpdatePerson>(_UpdatePerson_QNAME, UpdatePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "getSessionByIdResponse")
    public JAXBElement<GetSessionByIdResponse> createGetSessionByIdResponse(GetSessionByIdResponse value) {
        return new JAXBElement<GetSessionByIdResponse>(_GetSessionByIdResponse_QNAME, GetSessionByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "checkSession")
    public JAXBElement<CheckSession> createCheckSession(CheckSession value) {
        return new JAXBElement<CheckSession>(_CheckSession_QNAME, CheckSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSessionById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "getSessionById")
    public JAXBElement<GetSessionById> createGetSessionById(GetSessionById value) {
        return new JAXBElement<GetSessionById>(_GetSessionById_QNAME, GetSessionById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "createSession")
    public JAXBElement<CreateSession> createCreateSession(CreateSession value) {
        return new JAXBElement<CreateSession>(_CreateSession_QNAME, CreateSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "deleteSessionResponse")
    public JAXBElement<DeleteSessionResponse> createDeleteSessionResponse(DeleteSessionResponse value) {
        return new JAXBElement<DeleteSessionResponse>(_DeleteSessionResponse_QNAME, DeleteSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "createSessionResponse")
    public JAXBElement<CreateSessionResponse> createCreateSessionResponse(CreateSessionResponse value) {
        return new JAXBElement<CreateSessionResponse>(_CreateSessionResponse_QNAME, CreateSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertNewPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "insertNewPersonResponse")
    public JAXBElement<InsertNewPersonResponse> createInsertNewPersonResponse(InsertNewPersonResponse value) {
        return new JAXBElement<InsertNewPersonResponse>(_InsertNewPersonResponse_QNAME, InsertNewPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertNewPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "insertNewPerson")
    public JAXBElement<InsertNewPerson> createInsertNewPerson(InsertNewPerson value) {
        return new JAXBElement<InsertNewPerson>(_InsertNewPerson_QNAME, InsertNewPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "deleteSession")
    public JAXBElement<DeleteSession> createDeleteSession(DeleteSession value) {
        return new JAXBElement<DeleteSession>(_DeleteSession_QNAME, DeleteSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "getPersonByIdResponse")
    public JAXBElement<GetPersonByIdResponse> createGetPersonByIdResponse(GetPersonByIdResponse value) {
        return new JAXBElement<GetPersonByIdResponse>(_GetPersonByIdResponse_QNAME, GetPersonByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "getPersonById")
    public JAXBElement<GetPersonById> createGetPersonById(GetPersonById value) {
        return new JAXBElement<GetPersonById>(_GetPersonById_QNAME, GetPersonById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://person.services.emr", name = "updatePersonResponse")
    public JAXBElement<UpdatePersonResponse> createUpdatePersonResponse(UpdatePersonResponse value) {
        return new JAXBElement<UpdatePersonResponse>(_UpdatePersonResponse_QNAME, UpdatePersonResponse.class, null, value);
    }

}
