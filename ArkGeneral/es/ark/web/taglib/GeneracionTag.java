// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 2:01:24
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   GeneracionTag.java

package es.ark.web.taglib;

import java.util.HashMap;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.util.ResponseUtils;

@SuppressWarnings({"rawtypes","deprecation"})
public class GeneracionTag extends TagSupport
{

    public GeneracionTag()
    {
        tipo = null;
        padre = null;
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
        HttpSession session = pageContext.getSession();
        Hashtable hashSJA = (Hashtable)session.getAttribute("SJAGUI");
        if(padre.equals(""))
            resultado = (String)hashSJA.get(tipo);
        else
        if(hashSJA.get(padre) != null)
        {
            if(hashSJA.get(padre) instanceof HashMap)
            {
                HashMap hashAux = (HashMap)hashSJA.get(padre);
                resultado = (String)hashAux.get(tipo);
            } else
            {
                Hashtable hashAux = (Hashtable)hashSJA.get(padre);
                resultado = (String)hashAux.get(tipo);
            }
        } else
        {
            resultado = "";
        }
        return resultado;
    }

    public String getPadre()
    {
        return padre;
    }

    public void setPadre(String padre)
    {
        this.padre = padre;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    private static final long serialVersionUID = 1L;
    protected String tipo;
    protected String padre;
}