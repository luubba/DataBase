package Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DataBase.ConnectionFactory;
import Dominio.Anime;
import Dominio.Producer;

public class AnimeRepository {

    public static void save(Anime anime) {
        String sql = "INSERT INTO anime_store.anime (name, producer_id) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, anime.getName());
            pstmt.setInt(2, anime.getProducer().getId());
            int linhasafetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM anime_store.anime WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int linhasafetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Anime anime) {
        String sql = "UPDATE anime_store.anime SET name = ?, producer_id = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, anime.getName());
            pstmt.setInt(2, anime.getProducer().getId());
            pstmt.setInt(3, anime.getId());
            int linhasafetadas = pstmt.executeUpdate();
            System.out.println("Linhas afetadas nesta operação = " + linhasafetadas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Anime> findAll() {
        String sql = "SELECT a.id, a.name, p.id as producer_id, p.name as producer_name FROM anime_store.anime a INNER JOIN anime_store.producer p ON a.producer_id = p.id";
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("a.id");
                String name = rs.getString("a.name");
                int producerId = rs.getInt("producer_id");
                String producerName = rs.getString("producer_name");
                Producer producer = new Producer(producerName, producerId);
                Anime anime = new Anime(name, producer);
                animes.add(anime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }

    public static List<Anime> findByName(String name) {
        String sql = "SELECT a.id, a.name, p.id as producer_id, p.name as producer_name FROM anime_store.anime a INNER JOIN anime_store.producer p ON a.producer_id = p.id WHERE a.name LIKE ?";
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("a.id");
                    String name2 = rs.getString("a.name");
                    int producerId = rs.getInt("producer_id");
                    String producerName = rs.getString("producer_name");
                    Producer producer = new Producer(producerName, producerId);
                    Anime anime = new Anime(name2, producer);
                    animes.add(anime);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return animes;
    }
}
