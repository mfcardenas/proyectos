
package es.ark.negocio;

import es.ark.dao.ArkDAO;

public class ArkNegocio{

    public ArkNegocio(){
    }

    public void setAdifDAO(ArkDAO arkDAO){
        this.arkDAO = arkDAO;
    }

    protected ArkDAO arkDAO;
}