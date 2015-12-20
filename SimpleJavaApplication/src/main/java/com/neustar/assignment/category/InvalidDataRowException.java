/**
 * 
 */
package com.neustar.assignment.category;

/**
 * @author Krishnagopal Thogiti
 *
 */
public class InvalidDataRowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1843484106395810103L;

	/**
	 * 
	 */
	public InvalidDataRowException() {
	}

	/**
	 * @param message
	 */
	public InvalidDataRowException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidDataRowException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidDataRowException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidDataRowException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
