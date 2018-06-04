/**
 * 
 */
package Integración.Vehiculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Negocio.Vehiculo.TMoto;
import Negocio.Vehiculo.TVehiculo;
import Negocio.Vehiculo.TCoche;

public class DAOVehiculoImp implements DAOVehiculo {

	@Override
	public int create(TVehiculo t) throws Exception {
		int res = 0; 
		Connection cn = null; 
		Transaction tr = null; 
		PreparedStatement ps = null;
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			
			ps = cn.prepareStatement("INSERT INTO vehiculo (modelo, matricula, color, numBaterias, coste, activo) VALUES (?,?,?,?,?,?)");
			ps.setString(1, t.getModelo());
			ps.setString(2, t.getMatricula());
			ps.setString(3, t.getColor());
			ps.setInt(4, t.getNumBaterias());
			ps.setDouble(5, t.getCoste());
			ps.setBoolean(6, t.getActivo());
			ps.executeUpdate();
			
			if(t instanceof TCoche){
				ps = cn.prepareStatement("INSERT INTO coche (idvehiculo, puertas, gps) VALUE" +
						" (LAST_INSERT_ID(),?,?)"); 
				ps.setInt(1, ((TCoche) t).getPuertas());
				ps.setBoolean(2, ((TCoche) t).getGps());
				res = ps.executeUpdate();
			}
			else if (t instanceof TMoto){
				ps = cn.prepareStatement("INSERT INTO moto (idvehiculo, baul) VALUE" +
						" (LAST_INSERT_ID(),?)"); 
				ps.setBoolean(1, ((TMoto) t).getBaul());
				res = ps.executeUpdate();
			}
			
			if(res != 0){
				ResultSet rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
				if(rs.next())
					res = rs.getInt(1);
				rs.close();
			}
		} catch (SQLException e) {
			throw new Exception(); // correcto ? 
		}
		finally{
			try 
			{
				if(ps != null)
					ps.close();
			} 
			catch (SQLException e) {
				throw new Exception(); 
			}
		}
		return res;
	}

	/** 
	 * (sin Javadoc)
	 * @throws Exception 
	 * @see DAOVehiculo#delete(int id, boolean salida)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int delete(int id) throws Exception {
		Connection cn = (Connection) TransactionManager.getInstance().getTransaction().getResource();
		PreparedStatement ps = null; 
		int res; 
		try {
			ps = cn.prepareStatement("DELETE FROM vehiculo WHERE idvehiculo ?");
			ps.setInt(1, id);
			res = ps.executeUpdate();
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try
			{
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {}
		}
		// 0 nose ha modificado ninguna fila
		//otro numero bien 
		return res;
	}

	/** 
	 * (sin Javadoc)
	 * @throws Exception 
	 * @see DAOVehiculo#list()
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public ArrayList<TVehiculo> list() throws Exception {
		ArrayList<TVehiculo> tList = new ArrayList<TVehiculo>();
		Transaction tr = null; 
		Connection cn = null;
		Statement st = null; 
		ResultSet rs = null; 
		String forUpdate = ""; 
		try {
			tr = TransactionManager.getInstance().getTransaction();
			if (tr == null)
				cn = getConnection();
			else {
				forUpdate = " FOR UPDATE";
				cn = (Connection) tr.getResource();
			}
			
			st = cn.createStatement();
			
			rs = st.executeQuery("SELECT * FROM vehiculo INNER JOIN coche USING(idvehiculo)" 
			+ forUpdate);
			while(rs.next())
				tList.add(new TCoche(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getBoolean(7),rs.getInt(8), rs.getBoolean(9)));
			rs.close();
			
			rs = st.executeQuery("SELECT * FROM vehiculo INNER JOIN moto USING(idvehiculo)" 
					+ forUpdate);
			while(rs.next())
				tList.add(new TMoto(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getBoolean(6),rs.getDouble(7), rs.getBoolean(8)));
			
			Collections.sort(tList, new Comparator<TVehiculo>() {

				@Override
				public int compare(TVehiculo v1, TVehiculo v2) {
					return Integer.compare(v1.getId(), v2.getId());
				}
			});
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
			} 
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return tList;
	}

	/** 
	 * (sin Javadoc)
	 * @throws Exception 
	 * @see DAOVehiculo#search(int id)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public TVehiculo read(int id) throws Exception {
		Connection cn = null;
		Transaction tr = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TVehiculo tRes = null;
		String forUpdate = ""; 
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if(tr == null)
				cn = getConnection();
			else {
				cn = (Connection) tr.getResource();
				forUpdate = " FOR UPDATE"; 
			}
			ps = cn.prepareStatement("SELECT * FROM vehiculo INNER JOIN coche USING(idvehiculo) WHERE idvehiculo = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				tRes = new TCoche(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getBoolean(7),rs.getInt(8), rs.getBoolean(9));
			}
			else{
				ps = cn.prepareStatement("SELECT * FROM vehiculo INNER JOIN moto USING(idvehiculo) WHERE idvehiculo = ?" + forUpdate);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				if(rs.next())
					tRes = new TMoto(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getInt(5), rs.getBoolean(6),rs.getDouble(7), rs.getBoolean(8));
			}
			
		} catch (SQLException e) {
			throw new Exception();
		} 
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		return tRes; 
	}

	/** 
	 * (sin Javadoc)
	 * @throws Exception 
	 * @see DAOVehiculo#update(TVehiculo t)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@Override
	public int update(TVehiculo t) throws Exception {
		Connection cn = null;
		Transaction tr = null;
		PreparedStatement ps = null; 
		int res = 0;
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			
			ps = cn.prepareStatement("UPDATE vehiculo SET modelo = ?, matricula = ?, color = ?," +
					" numBaterias = ?, coste = ?, activo = ? WHERE idvehiculo = ?");
			ps.setString(1, t.getModelo());
			ps.setString(2, t.getMatricula());
			ps.setString(3, t.getColor());
			ps.setInt(4, t.getNumBaterias());
			ps.setDouble(5, t.getCoste());
			ps.setBoolean(6, t.getActivo());
			ps.setInt(7, t.getId());
			res = ps.executeUpdate();
			if (res != 0)
			{
				if (t instanceof TCoche){
					ps = cn.prepareStatement("UPDATE coche SET puertas = ?, gps = ?" +
							" WHERE idvehiculo = ?"); 
					ps.setInt(1, ((TCoche) t).getPuertas());
					ps.setBoolean(2, ((TCoche) t).getGps());
					ps.setInt(3, t.getId());
					res = ps.executeUpdate();
				}
				else if (t instanceof TMoto){
					ps = cn.prepareStatement("UPDATE moto SET baul = ? WHERE idvehiculo = ?"); 
					ps.setBoolean(1, ((TMoto) t).getBaul());
					ps.setInt(2, t.getId());
					res = ps.executeUpdate();
				}
				res = t.getId();
			}
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try
			{
				if (ps != null)
					ps.close();
			}
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return res;
	}

	@Override
	public TVehiculo readByMatricula(String m) throws Exception {
		Connection cn = null;
		Transaction tr = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		ResultSet rsBusqueda = null; 
		TVehiculo tRes = null;
		String forUpdate = ""; 
		try {
			tr = TransactionManager.getInstance().getTransaction();
			if (tr == null)
				cn = getConnection();
			else {
				cn = (Connection) tr.getResource();
				forUpdate = " FOR UPDATE";
			}
			
			ps = cn.prepareStatement("SELECT * FROM vehiculo WHERE matricula = ?" + forUpdate);
			ps.setString(1, m);
			rsBusqueda = ps.executeQuery();
			if(rsBusqueda.next()){
				ps = cn.prepareStatement("SELECT * FROM vehiculo INNER JOIN coche USING(idvehiculo) WHERE idvehiculo = ?" + forUpdate);
				ps.setInt(1, rsBusqueda.getInt(1));
				rs = ps.executeQuery();
				
				if(rs.next()) {
					tRes = new TCoche(rs.getInt(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getBoolean(7), rs.getInt(8), rs.getBoolean(9));
				}
				else{
					ps = cn.prepareStatement("SELECT * FROM vehiculo INNER JOIN moto USING(idvehiculo) WHERE idvehiculo = ?" + forUpdate);
					ps.setInt(1, rsBusqueda.getInt(1));
					rs = ps.executeQuery();
					if(rs.next())
						tRes = new TMoto(rs.getInt(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getInt(5), rs.getBoolean(6),rs.getDouble(7), rs.getBoolean(8));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception();
		} 
		finally 
		{
			try 
			{
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (rsBusqueda != null)
					rsBusqueda.close();
			}
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return tRes; 
	}
	
	private Connection getConnection() throws Exception {
		Connection conexion = null;
		try {
			String database = "mazmorra";
			String username = "root";
			String password = "";

			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + database, username, password);
			conexion.setAutoCommit(false);

		} catch (Exception e) {
			throw new Exception("Error en la conexion a la Base de datos");
		}
		
		return conexion;
	}
}