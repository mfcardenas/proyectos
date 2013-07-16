// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 2:00:32
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   AnexoTag.java

package es.ark.web.taglib;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.apache.struts.util.ResponseUtils;


@SuppressWarnings({"rawtypes","unchecked", "deprecation"})
public class AnexoTag extends TagSupport
{

    public AnexoTag()
    {
        estiloBoton = "botonLogin";
        estiloListado = "textoLogin";
        cabecera = "Fichero";
        estiloResultado = "tabla_resultado";
        accionEliminar = "false";
        etiquetaEliminar = "Eliminar";
        estiloEliminar = "botonmenu";
        mensajeInicial = "";
        literalBotonSubida = ">>";
        sizeCaja = "8";
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
        logger.debug("AnexoTag:renderAnexoElement ...: Inicio");
        logger.debug("AnexoTag:renderAnexoElement ...: Creaci\363n de la tabla original");
        StringBuffer resultado = new StringBuffer("<table width=\"100%\" border=\"0\">");
        resultado.append("<tr>");
        resultado.append("<td width=\"40%\" valign=\"top\">");
        resultado.append("<input type=\"file\" name=\"");
        resultado.append(name);
        resultado.append("\" value=\"\" class=\"");
        resultado.append(estiloBoton);
        resultado.append("\" size=\"" + sizeCaja + "\">&nbsp;");
        resultado.append("<input type=\"submit\" name=\"upLoadFileclicked\" value=\"" + literalBotonSubida + "\" class=\"" + estiloBoton + "\">");
        resultado.append("</td>");
        resultado.append("<td width=\"60%\">");
        resultado.append("<table border=\"0\" width=\"100%\" class=\"");
        resultado.append(estiloResultado);
        resultado.append("\">");
        resultado.append("<thead class=\"fondoBlanco\"><tr><th align=\"left\" class=\"TextoNegrita\">");
        if(numeroAnexos() > 0)
            resultado.append(cabecera);
        else
            resultado.append(mensajeInicial);
        resultado.append("</th></tr></thead><tbody>");
        logger.debug("AnexoTag:renderAnexoElement ...: Introducir datos de los ficheros.. Llamar al metodo ficheroAnexados()");
        resultado.append(ficherosAnexados());
        logger.debug("AnexoTag:renderAnexoElement ...: Fin Introducir datos de los ficheros");
        resultado.append("</tbody>");
        resultado.append("</table>");
        logger.debug("AnexoTag:renderAnexoElement ...: Resultado devuelto: " + resultado.toString());
        return resultado.toString();
    }

    protected int numeroAnexos()
    {
        logger.debug("AnexoTag:numeroAnexos ...: Inicio");
        HttpSession sesion = pageContext.getSession();
       
		List lista = (List)sesion.getAttribute(contenedor);
        if(lista != null)
            return ((List)pageContext.getSession().getAttribute(contenedor)).size();
        else
            return 0;
    }

