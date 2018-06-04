/**
 * 
 */
package Negocio.Vehiculo;


import java.util.ArrayList;

import Integración.DAOFactory.DaoFactory;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Integración.Vehiculo.DAOVehiculo;

public class ASVehiculoImp implements ASVehiculo {

	@Override
	public int altaVehiculo(TVehiculo t) throws Exception {
		int id;
		Transaction tr = null; 
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo(); 
		
		try {
			TransactionManager.getInstance().newTransaction();
			
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			TVehiculo tb = dao.readByMatricula(t.getMatricula());
	
			if (tb == null){
				id = dao.create(t);
				if (id == 0){
					id = -1;//error al dar de alta un vehiculo que no existe en la bdd 
					tr.rollback();
				}
				else{
					tr.commit();//existo
				}
			} 
			else if (!tb.getActivo()) 
			{
				tb.setActivo(true);
				id = dao.update(tb);
	
				if (id == 0){
					id = -2;//error al dar de alta a un vehiculo dado de baja
					tr.rollback();
				}
				else {
					tr.commit();//correcto				
				}
			} 
			else
				id = -3; // ese vehiculo ya existe
			}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return id;
	}

	@Override
	public int bajaVehiculo(int id) throws Exception {
		Transaction tr = null; 
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo();
		
		try {
		TransactionManager.getInstance().newTransaction();
		tr = TransactionManager.getInstance().getTransaction();
		
		tr.start();

		TVehiculo tb = dao.read(id);

		if (tb != null){
			if (tb.getActivo()){
				tb.setActivo(false);
				id = dao.update(tb);
				if (id == 0){
					id = -1;//error al dar de baja a un vehiculo existente dado de alta
					tr.rollback();
				}
				else{
					tr.commit(); //dado se baja correctamente
				}
			} 
			else
				id = -2; // ya estaba dado de baja el vehiculo
		} 
		else
			id = -3; // ese vehiculo no exsite
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		
		return id;
	}

	@Override
	public int modificarVehiculo(TVehiculo t) throws Exception {//por id, tiene que meter todos los campos 
		int id;
		Transaction tr = null; 
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo(); 
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			TVehiculo tExist = dao.read(t.getId());//searid, search
	
			if (tExist != null){
				if (tExist.getActivo()){
					TVehiculo tv = dao.read(t.getId());
					if (tv == null	|| tv.getId() == tExist.getId()){
						
						if ((t instanceof TCoche && tExist instanceof TCoche) || (t instanceof TMoto && tExist instanceof TMoto)){
							id = dao.update(t);						
							if (id == 0){
								id = -1; // error al actualizar un vehiculo dado de alta
								tr.rollback();
							}
							else{
								tr.commit();//correcto
							}
						} 
						else
							id = -2;//error al instanciar
					} 
					else
						id = -3; // no existe el vehiculo
				} 
				else
					id = -4; //esta de baja el vehiculo
			} 
			else
				id = -5; // no existe el vehiculo
			}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return id;
	}

	@Override
	public ArrayList<TVehiculo> mostarListaVehiculos() throws Exception {
		Transaction tr = null;
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo();
		ArrayList<TVehiculo> lista = null;
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			lista = dao.list();
			tr.commit();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
			
		return lista;
		
	}

	@Override
	public TVehiculo buscarVehiculo(int id) throws Exception {
		Transaction tr = null;
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo();
		TVehiculo t = null; 
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			t = dao.read(id);
			
			tr.commit();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return t;
	}
	
	
	@Override
	public int comprobarAutonomia(int id) throws Exception {//tiene que introducir el id //autonomia = numBaterias * 4 horas
		int res = -1;
		Transaction tr = null; 
		DAOVehiculo dao = DaoFactory.getInstance().createDAOVehiculo();
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			TVehiculo tb = dao.read(id);
			
			if(tb != null){
				res = tb.getNumBaterias() * 4;
			}
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		
		return res;
	}
	
}