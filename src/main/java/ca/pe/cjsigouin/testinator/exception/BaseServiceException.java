package ca.pe.cjsigouin.testinator.exception;

public class BaseServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseServiceException() {
		// TODO Auto-generated constructor stub
	}

	public BaseServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BaseServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public BaseServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BaseServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