    protected String ficherosAnexados()
    {
        logger.debug("AnexoTag:ficherosAnexados ...: Inicio");
        HttpSession sesion = pageContext.getSession();
        List lista = (List)sesion.getAttribute(contenedor);
        StringBuffer resultado1 = new StringBuffer("");
        logger.debug("AnexoTag:ficherosAnexados ...: Comprobar lista");
        if(lista != null && !lista.isEmpty())
            try
            {
                for(int i = 0; i < lista.size(); i++)
                {
                    Class c = lista.get(i).getClass();
                    String name = "get" + propiedad.substring(0, 1).toUpperCase() + propiedad.substring(1);
                    
					Object obj = (Object)c.getMethod(name, null).invoke(lista.get(i), null);
                    String retval = (String)obj;
                    resultado1.append("<tr class=\"odd\">");
                    resultado1.append("<td class=\"");
                    resultado1.append(estiloListado);
                    resultado1.append("\">");
                    resultado1.append(retval);
                    resultado1.append("</td>");
                    if(Boolean.valueOf(accionEliminar).booleanValue())
                    {
                        resultado1.append("<td class=\"odd\">");
                        resultado1.append("<input type=\"submit\" name=\"eliminarclicked\" onclick=\"this.style.display='none';this.value='" + i + "'\" onmouseover=\"this.className='botonmenuhand'\" onmouseout=\"this.className='botonmenu'\" class=\"" + estiloEliminar + "\" value=\"");
                        resultado1.append(etiquetaEliminar);
                        resultado1.append("\">");
                        resultado1.append("</td></tr>");
                    }
                }

            }
            catch(IllegalArgumentException e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: Argumentos Ilegales: " + e1.getMessage());
                e1.printStackTrace();
            }
            catch(SecurityException e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: Excepci\363n de seguridad: " + e1.getMessage());
                e1.printStackTrace();
            }
            catch(IllegalAccessException e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: Accesos Ilegales: " + e1.getMessage());
                e1.printStackTrace();
            }
            catch(InvocationTargetException e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: Invocaci\363n incorrecta: " + e1.getMessage());
                e1.printStackTrace();
            }
            catch(NoSuchMethodException e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: No alcanzo el metodo: " + e1.getMessage());
                e1.printStackTrace();
            }
            catch(Exception e1)
            {
                logger.error("AnexoTag:ficherosAnexados ...: Error: General: " + e1.getMessage());
                e1.printStackTrace();
            }
        logger.debug("AnexoTag:ficherosAnexados ...: Salida : " + resultado1.toString());
        return resultado1.toString();
    }

    public String getEstiloBoton()
    {
        return estiloBoton;
    }

    public void setEstiloBoton(String estiloBoton)
    {
        this.estiloBoton = estiloBoton;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEstiloListado()
    {
        return estiloListado;
    }

    public void setEstiloListado(String estiloListado)
    {
        this.estiloListado = estiloListado;
    }

    public String getCabecera()
    {
        return cabecera;
    }

    public void setCabecera(String cabecera)
    {
        this.cabecera = cabecera;
    }

    public String getEstiloResultado()
    {
        return estiloResultado;
    }

    public void setEstiloResultado(String estiloResultado)
    {
        this.estiloResultado = estiloResultado;
    }

    public String getPropiedad()
    {
        return propiedad;
    }

    public void setPropiedad(String propiedad)
    {
        this.propiedad = propiedad;
    }

    public String getContenedor()
    {
        return contenedor;
    }

    public void setContenedor(String contenedor)
    {
        this.contenedor = contenedor;
    }

    public String getAccionEliminar()
    {
        return accionEliminar;
    }

    public void setAccionEliminar(String accionEliminar)
    {
        this.accionEliminar = accionEliminar;
    }

    public String getEtiquetaEliminar()
    {
        return etiquetaEliminar;
    }

    public void setEtiquetaEliminar(String etiquetaEliminar)
    {
        this.etiquetaEliminar = etiquetaEliminar;
    }

    public String getEstiloEliminar()
    {
        return estiloEliminar;
    }

    public void setEstiloEliminar(String estiloEliminar)
    {
        this.estiloEliminar = estiloEliminar;
    }

    public String getLiteralBotonSubida()
    {
        return literalBotonSubida;
    }

    public void setLiteralBotonSubida(String literalBotonSubida)
    {
        this.literalBotonSubida = literalBotonSubida;
    }

    public String getMensajeInicial()
    {
        return mensajeInicial;
    }

    public void setMensajeInicial(String mensajeInicial)
    {
        this.mensajeInicial = mensajeInicial;
    }

    public String getSizeCaja()
    {
        return sizeCaja;
    }

    public void setSizeCaja(String sizeCaja)
    {
        this.sizeCaja = sizeCaja;
    }

    private static final long serialVersionUID = 1L;
    protected String name;
    protected String estiloBoton;
    protected String estiloListado;
    protected String cabecera;
    protected String estiloResultado;
    protected String propiedad;
    protected String contenedor;
    protected String accionEliminar;
    protected String etiquetaEliminar;
    protected String estiloEliminar;
    protected String sizeCaja;
    protected String mensajeInicial;
    protected String literalBotonSubida;
    public static final String prefix = "get";
    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.web.taglib.AnexoTag.class);
    }
}