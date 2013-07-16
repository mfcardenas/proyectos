package es.ark.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.log4j.Logger;
import org.apache.struts.util.ResponseUtils;

@SuppressWarnings({"deprecation"})
public class PaginacionTag extends TagSupport
{

    public PaginacionTag()
    {
        grid = "";
        offset = "10";
        name = "";
        remonte = "";
        remonteField = "";
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
        logger.debug("PaginacionTag:renderAnexoElement ...: Inicio");
        logger.debug("PaginacionTag:renderAnexoElement ...: Creaci\363n de los elementos necesarios para la paginaci\363n");
        StringBuffer resultado = new StringBuffer("<script>");
        resultado.append("var retrocederPrincipio" + name + " = new AW.UI.Button;");
        resultado.append("retrocederPrincipio" + name + ".setControlText(\"<<\");");
        resultado.append("document.write(retrocederPrincipio" + name + ");");
        resultado.append("var retroceder" + name + " = new AW.UI.Button;");
        resultado.append("retroceder" + name + ".setControlText(\"<\");");
        resultado.append("document.write(retroceder" + name + ");");
        resultado.append("</script>");
        resultado.append("<input type=\"hidden\" name=\"preferredOrder" + name + "\" id=\"preferredOrder" + name + "\" />");
        resultado.append("<input type=\"hidden\" name=\"orderDirection" + name + "\" id=\"orderDirection" + name + "\" />");
        resultado.append("<input type=\"hidden\" name=\"" + name + "\" id=\"" + name + "\" />");
        resultado.append("<input type=\"text\" style=\"font-size: 11px; color: #10264D; background-color: #FFFFFF; border: #10264D; border-style: solid; border-top-width: 0px; border-right-width: 0px; border-bottom-width: 0px; border-left-width: 0px;\" size=\"8\" align=\"middle\" readonly=\"readonly\" id=\"total" + name + "\" name=\"total" + name + "\">");
        resultado.append("<script>");
        resultado.append("var avanzar" + name + " = new AW.UI.Button;");
        resultado.append("avanzar" + name + ".setControlText(\">\");");
        resultado.append("document.write(avanzar" + name + ");");
        resultado.append("var avanzarFinal" + name + " = new AW.UI.Button;");
        resultado.append("avanzarFinal" + name + ".setControlText(\">>\");");
        resultado.append("document.write(avanzarFinal" + name + ");");
        if("sql".equals(type))
        {
            resultado.append("avanzar" + name + ".onControlClicked = function() {");
            resultado.append("avanzarSQLGrid(" + grid + "," + table + "," + offset + ",'" + url + "','" + name + "','" + remonte + "','" + remonteField + "');");
            resultado.append("};");
            resultado.append("retroceder" + name + ".onControlClicked = function() {");
            resultado.append("retrocederSQLGrid(" + grid + "," + table + "," + offset + ",'" + url + "','" + name + "','" + remonte + "','" + remonteField + "');");
            resultado.append("};");
            resultado.append("avanzarFinal" + name + ".onControlClicked = function() {");
            resultado.append("avanzarSQLFinalGrid(" + grid + "," + table + "," + offset + ",'" + url + "','" + name + "','" + remonte + "','" + remonteField + "');");
            resultado.append("};");
            resultado.append("retrocederPrincipio" + name + ".onControlClicked = function() {");
            resultado.append("retrocederSQLPrincipioGrid(" + grid + "," + table + "," + offset + ",'" + url + "','" + name + "','" + remonte + "','" + remonteField + "');");
            resultado.append("};");
            resultado.append("var http = new AW.HTTP.Request;");
            resultado.append("http.setURL(\"" + urlCount + "\");");
            resultado.append("http.response = function(text){");
            resultado.append("if (" + offset + " <= text) {");
            resultado.append("document.getElementById(\"total" + name + "\").value = \"1 - " + offset + " / \" + text;");
            resultado.append("document.getElementById(\"total" + name + "\").size = document.getElementById(\"total" + name + "\").value.length-3;");
            resultado.append("} else {");
            resultado.append("if (text != \"0\") {");
            resultado.append("document.getElementById(\"total" + name + "\").value = \"1 - \" + text + \" / \" + text;");
            resultado.append("} else {");
            resultado.append("document.getElementById(\"total" + name + "\").value = \"0 - 0 / \" + text;");
            resultado.append("}");
            resultado.append("document.getElementById(\"total" + name + "\").size = document.getElementById(\"total" + name + "\").value.length-3;");
            resultado.append("}");
            resultado.append("};");
            resultado.append("http.request();");
        } else
        {
            resultado.append("avanzar" + name + ".onControlClicked = function() {");
            resultado.append("avanzarGrid(" + grid + "," + offset + ",'" + name + "');");
            resultado.append("};");
            resultado.append("retroceder" + name + ".onControlClicked = function() {");
            resultado.append("retrocederGrid(" + grid + "," + offset + ",'" + name + "');");
            resultado.append("};");
        }
        resultado.append("</script>");
        if("sql".equals(type))
            resultado.append("<input type=\"hidden\" id=\"firstItem" + name + "\" name=\"firstItem" + name + "\" value = \"" + Integer.toString(Integer.parseInt(offset) + 1) + "\">");
        logger.debug("PaginacionTag:renderAnexoElement ...: Resultado devuelto: " + resultado.toString());
        return resultado.toString();
    }

    public String getGrid()
    {
        return grid;
    }

    public void setGrid(String grid)
    {
        this.grid = grid;
    }

    public String getOffset()
    {
        return offset;
    }

    public void setOffset(String offset)
    {
        this.offset = offset;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getTable()
    {
        return table;
    }

    public void setTable(String table)
    {
        this.table = table;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrlCount()
    {
        return urlCount;
    }

    public void setUrlCount(String urlCount)
    {
        this.urlCount = urlCount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRemonte()
    {
        return remonte;
    }

    public void setRemonte(String remonte)
    {
        this.remonte = remonte;
    }

    public String getRemonteField()
    {
        return remonteField;
    }

    public void setRemonteField(String remonteField)
    {
        this.remonteField = remonteField;
    }

    private static final long serialVersionUID = 0xace6bde6e4391553L;
    protected String grid;
    protected String offset;
    protected String type;
    protected String table;
    protected String url;
    protected String urlCount;
    protected String name;
    protected String remonte;
    protected String remonteField;
    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.web.taglib.PaginacionTag.class);
    }
}