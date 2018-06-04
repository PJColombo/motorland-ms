package Integración.connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConnectionPoolFactoryImp extends ConnectionPoolFactory {

	private final int NUM_CONN = 1;  
	private Queue<Connection> pool;	
	
	public ConnectionPoolFactoryImp() {
		super();
		this.pool = new ConcurrentLinkedDeque<Connection>();
		
	}
	
	@Override
	protected void createConnections() throws SQLException {
		Connection conn; 
		for(int i = 0; i < NUM_CONN; i++) {
			conn = DriverManager.getConnection("jdbc:mysql://" +
					HOST + ":" + PORT + "/" + NOMBRE_DB + "?autoReconnect=true&useSSL=true", USER, PASSWD);
			this.pool.add(conn);
		}

	}



	@Override
	public Connection getConnection() throws SQLException {
		Connection conn = pool.poll();
		
		if(conn == null) {
			createConnections();
			conn = pool.poll(); 
		}
		System.out.println(pool.size());
		return conn;
	}



	@Override
	public void closeConnections() throws SQLException {
		for (int i = 0; i < pool.size(); i++)
			pool.poll().close();
	}

	@Override
	public void putConnection(Connection conn) {
		
		pool.add(conn);
	} 
}
