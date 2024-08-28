package Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.ConnectionFactory;
import Dominio.Producer;

public class ProducerRepository {

	public static void save(Producer producer) {
		String sql = null;
		try {
			sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(Producer.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn = ConnectionFactory.getConnection();
			Statement stmt = conn.createStatement()){
			
			int linhasafetadas = stmt.executeUpdate(sql);
			System.out.println(linhasafetadas);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
}
