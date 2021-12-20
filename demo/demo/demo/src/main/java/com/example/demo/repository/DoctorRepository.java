package com.example.demo.repository;


import com.example.demo.connection.ConnectionFactory;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class DoctorRepository {

    private static final String insertStatementString = "INSERT INTO user (firstName,lastName)" + " VALUES (?,?)";

    public int addPatient(User user) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, user.getFirstName());
            insertStatement.setString(2, user.getLastName());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            //LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    private String createDeleteQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delete ");
        sb.append("from ");
        sb.append("user");
        sb.append(" where id" + " = ? ");
        return sb.toString();
    }

    public void deletePatient(int id) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        String rezDelete = createDeleteQuery();

        //System.out.println(rezDelete);
        try {
            statement = connection.prepareStatement(rezDelete);
            statement.setString(1, String.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (delete): " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    private String createSelectQueryForPatients() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("user WHERE role = 'patient'");
        return sb.toString();
    }

    public ResultSet showPatients() {
        Connection connection = ConnectionFactory.getConnection();
        String rezSelect = createSelectQueryForPatients();
        try {
            Statement statement = connection.createStatement();
            statement.execute(rezSelect);
            ResultSet rs = statement.getResultSet();
            return rs;
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (select): " + e.getMessage());
        }
        return null;
    }

    private String createSelectQueryForNurses() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("user WHERE role = 'nurse'");
        return sb.toString();
    }

    public ResultSet showNurses() {
        Connection connection = ConnectionFactory.getConnection();
        String rezSelect = createSelectQueryForNurses();
        try {
            Statement statement = connection.createStatement();
            statement.execute(rezSelect);
            ResultSet rs = statement.getResultSet();
            return rs;
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (select): " + e.getMessage());
        }
        return null;
    }

    private String updateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("update ");
        sb.append("user" + " set ");
        sb.append("drugsRecipe = ?");
        sb.append(" where id = ?");
        return sb.toString();
    }

    public void updateDrugsRecipe(int id, String drugsRecipe) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(updateQuery());
            statement.setString(2, String.valueOf(id));
            statement.setString(1, drugsRecipe);
            statement.executeUpdate();
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName()+"Dao (edit): " + e.getMessage());
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}
