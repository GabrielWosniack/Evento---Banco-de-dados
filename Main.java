import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3306/Tabela_Evento";
        final String USER = "root";
        final String PASSWORD = "root";
        final String CONSULTA = "select * from Evento";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado");

            Statement sc = con.createStatement();
            System.out.println("Statement criado");

            String query = "insert into Evento (nome_evento, local_evento, data_evento, capacidade_evento) values (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);

            String nome = JOptionPane.showInputDialog("Digite o nome do evento");
            String local = JOptionPane.showInputDialog("Digite o local do evento");
            String data = JOptionPane.showInputDialog("Digite a data do evento");
            String capacidade = JOptionPane.showInputDialog("Digite a capacidade do evento");

            stmt.setString(1, nome);
            stmt.setString(2, local);
            stmt.setString(3, data);
            stmt.setString(4, capacidade);

            int LinhasAfetadas = stmt.executeUpdate();
            System.out.println("Dado inseridos!");

            ResultSet resultSet = stmt.executeQuery(CONSULTA);

            while (resultSet.next()){
            System.out.println(resultSet.getString("nome_evento"));
            System.out.println(resultSet.getString("local_evento"));
            System.out.println(resultSet.getString("data_evento"));
            System.out.println(resultSet.getString("capacidade_evento"));

            }

        }   catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }

}