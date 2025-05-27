import java.sql.*;

public class TransactionHandling {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            try (PreparedStatement debitStmt = conn.prepareStatement(
                     "UPDATE accounts SET balance = balance - ? WHERE id = ?");
                 PreparedStatement creditStmt = conn.prepareStatement(
                     "UPDATE accounts SET balance = balance + ? WHERE id = ?")) {

                // Debit from account 1
                debitStmt.setDouble(1, 100.0);
                debitStmt.setInt(2, 1);
                debitStmt.executeUpdate();

                // Credit to account 2
                creditStmt.setDouble(1, 100.0);
                creditStmt.setInt(2, 2);
                creditStmt.executeUpdate();

                conn.commit();
                System.out.println("Transaction committed successfully.");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction rolled back due to error.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
