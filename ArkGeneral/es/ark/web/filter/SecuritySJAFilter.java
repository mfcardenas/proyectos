// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:58:53
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SecuritySJAFilter.java

package es.ark.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings({"rawtypes"})
public class SecuritySJAFilter
    implements Filter
{

    public SecuritySJAFilter()
    {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;
        if(!request.getServletPath().equals("/index.do") && !request.getServletPath().equals("/unathorized.do") && !request.getServletPath().equals("/login.do") && !request.getServletPath().equals("/loginAplicacionesCombo.do") && !request.getServletPath().equals("/procesarCajetin.do") && !request.getServletPath().equals("/sendApp.do") && !request.getServletPath().equals("/recargaComboPerfiles.do"))
        {
            if(request.getSession().getAttribute("SJAGUI") == null && request.getAttribute("indexForm") == null)
                response.sendError(401, "SJA: Usuario no autorizado");
            else
            if(request.getSession().getAttribute("SJAGUI") != null)
            {
                Hashtable hashIntermedio = (Hashtable)request.getSession().getAttribute("SJAGUI");
                if(hashIntermedio.get("HashAction") instanceof HashMap)
                {
                    HashMap hashAction = (HashMap)hashIntermedio.get("HashAction");
                    if(!hashAction.containsValue(request.getServletPath().substring(1)))
                        response.sendError(401, "SJA: Usuario no autorizado");
                    else
                        chain.doFilter(req, response);
                } else
                {
                    Hashtable hashAction = (Hashtable)hashIntermedio.get("HashAction");
                    if(!hashAction.containsValue(request.getServletPath().substring(1)))
                        response.sendError(401, "SJA: Usuario no autorizado");
                    else
                        chain.doFilter(req, response);
                }
            } else
            {
                chain.doFilter(req, response);
            }
        } else
        {
            chain.doFilter(req, response);
        }
    }

    public void init(FilterConfig filterConfig)
        throws ServletException
    {
        fc = filterConfig;
    }

    public void destroy()
    {
        fc = null;
    }

    public FilterConfig getFc()
    {
        return fc;
    }

    public void setFc(FilterConfig fc)
    {
        this.fc = fc;
    }

    private FilterConfig fc;
}