package Service;

import Model.Game;
import Model.PCGame;
import Model.MobileGame;

import java.sql.*;
import java.util.ArrayList;

public class GameService {
    private static final String URL = "jdbc:mysql://localhost:3306/db_game_favorit";
    private static final String USER = "root"; // ganti sesuai MySQL
    private static final String PASS = "";     // isi password MySQL

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // CREATE
    public void tambah(Game game) {
        String table = (game instanceof PCGame) ? "pc_game" : "mobile_game";
        String sql = "INSERT INTO " + table + " (nama_game, genre_game, tahun_rilis) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getNama());
            stmt.setString(2, game.getGenre());
            stmt.setInt(3, game.getTahunRilis());
            stmt.executeUpdate();

            System.out.println("Game berhasil ditambahkan ke " + table + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public void tampilkanPCGame() {
    // pakai YEAR() biar hanya keluar angka tahun
    String sql = "SELECT no, nama_game, genre_game, YEAR(tahun_rilis) AS tahun_rilis FROM pc_game";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n=== Daftar PC Game ===");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("no") + ". " +
                    rs.getString("nama_game") + " | " +
                    rs.getString("genre_game") + " | " +
                    rs.getInt("tahun_rilis")   // sudah angka tahun saja
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void tampilkanMobileGame() {
    // sama, gunakan YEAR() untuk kolom tahun
    String sql = "SELECT no, nama_game, genre_game, YEAR(tahun_rilis) AS tahun_rilis FROM mobile_game";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        System.out.println("\n=== Daftar Mobile Game ===");
        while (rs.next()) {
            System.out.println(
                    rs.getInt("no") + ". " +
                    rs.getString("nama_game") + " | " +
                    rs.getString("genre_game") + " | " +
                    rs.getInt("tahun_rilis")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    // UPDATE
    public void ubah(int id, Game game) {
        String table = (game instanceof PCGame) ? "pc_game" : "mobile_game";
        String sql = "UPDATE " + table + " SET nama_game=?, genre_game=?, tahun_rilis=? WHERE no=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, game.getNama());
            stmt.setString(2, game.getGenre());
            stmt.setInt(3, game.getTahunRilis());
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Game berhasil diubah di " + table + "!");
            } else {
                System.out.println("ID tidak ditemukan di " + table + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void hapus(int id, boolean isPC) {
        String table = isPC ? "pc_game" : "mobile_game";
        String sql = "DELETE FROM " + table + " WHERE no=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Game berhasil dihapus dari " + table + "!");
            } else {
                System.out.println("ID tidak ditemukan di " + table + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tampilkan() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
