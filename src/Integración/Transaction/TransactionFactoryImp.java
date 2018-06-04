/**
 * 
 */
package Integración.Transaction;



public class TransactionFactoryImp extends TransactionFactory {

	@Override
	public synchronized Transaction createTransaction() throws Exception {
		return new TransactionMySQL();
	}
}