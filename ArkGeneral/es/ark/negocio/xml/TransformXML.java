// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:54:34
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   TransformXML.java

package es.ark.negocio.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;

@SuppressWarnings({"rawtypes","unchecked"})
public class TransformXML {

    public TransformXML(){
    }

    public Hashtable XML2HTML(StreamSource xml, StreamSource xsl, int sizeXML) throws Exception {
        logger.debug("TransformXML:XML2HTML ... : Inicio del m\351todo");
        NodeList nodes;
        Hashtable resultHash;
        int i;
        System.setProperty("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");
        TransformerFactory tFactory = TransformerFactory.newInstance();
        logger.debug("TransformXML:XML2HTML ... : Almaceno el XSL en un objeto Transform");
        Transformer transformer = tFactory.newTransformer(xsl);
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream(sizeXML);
        StreamResult htmlResultStream = new StreamResult(outBytes);
        logger.debug("TransformXML:XML2HTML ... : Transformo el XML como le indique el XSL");
        transformer.transform(xml, htmlResultStream);
        logger.debug("TransformXML:XML2HTML ... : Convertimos el OutputStream en un InputStream");
        ByteArrayInputStream convertOutput2Input = new ByteArrayInputStream(htmlResultStream.getOutputStream().toString().getBytes());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        logger.debug("TransformXML:XML2HTML ... : Almacenamos la transformaci\363n en un objeto tipo Document");
        org.w3c.dom.Document doc = builder.parse(convertOutput2Input);
        logger.debug("TransformXML:XML2HTML ... : Instanciamos la factor\355a de XPath");
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        logger.debug("TransformXML:XML2HTML ... : Extraemos todos los componentes GUI");
        XPathExpression expr = xpath.compile("/componentes/*");
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        logger.debug("TransformXML:XML2HTML ... : Almacenamos el resultado en una lista de nodos");
        nodes = (NodeList)result;
        resultHash = new Hashtable();
        logger.debug("TransformXML:XML2HTML ... : Transformamos el XML resultado en un Hashtable");
        i = 0;
        if(i < nodes.getLength()){
        	String keyHash;
            String attributePadre;
            Object valueHash;
            keyHash = nodes.item(i).getNodeName();
            attributePadre = null;
            valueHash = null;
            if(nodes.item(i).hasAttributes())
                attributePadre = nodes.item(i).getAttributes().getNamedItem("padre").getNodeValue();
            else
                attributePadre = "";
            if(!attributePadre.equals("")){
            	Hashtable parcialValueHash;
                String partialKey;
                String partialValue;
                parcialValueHash = new Hashtable();
                partialKey = attributePadre;
                partialValue = null;
                if(nodes.item(i).hasChildNodes() & nodes.item(i).getChildNodes().item(0).hasChildNodes())
                {
                    partialValue = nodes.item(i).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
                    //break MISSING_BLOCK_LABEL_503;
                }
                
                parcialValueHash.put(keyHash, partialValue);
                keyHash = partialKey;
                valueHash = parcialValueHash;
                return null;
            }else{
            	if(!(nodes.item(i).hasChildNodes() & nodes.item(i).getChildNodes().item(0).hasChildNodes())) {
                	return null;
                }else{
                	//goto _L4
                	valueHash = nodes.item(i).getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
                	resultHash.put(keyHash, valueHash);
                    i++;
                }
            }
        }else{
        	logger.debug("TransformXML:XML2HTML ... : Devolvemos el Hashtable. Fin del m\351todo");
            return resultHash;
        } 
        return null;
        /*
         * TransformerConfigurationException e;
            
            logger.error("TransformXML:XML2HTML ... : Error TransformerConfigurationException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error TransformerConfigurationException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error TransformerException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error TransformerException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error ParserConfigurationException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error ParserConfigurationException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error SAXException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error SAXException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error IOException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error IOException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error XPathExpressionException: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error XPathExpressionException: " + e.getLocalizedMessage());
            
            logger.error("TransformXML:XML2HTML ... : Error Exception General: " + e.getLocalizedMessage());
            throw new MCException("TransformXML:XML2HTML ... : Error Exception General: " + e.getLocalizedMessage());
         */
        
    }

    static Logger logger;

    static {
        logger = Logger.getLogger(es.ark.negocio.xml.TransformXML.class);
    }
}