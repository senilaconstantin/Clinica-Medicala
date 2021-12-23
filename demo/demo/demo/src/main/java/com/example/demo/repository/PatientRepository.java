package com.example.demo.repository;

import com.example.demo.connection.ConnectionFactory;
import com.example.demo.model.Appointment;
import com.example.demo.model.Recipe;

import java.sql.*;

public class PatientRepository {

    private String createSelectQueryForRecipe() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("listOfDrugs");
        sb.append(" FROM ");
        sb.append("recipe WHERE usernamePatient = ? and usernameDoctor = ?");
        return sb.toString();
    }

    public ResultSet drugsRecipe(String usernamePatient, String usernameDoctor) {
        Connection connection = ConnectionFactory.getConnection();
        String rezSelect = createSelectQueryForRecipe();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(rezSelect, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, usernamePatient);
            statement.setString(2, usernameDoctor);
            statement.execute(rezSelect);
            ResultSet rs = statement.getResultSet();
            return rs;
        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING, type.getSimpleName() + "Dao (select): " + e.getMessage());
        }
        return null;
    }

    private static final String insertAppointment = "INSERT INTO appointment (usernameDoctor, usernamePatient, date)" + " VALUES (?,?,?)";
    private static final String insertDoctorNotify = "INSERT INTO doctorNotify (usernameDoctor, message)" + " VALUES (?,?)";

    public void addAppointment(Appointment appointment) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;

        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertAppointment, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, appointment.getUsernameDoctor());
            insertStatement.setString(2, appointment.getUsernamePatient());
            insertStatement.setString(3, String.valueOf(appointment.getDate()));
            insertStatement.executeUpdate();

            insertDoctorNotify(dbConnection, appointment);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    private void insertDoctorNotify(Connection dbConnection, Appointment appointment) {
        PreparedStatement insertStatement1 = null;
        try {
            insertStatement1 = dbConnection.prepareStatement(insertDoctorNotify, Statement.RETURN_GENERATED_KEYS);
            insertStatement1.setString(1, appointment.getUsernameDoctor());
            insertStatement1.setString(2, appointment.toString());
            insertStatement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String createSelectQueryForDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("firstName, lastName, userName, password, email, phoneNumber");
        sb.append(" FROM ");
        sb.append("user WHERE userName = ? and password = ?");
        return sb.toString();
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
