/**
 * 
 */
package Integración.Transaction;

import java.sql.SQLException;


public abstract class TransactionFactory {

	private static TransactionFactory transactionFactory;


	public static synchronized TransactionFactory getInstance() {
		if(transactionFactory == null)
			transactionFactory = new TransactionFactoryImp();
		return transactionFactory;
	}

	public abstract Transaction createTransaction() throws Exception;
}