/**
 * 
 */
package Negocio.Alquiler;

import java.util.ArrayList;
import java.util.Calendar;

import Integración.Alquiler.DAOAlquiler;
import Integración.Alquiler.DAOAlquilerImp;
import Integración.Cliente.DAOCliente;
import Integración.DAOFactory.DaoFactory;
import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Cliente.TCliente;
import Negocio.Vehiculo.TVehiculo;


public class ASAlquilerImp implements ASAlquiler {

	@Override
	public int altaAlquiler(TAlquiler t) {
		int res = -1;
		Transaction tr = null;
		DAOAlquiler dao = DaoFactory.getInstance().createDAOAlquiler(); 
		try {
		TransactionManager.getInstance().newTransaction();
		tr = TransactionManager.getInstance().getTransaction();
		
		tr.start();
		
		res = dao.create(t); 
		
		if (res == 0) {
			res = -1;
			tr.rollback();
		}
		else
			tr.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return res;
	}

	@Override
	public int bajaAlquiler(int idAlquiler) {
		int res = -1;
		Transaction tr = null; 
		DAOAlquiler dao = DaoFactory.getInstance().createDAOAlquiler();
		TAlquiler tAlq = null; 
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			tAlq = dao.read(idAlquiler);
			//Alquiler inexistente.
			if (tAlq == null) {
				res = -1;
				tr.rollback();
			}
			else {
				if(tAlq.getActivo()) {
					tAlq.setActivo(false);
					tAlq.ponOrdenLineasAlquiler(Operacion.ELIMINAR);
					res = dao.update(tAlq);
					//Error al dar de bajar
					if (res == 0) {
						res = -2; 
						tr.rollback();
					}
					else
						tr.commit();
				}
				else {
					//Alquiler ya dado de baja.
					res = -3;
					tr.rollback();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}
		return res;
	}

	@Override
	public ArrayList<TAlquiler> listadoAlquileres() throws Exception {
		TransactionManager.getInstance().newTransaction();
		TransactionManager.getInstance().getTransaction().start();
		ArrayList<TAlquiler> lista = new ArrayList<>();
		
		lista = DaoFactory.getInstance().createDAOAlquiler().list();
		
		TransactionManager.getInstance().getTransaction().commit();
		TransactionManager.getInstance().deleteTransaction();
		// end-user-code
		return lista;
	}

	@Override
	public TAlquiler buscaAlquiler(int idAlquiler) throws Exception {
		Transaction tr = null;
		DAOAlquiler dao = DaoFactory.getInstance().createDAOAlquiler();
		TAlquiler tAlq = null; 
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			tAlq = dao.read(idAlquiler);
			
			if (tAlq == null)
				tr.rollback();
			else
				tr.commit();
			
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();	
		}		
		return tAlq;
	}


	@Override
	public ArrayList<TVehiculo> iniciarAlquiler(TAlquiler alqEnCurso) throws Exception {
		Transaction tr = null; 
		DAOCliente daoC = DaoFactory.getInstance().createDAOCliente();
		DAOAlquiler daoA = DaoFactory.getInstance().createDAOAlquiler();
		ArrayList<TVehiculo> l = null; 
		TCliente tCli = null; 
		
		try {
			TransactionManager.getInstance().newTransaction();
			tr = TransactionManager.getInstance().getTransaction();
			
			tr.start();
			
			tCli = DaoFactory.getInstance().createDAOCliente().read(alqEnCurso.getIdCliente());
	
			if (tCli != null && tCli.getActivo()) {
				l = new ArrayList<>();
				l = daoA.obtenVehiculosNoCoincidentes(alqEnCurso.getFechaIni(), alqEnCurso.getFechaFin());
				
				tr.commit();
			}
			else {
				tr.rollback();
			}
	
			tr.commit();
		}
		finally {
			TransactionManager.getInstance().deleteTransaction();
		}

		return l;
	}


	@Override
	public void agregarVehiculo(int idVehiculo) {
		
		
	}


	@Override
	public void quitarVehiculo(int idVehiculo) {
		
	}

	@Override
	public int modificarAlquiler() {
		return 0;
	}
	
	private boolean solapan(Calendar fIni, Calendar fFin, Calendar fIni2, Calendar fFin2){
		if((fIni.compareTo(fIni2) > 0 && fIni.compareTo(fFin2) < 0)
				|| (fFin.compareTo(fIni2) > 0 && fFin.compareTo(fFin2) < 0))
			return true;
		else
			return false;
	}
}