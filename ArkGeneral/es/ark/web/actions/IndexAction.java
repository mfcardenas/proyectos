// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:58:31
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   IndexAction.java

package es.ark.web.actions;

import es.ark.web.forms.IndexForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.*;

// Referenced classes of package es.adif.arq.web.actions:
//            GeneralAction

public class IndexAction extends GeneralAction
{

    public IndexAction()
    {
    }

    public ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        logger.debug("IndexAction:doExecute ... Inicia el m\351todo");
        ActionForward forward = new ActionForward();
        IndexForm indexForm = (IndexForm)form;
        logger.debug("IndexAction:doExecute ... Busca el elemento de SJA");
        HttpSession session = request.getSession();
        session.setAttribute("SJA", "false");
        indexForm.setUsuario(request.getParameter("usuario"));
        indexForm.setApp(request.getParameter("app"));
        indexForm.setPerfil(request.getParameter("perfil"));
        request.setAttribute("indexForm", indexForm);
        forward = mapping.findForward("principal");
        return forward;
    }

    static Logger logger;

    static 
    {
        logger = Logger.getLogger(es.ark.web.actions.IndexAction.class);
    }
}