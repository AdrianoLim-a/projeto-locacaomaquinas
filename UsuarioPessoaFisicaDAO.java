import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioPessoaFisicaDAO {
    private Conexao conexao = new Conexao();
    public int inserir(UsuarioPessoaFisica obj) {
        conexao.conectar();

        String Sql = "insert into usuariopessoafisica(nome,email,endereco,historico, cpf,idade) " +
                "values(?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getEndereco());
            stmt.setString(4, obj.getHistorico());
            stmt.setString(5, obj.getCpf());
            stmt.setInt(6, obj.getIdade());
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

    public int alterar(UsuarioPessoaFisica obj) {
        conexao.conectar();

        String Sql = "update usuariopessoafisica set nome=?,email=?, endereco=?,historico=?," +
                "cpf=?, idade=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getEndereco());
            stmt.setString(4, obj.getHistorico());
            stmt.setString(5, obj.getCpf());
            stmt.setInt(6, obj.getIdade());
            stmt.setInt(7, obj.getCodigo());
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int remover(int codigo) {
        conexao.conectar();

        String Sql = "delete from usuariopessoafisica where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setInt(1, codigo);
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
}

