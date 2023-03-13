package org.example.repository.implementation;

import org.example.model.Dentist;
import org.example.repository.DentistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DentistImplementation implements DentistRepository<Dentist> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_Dentist;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";
    private final Logger log = LoggerFactory.getLogger(DentistImplementation.class);




    @Override
    public Dentist save(Dentist dentist) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO dentist(" +
                    "license,name,lastName) " +
                    "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setLong(1, dentist.getLicense());
            preparedStatement.setString(2, dentist.getName());
            preparedStatement.setString(3, dentist.getLastName());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                dentist.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            log.warn("Dentist License does not exist!");

        }
        return dentist;

    }

    @Override
    public List<Dentist> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Dentist> dentist = new ArrayList<>();
        try {



            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("SELECT *  FROM dentist");


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {
                int idDentist = result.getInt("id");
                int license = result.getInt("license");
                String name = result.getString("name");
                String lastName = result.getString("lastName");


                Dentist dentist1 = new Dentist(idDentist, (long) license,name,lastName);
                dentist.add(dentist1);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            log.warn("Dentist License does not exist!");

        }

        return dentist;
    }

    @Override
    public Dentist findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Dentist dentist = null;
        try {


            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("SELECT license,name,lastName FROM dentist where id = ?");
            preparedStatement.setInt(1, id);


            ResultSet result = preparedStatement.executeQuery();


            while (result.next()) {
                int license = result.getInt("license");
                String name = result.getString("name");
                String lastName = result.getString("lastName");


                dentist = new Dentist((long) license, name, lastName);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            log.warn("Dentist License does not exist!");

        }

        return dentist;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("DELETE FROM dentist where id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("DROP TABLE dentist");

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            log.warn("Dentist License does not exist!");

        }
    }
}
