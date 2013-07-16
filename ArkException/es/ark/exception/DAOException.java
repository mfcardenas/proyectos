/**
 * Class DAO Exception
 */

package es.ark.exception;

import org.springframework.dao.DataAccessException;

/**
 * DAOException
 * @author ArkSoft
 *
 */
public class DAOException extends DataAccessException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 19810301L;
	
	/**
	 * DAOException
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/***
	 * DAOException
	 * @param message
	 * @param th
	 */
	public DAOException(String message, Throwable th) {
		super(message, th);
	}

	/**
	 * getRelation
	 * @return
	 */
	public String getRelation() {
		if (super.getCause().getCause().getLocalizedMessage() != null){
			return super
					.getCause()
					.getCause()
					.getLocalizedMessage()
					.substring(
							super.getCause().getCause().getLocalizedMessage().indexOf("(") + 1,
							super.getCause().getCause().getLocalizedMessage().indexOf(")"));
		}else{
			return null;
		}
	}

	/**
	 * getMessage
	 */
	public String getMessage() {
		if (super.getCause() != null){
			return super.getCause().toString();
		}else{
			return null;
		}
	}

	/**
	 * getErrorCode
	 * @return
	 */
	public String getErrorCode() {
		if (super.getCause().getCause().getLocalizedMessage() != null){
			return super
					.getCause()
					.getCause()
					.getLocalizedMessage()
					.substring(
							0,
							super.getCause().getCause().getLocalizedMessage()
									.indexOf(":"));
		}else{
			return null;
		}
	}

	/**
	 * getSpecificMessage
	 * @return
	 */
	public String getSpecificMessage() {
		if (super.getCause().getCause().getLocalizedMessage() != null){
			return super.getCause().getCause().getLocalizedMessage();
		}else{
			return null;
		}
	}


}