// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:56:19
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ReadProperties.java

package es.ark.util;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import javax.naming.*;
import org.apache.log4j.Logger;

public class ReadProperties{

    public ReadProperties(){
    }

    public static String getProperties(String key){
        logger.debug("ReadProperties:getProperties ...: Inicio");
        try{
        	if(propiedades == null){
                logger.debug("ReadProperties:getProperties ...: Se busca el fichero de propiedades");
                propiedades = new Properties();
                Context ctx = new InitialContext();
                URL url = (URL)ctx.lookup("java:comp/env/" + jndiName);
                InputStream systemResourceAsStream = url.openStream();
                BufferedInputStream bis = new BufferedInputStream(systemResourceAsStream);
                logger.debug("ReadProperties:getProperties ...: Cargamos el fichero de propiedades en el properties");
                propiedades.load(bis);
                bis.close();
                systemResourceAsStream.close();
            }
            logger.debug("ReadProperties:getProperties ...: Fin");
            return propiedades.getProperty(key);
        }catch(FileNotFoundException fioe){
        	logger.error("ReadProperties:getProperties ...: Error de Fichero no encontrado: " + fioe.getMessage());
            fioe.printStackTrace();
            return null;
        }catch(IOException ioe){
        	logger.error("ReadProperties:getProperties ...: Error de I/O: " + ioe.getMessage());
            ioe.printStackTrace();
            return null;
        }catch(NamingException e){
        	logger.error("ReadProperties:getProperties ...: Error NamingException: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void setJndiName(String jndiName){
        ReadProperties.jndiName = jndiName;
    }

    private static Properties propiedades = null;
    private static String jndiName = null;
    static Logger logger;

    static {
        logger = Logger.getLogger(es.ark.util.ReadProperties.class);
    }
}