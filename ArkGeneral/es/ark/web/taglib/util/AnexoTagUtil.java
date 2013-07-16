// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:59:47
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AnexoTagUtil.java

package es.ark.web.taglib.util;

import es.ark.web.taglib.bean.AnexoBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

@SuppressWarnings({"rawtypes","unchecked"})
public class AnexoTagUtil
{

    public AnexoTagUtil()
    {
    }

    public static List addAttachment(List arrayAnexo, FormFile miAnexo, HttpSession sesion)
        throws IOException
    {
        logger.debug("AnexoTagUtil:addAttachment ...: Inicia");
        AnexoBean nuevoAnexo = new AnexoBean();
        logger.debug("AnexoTagUtil:addAttachment ...: Almacena valores");
        nuevoAnexo.setContentType(miAnexo.getContentType());
        nuevoAnexo.setFileName(miAnexo.getFileName());
        nuevoAnexo.setFileSize(miAnexo.getFileSize());
        nuevoAnexo.setFileData(miAnexo.getFileData());
        logger.debug("AnexoTagUtil:addAttachment ...: Devuelve valores");
        if(arrayAnexo == null)
            arrayAnexo = new ArrayList();
        arrayAnexo.add(nuevoAnexo);
        sesion.removeAttribute("Anexo");
        sesion.setAttribute("Anexo", arrayAnexo);
        return arrayAnexo;
    }

    public static List getAnexo(HttpSession sesion)
    {
        logger.debug("AnexoTagUtil:getAnexo ...: Inicio");
        return (List)sesion.getAttribute("Anexo");
    }

    public static void deleteAnexo(int iEliminado, HttpSession sesion)
    {
        logger.debug("AnexoTagUtil:deleteAnexo ...: Inicio");
        List arrayAnexo = (List)sesion.getAttribute("Anexo");
        logger.debug("AnexoTagUtil:getAnexo ...: Eliminar anexo");
        arrayAnexo.remove(iEliminado);
        sesion.removeAttribute("Anexo");
        if(arrayAnexo.size() > 0)
            sesion.setAttribute("Anexo", arrayAnexo);
    }

    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.web.taglib.util.AnexoTagUtil.class);
    }
}