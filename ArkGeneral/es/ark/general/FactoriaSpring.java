package es.ark.general;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
public class FactoriaSpring
{

    public FactoriaSpring()
    {
    }

    
	public static void setServletContext(ServletContext sc)
    {
        if(hashSC == null)
        {
            hashSC = new HashMap();
            hashCtx = new HashMap();
        }
        hashSC.put((String)sc.getAttribute("com.ibm.websphere.servlet.application.name"), sc);
        hashCtx.put((String)sc.getAttribute("com.ibm.websphere.servlet.application.name"), null);
        
    }

    public static ApplicationContext getApplicationContext()
    {
        if(ctx == null)
        {
            String propiedades = sc.getInitParameter("contextConfigLocation");
            String paths[] = propiedades.split("(\\s|,)");
            ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
            ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext(paths, ctx);
            contextos.put("contextConfigLocation", cpac);
        }
        return (ApplicationContext)contextos.get("contextConfigLocation");
    }

    public static ApplicationContext getApplicationContext(String nameApp)
    {
        ApplicationContext ctxLocal = (ApplicationContext)hashCtx.get(nameApp);
        if(ctxLocal == null)
        {
            String propiedades = ((ServletContext)hashSC.get(nameApp)).getInitParameter("contextConfigLocation");
            String paths[] = propiedades.split("(\\s|,)");
            ctxLocal = WebApplicationContextUtils.getWebApplicationContext((ServletContext)hashSC.get(nameApp));
            ClassPathXmlApplicationContext cpac = new ClassPathXmlApplicationContext(paths, ctxLocal);
            contextos.put("contextConfigLocation" + nameApp, cpac);
            hashCtx.put(nameApp, ctxLocal);
        }
        return (ApplicationContext)contextos.get("contextConfigLocation" + nameApp);
    }

    private static ApplicationContext ctx;
    private static HashMap hashCtx;
    private static ServletContext sc;
    private static HashMap hashSC;
    private static Map contextos = new HashMap();
    
	private static final String CONTEXTO = "contextConfigLocation";

}