package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/jeu_paires";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // si tu as mis un mot de passe, mets-le ici

    public static void insererScore(String nom, int temps) {
        String sql = "INSERT INTO scores (nom, temps) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nom);
            stmt.setInt(2, temps);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getMeilleursTemps() {
        List<Integer> top3 = new ArrayList<>();
        String sql = "SELECT temps FROM scores ORDER BY temps ASC LIMIT 3";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                top3.add(rs.getInt("temps"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return top3;
    }
}
