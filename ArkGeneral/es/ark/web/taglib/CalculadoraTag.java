// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 2:00:49
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   CalculadoraTag.java

package es.ark.web.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.util.ResponseUtils;

@SuppressWarnings({ "deprecation"})
public class CalculadoraTag extends TagSupport
{

    public CalculadoraTag()
    {
        id = null;
        url = null;
        styleButton = "botonesAri";
        styleMonitor = "cajatextoAri";
        borderColorTable = "gray";
        bgColorTable = "white";
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
        resultado = "<INPUT type=\"text\" size=\"20\" id=\"" + id + "\" value=\"\"/>";
        resultado = resultado + " <INPUT type=\"image\"\tsrc=\"" + url + "\" onclick=\"javascript:abrir('" + id + "');\"/>";
        resultado = resultado + "<div id=\"calculadora\" style=\"display:none\">";
        resultado = resultado + "<div class=\"drag\" id=\"calc\" style=\"width: 169; height: 176\">";
        resultado = resultado + "<form name=\"calculator\">";
        resultado = resultado + "<table borderColor=\"" + borderColorTable + "\" cellSpacing=\"1\" cellPadding=\"0\" width=\"150\" bgColor=\"" + bgColorTable + "\" border=\"3\">";
        resultado = resultado + "<tr><td><input size=\"19\" name=\"ans\" class=\"" + styleMonitor + "\"></td><td align=\"center\"><input onclick=\"javascript:cerrar('" + id + "');\" type=\"button\" value=\"Copiar\" name=\"copiar\" class=\"botonesAri\"></td></tr></table>";
        resultado = resultado + "<table borderColor=\"" + borderColorTable + "\" cellSpacing=\"1\" cellPadding=\"1\" width=\"150\" bgColor=\"" + bgColorTable + "\" border=\"2\">";
        resultado = resultado + "<tr><td align=\"center\"><input onmousedown=\"document.calculator.ans.value+='7'\" type=\"button\" value=\"  7  \" name=\"seven\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='8'\" type=\"button\" value=\"  8  \" name=\"eight\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='9'\" type=\"button\" value=\"  9  \" name=\"nine\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='/'\" type=\"button\" value=\"  /  \" name=\"divide\" class=\"" + styleButton + "\"></td></tr>";
        resultado = resultado + "<tr><td align=\"center\"><input onclick=\"document.calculator.ans.value+='4'\" type=\"button\" value=\"  4  \" name=\"four\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='5'\" type=\"button\" value=\"  5  \" name=\"five\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='6'\" type=\"button\" value=\"  6  \" name=\"six\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='*'\" type=\"button\" value=\"  *  \" name=\"multiply\" class=\"" + styleButton + "\"></td></tr>";
        resultado = resultado + "<tr><td align=\"center\"><input onclick=\"document.calculator.ans.value+='1'\" type=\"button\" value=\"  1  \" name=\"one\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='2'\" type=\"button\" value=\"  2  \" name=\"two\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='3'\" type=\"button\" value=\"  3  \" name=\"three\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='-'\" type=\"button\" value=\"  -  \" name=\"subtract\" class=\"" + styleButton + "\"></td></tr>";
        resultado = resultado + "<tr><td align=\"center\"><input onclick=\"document.calculator.ans.value=''\" type=\"button\" value=\"  C  \" name=\"clear\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='0'\" type=\"button\" value=\"  0  \" name=\"zero\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value=eval(document.calculator.ans.value)\" type=\"button\" value=\"  =  \" name=\"equal\" class=\"" + styleButton + "\"></td>";
        resultado = resultado + "<td align=\"center\"><input onclick=\"document.calculator.ans.value+='+'\" type=\"button\" value=\"  +  \" name=\"add\" class=\"" + styleButton + "\"></td></tr>";
        resultado = resultado + "</table></form></div></div>";
        return resultado;
    }

    public String getBgColorTable()
    {
        return bgColorTable;
    }

    public void setBgColorTable(String bgColorTable)
    {
        this.bgColorTable = bgColorTable;
    }

    public String getBorderColorTable()
    {
        return borderColorTable;
    }

    public void setBorderColorTable(String borderColorTable)
    {
        this.borderColorTable = borderColorTable;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getStyleButton()
    {
        return styleButton;
    }

    public void setStyleButton(String styleButton)
    {
        this.styleButton = styleButton;
    }

    public String getStyleMonitor()
    {
        return styleMonitor;
    }

    public void setStyleMonitor(String styleMonitor)
    {
        this.styleMonitor = styleMonitor;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    private static final long serialVersionUID = 1L;
    protected String id;
    protected String styleButton;
    protected String styleMonitor;
    protected String borderColorTable;
    protected String bgColorTable;
    protected String url;
}