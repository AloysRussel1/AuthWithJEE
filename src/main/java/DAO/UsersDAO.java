package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Users;

public class UsersDAO {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/freehousedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private String jdbcUsername = "Aloys";
    private String jdbcPassword = "aloys12345";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, email, password, recoveryWord) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT id, username, email, password, recoveryWord FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?;";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";
    private static final String CHECK_LOGIN_SQL = "SELECT * FROM users WHERE username = ? AND password = ?;";
    private static final String UPDATE_PASSWORD_SQL = "UPDATE users SET password = ? WHERE username = ?;";

    public UsersDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to create the database connection: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        }
        return connection;
    }

    public void insertUser(Users user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            if (connection == null) {
                System.err.println("Connection is null, cannot insert user.");
                return;
            }
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRecoveryWord());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Users selectUserByUsername(String username) {
        Users user = null;
        String sql = "SELECT * FROM users WHERE username = ?;";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (connection == null) {
                System.err.println("Connection is null, cannot select user.");
                return null;
            }
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                user = new Users();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRecoveryWord(rs.getString("recoveryWord"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<Users> selectAllUsers() {
        List<Users> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            if (connection == null) {
                System.err.println("Connection is null, cannot select all users.");
                return users;
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String recoveryWord = rs.getString("recoveryWord");
                users.add(new Users(id, username, email, password, recoveryWord));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public Users checkLogin(String username, String password) throws SQLException {
        Users user = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (connection == null) {
                System.err.println("Connection is null, cannot check login.");
                return null;
            }
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRecoveryWord(resultSet.getString("recoveryWord"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public void updatePassword(String username, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE username = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
