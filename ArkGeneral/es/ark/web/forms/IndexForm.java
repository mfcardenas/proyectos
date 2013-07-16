// Decompiled by DJ v3.10.10.93 Copyright 2007 Atanas Neshkov  Date: 10/08/2012 1:59:08
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   IndexForm.java

package es.ark.web.forms;

import org.apache.struts.action.ActionForm;

public class IndexForm extends ActionForm
{

    public IndexForm()
    {
        usuario = null;
        app = null;
        perfil = null;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getApp()
    {
        return app;
    }

    public void setApp(String app)
    {
        this.app = app;
    }

    public String getPerfil()
    {
        return perfil;
    }

    public void setPerfil(String perfil)
    {
        this.perfil = perfil;
    }

    private static final long serialVersionUID = 1L;
    private String usuario;
    private String app;
    private String perfil;
}