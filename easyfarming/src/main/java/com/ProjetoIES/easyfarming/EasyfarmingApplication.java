package com.ProjetoIES.easyfarming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql. Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyfarmingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyfarmingApplication.class, args);
		try {
            // Carregue o driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecte-se ao servidor MySQL
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:33060/easyfarming", "easyfarming", "secret2");

            // Crie a consulta para apagar a tabela
            Statement statement = connection.createStatement();

            // Crie a consulta para listar as tabelas
            String query = "SHOW TABLES";

            // Execute a consulta
            ResultSet resultSet = statement.executeQuery(query);

            // Exiba a lista de tabelas
            System.out.println("Tabelas:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }

            // Feche o statement e a conexão
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	

}
