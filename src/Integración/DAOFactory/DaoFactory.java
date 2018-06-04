/**
 * 
 */
package Integración.DAOFactory;

import Integración.Vehiculo.DAOVehiculo;
import Integración.Alquiler.DAOAlquiler;
import Integración.Cliente.DAOCliente;


public abstract class DaoFactory {

	private static DaoFactory daoFactory;


	public synchronized static DaoFactory getInstance() {

		if(DaoFactory.daoFactory == null)
			return new DaoFactoryImp(); 
		else
			return DaoFactory.daoFactory;
		// end-user-code
	}

	public abstract DAOVehiculo createDAOVehiculo();

	public abstract DAOAlquiler createDAOAlquiler();

	public abstract DAOCliente createDAOCliente();
}