package Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import DataBase.ConnectionFactory;

public class ConnectionFactoryTest {
	
	 @Test
	    public void testGetConnection() throws SQLException {
	        Connection connection = ConnectionFactory.getConnection();
	        assertNotNull("Conexão deve ser criada com sucesso", connection);
	        connection.close();
	    }

	    @Test
	    public void testGetConnectionThrowsException() {
	        assertThrows(SQLException.class, () -> {
	            // Simula uma conexão inválida
	            ConnectionFactory.getConnection();
	        });
	    }

}
