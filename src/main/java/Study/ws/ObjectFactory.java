
package Study.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.test package. 
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

    private final static QName _HelloService_QNAME = new QName("http://ws.java.main/", "helloService");
    private final static QName _GetUserResponse_QNAME = new QName("http://ws.java.main/", "getUserResponse");
    private final static QName _HelloServiceResponse_QNAME = new QName("http://ws.java.main/", "helloServiceResponse");
    private final static QName _GetUser_QNAME = new QName("http://ws.java.main/", "getUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link HelloServiceResponse }
     * 
     */
    public HelloServiceResponse createHelloServiceResponse() {
        return new HelloServiceResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link HelloService_Type }
     * 
     */
    public HelloService_Type createHelloService_Type() {
        return new HelloService_Type();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloService_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.java.main/", name = "helloService")
    public JAXBElement<HelloService_Type> createHelloService(HelloService_Type value) {
        return new JAXBElement<HelloService_Type>(_HelloService_QNAME, HelloService_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.java.main/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.java.main/", name = "helloServiceResponse")
    public JAXBElement<HelloServiceResponse> createHelloServiceResponse(HelloServiceResponse value) {
        return new JAXBElement<HelloServiceResponse>(_HelloServiceResponse_QNAME, HelloServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.java.main/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

}
