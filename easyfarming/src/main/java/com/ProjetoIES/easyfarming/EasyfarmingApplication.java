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

            //String query1 = "ALTER TABLE plants ADD COLUMN username VARCHAR(200);";
            //statement.execute(query1);

            //// Crie a consulta para listar as tabelas
            //String query1 = "ALTER TABLE userp ADD harmless VARCHAR(3);";
//
            //// Execute a consulta
            //statement.executeUpdate(query1);

            String query2 = "SELECT column_name FROM information_schema.columns WHERE table_name='userp';";
            ResultSet resultSet2 = statement.executeQuery(query2);

            // Exiba a lista de tabelas
            System.out.println("Colunas:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString(1));
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
