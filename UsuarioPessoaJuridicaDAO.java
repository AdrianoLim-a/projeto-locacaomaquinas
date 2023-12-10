import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioPessoaJuridicaDAO {
    private Conexao conexao = new Conexao();
    public int inserir(UsuarioPessoaJuridica usuarioPJ) {
        conexao.conectar();

        String Sql = "insert into usuariopessoajuridica(nome,email,endereco,historico, cnpj, responsavel) " +
                "values(?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, usuarioPJ.getNome());
            stmt.setString(2, usuarioPJ.getEmail());
            stmt.setString(3, usuarioPJ.getEndereco());
            stmt.setString(4, usuarioPJ.getHistorico());
            stmt.setString(5, usuarioPJ.getCnpj());
            stmt.setString(6, usuarioPJ.getResponsavel());
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
    public int alterar(UsuarioPessoaJuridica usuarioPJ) {
        conexao.conectar();

        String Sql = "update usuariopessoajuridica set nome=?,email=?, endereco=?,historico=?," +
                "cnpj=?, resposanvel=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, usuarioPJ.getNome());
            stmt.setString(2, usuarioPJ.getEmail());
            stmt.setString(3, usuarioPJ.getEndereco());
            stmt.setString(4, usuarioPJ.getHistorico());
            stmt.setString(5, usuarioPJ.getCnpj());
            stmt.setString(6, usuarioPJ.getResponsavel());
            stmt.setInt(7,usuarioPJ.getCodigo());
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

        String Sql = "delete from usuariopessoajuridica where codigo=?";

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
