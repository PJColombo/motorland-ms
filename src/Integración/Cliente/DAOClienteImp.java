/**
 * 
 */
package Integración.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integración.Transaction.Transaction;
import Integración.Transaction.TransactionManager;
import Integración.connectionPool.ConnectionPoolFactory;
import Negocio.Cliente.TCliente;
import oracle.jdbc.replay.driver.PooledConnectionImpl;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Paulo Colombo
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOClienteImp implements DAOCliente {
	/** 
	 * Devuelve id del cliente si lo ha insertado o -1 en caso de que exista. 
	 * @throws Exception 
	 * @see DAOCliente#add(TCliente t)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	@SuppressWarnings("resource")
	public int create(TCliente t) throws Exception {
		int res = 0; 
		Transaction tr = null; 
		Connection cn = null; 
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
		
			ps = cn.prepareStatement("INSERT INTO cliente (nombre, dni, domicilio, tarjeta, activo) VALUES (?,?,?,?,?)");
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getDni());
			ps.setString(3, t.getDomicilio());
			ps.setLong(4, t.getTarjeta());
			ps.setBoolean(5, t.getActivo());
			ps.executeUpdate();
			
			ps = cn.prepareStatement("SELECT LAST_INSERT_ID()");
			rs = ps.executeQuery();
			
			if (rs.next()) 
				res = rs.getInt("LAST_INSERT_ID()");
			
		} catch (SQLException e) {
			throw e; 
		}
		finally{
			try 
			{
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close(); 
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
	 * @see DAOCliente#delete(int id, boolean salida)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int delete(int id) throws Exception {
		Transaction tr = null;
		tr = TransactionManager.getInstance().getTransaction();
		Connection cn = (Connection) tr.getResource();
		PreparedStatement ps = null; 
		int res; 
		try {
			
			ps = cn.prepareStatement("DELETE FROM cliente WHERE idcliente = ?");
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
	 * @see DAOCliente#update(TCliente t)
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int update(TCliente t) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		int res = 0;
		try {
			tr =  TransactionManager.getInstance().getTransaction();
			cn = (Connection) tr.getResource();
			ps = cn.prepareStatement("UPDATE cliente SET nombre = ?, dni = ?, domicilio = ?," +
					" tarjeta = ?, activo = ? WHERE idcliente = ?");
			ps.setString(1, t.getNombre());
			ps.setString(2, t.getDni());
			ps.setString(3, t.getDomicilio());
			ps.setLong(4, t.getTarjeta());
			ps.setBoolean(5, t.getActivo());
			ps.setInt(6, t.getId());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
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
	//null si no ha encontrado dato
	public TCliente read(int id) throws Exception {
		Transaction tr = null; 
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCliente tRes = null;
		String forUpdate = "FOR UPDATE"; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if (tr == null) {
				cn = creaConexion();
				forUpdate = "FOR UPDATE";
			}
			else {
				cn = (Connection) tr.getResource();
				forUpdate = ""; 
			}
			
			ps = cn.prepareStatement("SELECT * FROM cliente WHERE idcliente = ?" + forUpdate);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next())
				tRes = new TCliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getLong(5), rs.getBoolean(6));
			
		} catch (SQLException e) {
			new Exception();
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
				new Exception();
			}
		}
		return tRes; 
	}

	//devuelve lista vacia en caso de que no encuentre
	public ArrayList<TCliente> list() throws Exception {
		ArrayList<TCliente> tList = new ArrayList<TCliente>();
		Transaction tr = null;
		Connection cn = null;
		Statement st = null; 
		ResultSet rs = null; 
		String forUpdate = ""; 
		
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if (tr == null) {
				cn = creaConexion();
			}
			else {
				cn = (Connection) tr.getResource();
				forUpdate = " FOR UPDATE";
			}
			
			st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM cliente" + forUpdate);
			while(rs.next())
				tList.add(new TCliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
		} catch (SQLException e) {
			throw new Exception();
		}
		finally 
		{
			try 
			{
				if(rs != null)
					rs.close();
				if(st != null)
					st.close();
			} 
			catch (SQLException e) {
				throw new Exception();
			}
		}
		return tList;
	}

	public TCliente readByDNI(String dni) throws Exception {
		Transaction tr = null;
		Connection cn = null;
		PreparedStatement ps = null; 
		ResultSet rs = null; 
		TCliente tRes = null;
		String forUpdate = "";
		try {
			tr = TransactionManager.getInstance().getTransaction();
			
			if (tr == null) {
				cn = creaConexion();
			}
			else {
				cn = (Connection) tr.getResource();
				forUpdate = " FOR UPDATE";
			}
			
			ps = cn.prepareStatement("SELECT * FROM cliente WHERE dni = ? " + forUpdate);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			
			if(rs.next())
				tRes = new TCliente(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getBoolean(6));
			
		} catch (SQLException e) {
			new Exception();
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
				new Exception();
			}
		}
		return tRes;
	}
	
	public Connection creaConexion() throws Exception {
		Connection cn = null;
		
		try {
			/*cn = DriverManager.getConnection("jdbc:mysql://" +
					"den1.mysql3.gear.host:3306/motorlanddb?autoReconnect=true&useSSL=true","motorlanddb",	"123-abc");
			*/
			cn = ConnectionPoolFactory.getInstance().getConnection();
			cn.setAutoCommit(false);
		}
		catch (SQLException e){
			throw new Exception("Error al conectarse a la base de datos.");
		}
		return cn; 
	}
}