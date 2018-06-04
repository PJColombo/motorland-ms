/**
 * 
 */
package Integración.Transaction;

import java.sql.SQLException;


public abstract class TransactionManager {

	private static TransactionManager transactionManager;


	public synchronized static TransactionManager getInstance() {
		if(transactionManager == null)
			transactionManager = new TransactionManagerImp();
		return transactionManager;
	}

	public abstract Transaction newTransaction() throws Exception;

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract Transaction getTransaction();

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @return
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public abstract boolean deleteTransaction();
}