// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 2:01:33
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GrupoRemonteTag.java

package es.ark.web.taglib;

import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.util.ResponseUtils;

@SuppressWarnings({"rawtypes","deprecation"})
public class GrupoRemonteTag extends TagSupport
{

    public GrupoRemonteTag()
    {
        url = null;
        etiqueta = null;
        imagen = false;
        refresh = null;
    }

    public int doStartTag()
        throws JspException
    {
        ResponseUtils.write(pageContext, renderAnexoElement());
        return 2;
    }

    protected String renderAnexoElement()
        throws JspException
    {
        String resultado = "";
        String action = "";
        action = url.substring(url.indexOf("/") + 1);
        action = action.substring(action.indexOf("/") + 1);
        HttpSession session = pageContext.getSession();
        Hashtable hashSJA = (Hashtable)session.getAttribute("SJAGUI");
        if(hashSJA.get("HashAction") instanceof HashMap)
        {
            HashMap hashAction = (HashMap)hashSJA.get("HashAction");
            if(hashAction.containsValue(action))
            {
                if(imagen)
                    resultado = "<img src='" + imagenURL + "' border='0' align='bottom' onclick='javascript:" + refresh + "'>";
                else
                    resultado = "<a href=\"javascript:ventana('" + url + "');\">" + etiqueta + "</a>";
            } else
            {
                resultado = etiqueta;
            }
        } else
        {
            Hashtable hashAction = (Hashtable)hashSJA.get("HashAction");
            if(hashAction.containsValue(action))
            {
                if(imagen)
                    resultado = "<img src='" + imagenURL + "' border='0' align='bottom' onclick='javascript:" + refresh + "'>";
                else
                    resultado = "<a href=\"javascript:ventana('" + url + "');\">" + etiqueta + "</a>";
            } else
            {
                resultado = etiqueta;
            }
        }
        if(resultado == null)
            resultado = "";
        return resultado;
    }

    public String getEtiqueta()
    {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta)
    {
        this.etiqueta = etiqueta;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public boolean isImagen()
    {
        return imagen;
    }

    public void setImagen(boolean imagen)
    {
        this.imagen = imagen;
    }

    public String getRefresh()
    {
        return refresh;
    }

    public void setRefresh(String refresh)
    {
        this.refresh = refresh;
    }

    public String getImagenURL()
    {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL)
    {
        this.imagenURL = imagenURL;
    }

    private static final long serialVersionUID = 1L;
    protected String url;
    protected String etiqueta;
    protected boolean imagen;
    protected String imagenURL;
    protected String refresh;
}