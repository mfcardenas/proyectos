/**
 * 
 */
package es.ark.exception;

/**
 * MCException
 * 
 * @author ArkSoft
 * 
 */
public class ArkException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * MCException
	 * 
	 * @param error
	 */
	public ArkException(String error) {
		super(error);
	}

	/**
	 * MCException
	 * 
	 * @param error
	 */
	public ArkException(String error, Throwable th) {
		super(error, th);
	}

}