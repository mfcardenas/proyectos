
package es.ark.general;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// Referenced classes of package es.adif.arq.general:
//            FactoriaSpring

public class CargadorContexto
implements ServletContextListener
{

	public CargadorContexto()
	{
	}

	public void contextInitialized(ServletContextEvent evento)
	{
		javax.servlet.ServletContext contexto = evento.getServletContext();
		FactoriaSpring.setServletContext(contexto);
	}

	public void contextDestroyed(ServletContextEvent servletcontextevent)
	{
	}
}