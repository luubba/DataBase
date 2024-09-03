package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectionFactory;
import Dominio.Producer;

public class ProducerRepository {

	public static void save(Producer producer) {
		String sql = null;
		try {
			sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {

			int linhasafetadas = stmt.executeUpdate(sql);
			System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void delete(int id) {
		String sql = null;
		try {
			sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {

			int linhasafetadas = stmt.executeUpdate(sql);
			System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void update(Producer producer) {
		String sql = null;
		try {
			sql = "UPDATE `anime_store`.`producer` SET `name` = '%d' WHERE (`id` = '%d');".formatted(producer.getName(),
					producer.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {

			int linhasafetadas = stmt.executeUpdate(sql);
			System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static List<Producer> findAll() {
		String sql = "SELECT id, name FROM anime_store.producer;";

		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Producer prod = new Producer(name, id);
				producers.add(prod);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return producers;

	}
	public static List<Producer> findByName(String name) {
		String sql = "SELECT id, name FROM anime_store.producer WHERE name LIKE '%" + name + "%'";

		
		List<Producer> producers = new ArrayList<>();
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name2 = rs.getString("name");
				Producer prod = new Producer(name2, id);
				producers.add(prod);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return producers;

	}
	public static void updateByName(int id, String newName) {
	    String sql = "UPDATE anime_store.producer SET name = '" + newName + "' WHERE id = " + id;
	    try (Connection conn = ConnectionFactory.getConnection();
	         Statement stmt = conn.createStatement()) {

	        int rowsUpdated = stmt.executeUpdate(sql);
	        if (rowsUpdated > 0) {
	            System.out.println("Produtor atualizado com sucesso.");
	        } else {
	            System.out.println("Nenhum produtor encontrado com o ID fornecido.");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
