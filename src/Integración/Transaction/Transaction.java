/**
 * 
 */
package Integración.Transaction;

import java.sql.SQLException;

public interface Transaction { 
	
	/**
	 * Inicia una transaccion.
	 * @throws Exception
	 */
	public abstract void start() throws Exception;
	/**
	 * 
	 * @throws Exception
	 */
	public abstract void commit() throws Exception;
	public abstract void rollback() throws Exception;
	public abstract Object getResource();
	
}