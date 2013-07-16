// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:58:39
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   NoauthorizedAction.java

package es.ark.web.actions;

import java.io.IOException;
import java.net.URL;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

// Referenced classes of package es.adif.arq.web.actions:
//            GeneralAction

public class NoauthorizedAction extends GeneralAction
{

    public NoauthorizedAction()
    {
    }

    public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        logger.debug("NoauthorizedAction:doExecute ... Inicia el m\351todo");
        ActionForward forward = new ActionForward();
        try
        {
            Context ctx = new InitialContext();
            URL url = (URL)ctx.lookup("url/webSJA");
            request.getSession().invalidate();
            response.sendRedirect(url.getProtocol() + "://" + url.getHost() + url.getPath());
        }
        catch(NamingException e)
        {
            e.printStackTrace();
            forward = mapping.findForward("error");
            return forward;
        }
        return null;
    }

    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.web.actions.NoauthorizedAction.class);
    }
}