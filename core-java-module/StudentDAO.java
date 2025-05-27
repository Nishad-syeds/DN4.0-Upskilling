import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        conn = DriverManager.getConnection(url, user, password);
    }

    public void insertStudent(int id, String name) throws SQLException {
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        }
    }

    public void updateStudent(int id, String newName) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();
            dao.insertStudent(1, "Alice");
            dao.updateStudent(1, "Alicia");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
