package com.example.demo.repository;

import com.example.demo.connection.ConnectionFactory;

import java.sql.*;

public class PatientRepository {
    private String createSelectQueryForRecipe() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("drugsRecipe");
        sb.append(" FROM ");
        sb.append("user WHERE userName = ? and password = ?");
        return sb.toString();
    }

    private String createSelectQueryForDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("firstName, lastName, userName, password, email, phoneNumber");
        sb.append(" FROM ");
        sb.append("user WHERE userName = ? and password = ?");
        return sb.toString();
    }

    public ResultSet drugsRecipe(String userName, String password) {
        Connection connection = ConnectionFactory.getConnection();
        String rezSelect = createSelectQueryForRecipe();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(rezSelect, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.execute(rezSelect);
            ResultSet rs = statement.getResultSet();
            return rs;
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (select): " + e.getMessage());
        }
        return null;
    }

    public ResultSet showDetails(String userName, String password) {
        Connection connection = ConnectionFactory.getConnection();
        String rezSelect = createSelectQueryForDetails();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(rezSelect, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userName);
            statement.setString(2, password);
            statement.execute(rezSelect);
            ResultSet rs = statement.getResultSet();
            return rs;
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (select): " + e.getMessage());
        }
        return null;
    }
}
