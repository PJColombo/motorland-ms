package Integración.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionPoolFactory {
	
	protected final String HOST = "den1.mysql3.gear.host";
	protected final String NOMBRE_DB = "motorlanddb"; 
	protected final String PORT = "3306"; 
	protected final String USER = "motorlanddb";
	protected final String PASSWD = "123-abc"; 
	
	private static ConnectionPoolFactory conPoolFactory;
	
	public static synchronized ConnectionPoolFactory getInstance() {
		
		if (conPoolFactory == null)
			conPoolFactory = new ConnectionPoolFactoryImp(); 
		
		return conPoolFactory; 
	}
	
	protected abstract void createConnections() throws SQLException;
	
	public abstract Connection getConnection() throws SQLException;
	
	public abstract void closeConnections() throws SQLException;
	
	public abstract void putConnection(Connection conn); 

}
