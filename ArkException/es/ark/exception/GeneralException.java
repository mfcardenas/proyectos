/**
 * GeneralException
 */
package es.ark.exception;


/**
 * GeneralException
 * @author ArkSoft
 *
 */
public class GeneralException extends ArkException {

	/**
	 * serialVersionUID
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * GeneralException
     * @param mensaje
     */
    public GeneralException(String mensaje){
        super(mensaje);
    }

    /**
     * GeneralException
     * @param mensaje
     */
    public GeneralException(String mensaje, Throwable th){
        super(mensaje, th);
    }


}