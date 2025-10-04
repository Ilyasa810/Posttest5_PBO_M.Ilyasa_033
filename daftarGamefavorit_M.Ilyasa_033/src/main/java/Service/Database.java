package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/db_game_favorit";
    private static final String USER = "root"; // ganti sesuai user MySQL kamu
    private static final String PASS = "";     // isi password MySQL kamu

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Menampilkan semua PC Game
    public void tampilkanPCGame() {
        String sql = "SELECT * FROM pc_game";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== Daftar PC Game ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("no") + ". " +
                        rs.getString("nama_game") + " | " +
                        rs.getString("genre_game") + " | " +
                        rs.getString("tahun_rilis")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Menampilkan semua Mobile Game
    public void tampilkanMobileGame() {
        String sql = "SELECT * FROM mobile_game";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== Daftar Mobile Game ===");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("no") + ". " +
                        rs.getString("nama_game") + " | " +
                        rs.getString("genre_game") + " | " +
                        rs.getString("tahun_rilis")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Menampilkan gabungan PC dan Mobile Game
    public void tampilkanSemuaGame() {
        String sql = "SELECT no, nama_game, genre_game, tahun_rilis, 'PC' AS platform FROM pc_game " +
                     "UNION " +
                     "SELECT no, nama_game, genre_game, tahun_rilis, 'Mobile' AS platform FROM mobile_game";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n=== Daftar Semua Game (PC & Mobile) ===");
            while (rs.next()) {
                System.out.println(
                        rs.getString("nama_game") + " | " +
                        rs.getString("genre_game") + " | " +
                        rs.getString("tahun_rilis") + " | " +
                        rs.getString("platform")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
