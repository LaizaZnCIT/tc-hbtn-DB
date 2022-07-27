import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {
    public Connection connect (String urlConexao) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConexao);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return connection;
    }
    public void createTable(String urlConexao) {
        StringBuilder createTableQuery = new StringBuilder();
        createTableQuery.append("CREATE TABLE IF NOT EXISTS cliente (");
        createTableQuery.append("id integer PRIMARY KEY, ");
        createTableQuery.append("nome text NOT NULL, ");
        createTableQuery.append("idade integer, ");
        createTableQuery.append("cpf text NOT NULL, ");
        createTableQuery.append("rg text ");
        createTableQuery.append(")");

        try {
            Connection connection = this.connect(urlConexao);
            Statement statement = connection.createStatement();
            statement.execute(createTableQuery.toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void insert(String url_conexao, Cliente cliente) {
        String insertQuery = "INSERT INTO cliente(nome, idade, cpf, rg) VALUES(?, ?, ?, ?)";

        try (Connection connection = this.connect(url_conexao);
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getIdade());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectAll(String urlConexao) {
        String selectQuery = "SELECT * FROM cliente";
        try (Connection connection = this.connect(urlConexao);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(selectQuery)) {
            while (result.next()) {
                System.out.println(result.getInt("id") + "\t" + result.getString("nome") + "\t" + result.getInt("idade") + "\t" +
                        result.getString("cpf") + "\t" + result.getString("rg"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void update(String urlConexao, int id, String name, Integer idade) {
        String updateQuery = "UPDATE cliente SET nome = ? , " + "idade = ? " + "WHERE id = ?";
        try (Connection connection = this.connect(urlConexao);
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, idade);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void delete(String urlConexao, int id) {
        String deleteQuery = "DELETE FROM cliente WHERE id = ?";
        try (Connection connection = this.connect(urlConexao);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
