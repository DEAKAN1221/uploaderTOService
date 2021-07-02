package ru.liga.uploader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.List;

public class MarshallUtil {

    public MarshallUtil() {
        super();
    }

    public static String marshal(ExchangeClientRequest request) {
        return marshal(request, request.getClass());
    }

    public static String marshal(ExchangeServiceResponse response) {
        return marshal(response, response.getClass());
    }

    public static String marshal(ExchangeServiceRequest request) {
        return marshal(request, request.getClass());
    }

    public static String marshal(JAXBElement content) {
        try {
            DOMResult domResult = new DOMResult();
            JAXB.marshal(content, domResult);

            Element contentElement = ((Document) domResult.getNode()).getDocumentElement();
            return marshal(contentElement);

        } catch (Exception e) {
            throw new RuntimeException("Error during marshalling", e);
        }
    }

    public static String marshal(List<RejectInfo> rejectList) {
        QName qName = new QName("reject-list");

        for (Method m : StatusInfo.class.getMethods()) {
            if ("getRejectList".equalsIgnoreCase(m.getName()) && m.isAnnotationPresent(XmlElementWrapper.class)) {
                XmlElementWrapper a = m.getAnnotation(XmlElementWrapper.class);
                qName = new QName(a.name());
            }
        }

        JAXBElement<ElementWrapper> jaxbElement = new JAXBElement<ElementWrapper>(qName, ElementWrapper.class, new ElementWrapper(rejectList));

        StringWriter result = new StringWriter();

        try {
            JAXBContext jc = JAXBContext.newInstance(ElementWrapper.class, RejectInfo.class);

            Marshaller marshaller = jc.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(jaxbElement, result);
        } catch (JAXBException e) {
            throw new RuntimeException("Error during marshalling", e);
        }

        return result.toString();
    }

    public static String marshal(Object request, Class resultClassDef) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(resultClassDef);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter sw = new StringWriter();
            marshaller.marshal(request, sw);

            return sw.toString();

        } catch (JAXBException e) {
            throw new RuntimeException("Error during marshalling", e);
        }
    }

    public static String marshal(Element element) {
        try {
            DOMSource source = new DOMSource(element);

            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            return writer.toString();
        } catch (Exception ex) {
            throw new IllegalStateException("Cannot transform xml element to string", ex);
        }
    }

    public static Element marshal2element(List<RejectInfo> rejectList) {
        String sReject = marshal(rejectList);
        return marshal2element(sReject);
    }

    public static Element marshal2element(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            return document.getDocumentElement();
        } catch (Exception ex) {
            throw new RuntimeException("Cannot transform specified string to xml document", ex);
        }
    }

    public static <T> T unmarshal(String data, Class<T> resultClassDef) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(resultClassDef);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader sourceReader = new StringReader(data);
            return (T) unmarshaller.unmarshal(sourceReader);
        } catch (JAXBException e) {
            throw new RuntimeException("Error during unmarshalling", e);
        }
    }

    public static <T> T unmarshalElement(String xml, Class<T> resultClassDef) {
        Element element = marshal2element(xml);

        return unmarshalElement(element, resultClassDef);
    }

    public static <T> T unmarshalElement(Element element, Class<T> resultClassDef) {
        return JAXB.unmarshal(new DOMSource(element), resultClassDef);
    }

    public static List<RejectInfo> unmarshalElement(Element rejectElement) {
        try {
            JAXBContext jc = JAXBContext.newInstance(ElementWrapper.class, RejectInfo.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            JAXBElement jelem = unmarshaller.unmarshal(rejectElement, ElementWrapper.class);

            ElementWrapper<RejectInfo> wrapper = (ElementWrapper<RejectInfo>) jelem.getValue();
            return wrapper.getItems();

        } catch (JAXBException e) {
            throw new RuntimeException("Error during reject element's unmarshalling", e);
        }
    }
}
