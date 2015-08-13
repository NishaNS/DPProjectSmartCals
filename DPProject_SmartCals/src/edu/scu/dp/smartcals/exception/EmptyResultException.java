/**
 * 
 */
package edu.scu.dp.smartcals.exception;

/**
 * @author Aparna Ganesh
 * User exception for Empty result set
 */
public class EmptyResultException extends Exception {

	public EmptyResultException() {
		super("Result Not found");
	}

	/**
	 * @param string
	 */
	public EmptyResultException(String string) {
		super(string);
	}
}
