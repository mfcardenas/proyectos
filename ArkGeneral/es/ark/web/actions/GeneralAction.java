
package es.ark.web.actions;

import es.ark.exception.ArkException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

public abstract class GeneralAction extends Action
{

    public GeneralAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
    	try{
    		logger.debug("GeneralAction:execute ...: Llamada al Action correspondiente");
            return doExecute(mapping, form, request, response);	
    	}catch(ArkException e){
    		logger.error("GeneralAction:execute ...: Sesi\363n Invalida");
            e.printStackTrace();
            return doInternalErrorException(mapping, form, request, response);	
    	}
        
    }

    protected abstract ActionForward doExecute(ActionMapping actionmapping, ActionForm actionform, HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
        throws IOException, ServletException, ArkException;

    protected ActionForward doInternalErrorException(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        logger.debug("GeneralAction:internalErrorException ...: Error");
        return mapping.findForward("error");
    }

    static Logger logger;
    public static final String GRUPOREMONTE_RECUPERACION = "getGruporemonte";
    public static final String GRUPOREMONTE_OBTENCION = "setGruporemonte";

    static 
    {
        logger = Logger.getLogger(es.ark.web.actions.GeneralAction.class);
    }
}