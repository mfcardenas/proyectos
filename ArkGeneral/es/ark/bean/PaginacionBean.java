
package es.ark.bean;

import java.io.Serializable;

public class PaginacionBean
    implements Serializable
{

    public PaginacionBean()
    {
    }

    public String getFirstElement()
    {
        return firstElement;
    }

    public void setFirstElement(String firstElement)
    {
        this.firstElement = firstElement;
    }

    public String getLastElement()
    {
        return lastElement;
    }

    public void setLastElement(String lastElement)
    {
        this.lastElement = lastElement;
    }

    private static final long serialVersionUID = 0x23272b06bc89cf64L;
    private String firstElement;
    private String lastElement;
}