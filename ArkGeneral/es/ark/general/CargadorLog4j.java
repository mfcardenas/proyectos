package es.ark.general;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.*;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.servlet.*;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings({"rawtypes", "unused"})
public final class CargadorLog4j
    implements ServletContextListener
{

    public CargadorLog4j()
    {
    }

    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        URL url = null;
        Context ctx = null;
        try
        {
            ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("url");
            DirContext ctxDir = new InitialDirContext(envContext.getEnvironment());
            NamingEnumeration bindings = ctxDir.listBindings("url");
            String nameApp = servletContextEvent.getServletContext().getInitParameter("nameApp");
            while(bindings.hasMore()) 
            {
                Binding bd = (Binding)bindings.next();
                String name = bd.getName().toString();
                Pattern p = Pattern.compile(nameApp + ".*log4j.*", 2);
                Matcher m = p.matcher(name);
                if(m.matches())
                    url = (URL)bd.getObject();
            }
            if(url == null)
                throw new NamingException();
            PropertyConfigurator.configure(url);
        }
        catch(NamingException ex)
        {
            ex.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletcontextevent)
    {
    }

    private static final String CONTEXTO_APP = "nameApp";
}