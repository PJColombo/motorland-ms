/**
 * 
 */
package Integraci�n.DAOFactory;

import Integraci�n.Vehiculo.DAOVehiculo;
import Integraci�n.Alquiler.DAOAlquiler;
import Integraci�n.Cliente.DAOCliente;


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