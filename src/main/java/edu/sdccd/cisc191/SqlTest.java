package edu.sdccd.cisc191;


import java.sql.*;

public class SqlTest {

    public static void main(String[] args)
    {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://cisc191.cnja3eafntr2.us-east-1.rds.amazonaws.com:5432/", "postgres", "Ruj677xic")) {

            String sql = "SELECT * FROM logininfo";

            try(Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(sql)) {
                    while(resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("username");
                        String password = resultSet.getString("password");

                        System.out.println("ID: " + id + ", Name: " + name + ", Password: " + password);
                    }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
