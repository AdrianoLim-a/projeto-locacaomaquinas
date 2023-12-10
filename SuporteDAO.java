import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SuporteDAO {

    private Conexao conexao = new Conexao();

    public int inserir(Suporte suporte) {
        conexao.conectar();

        String sql = "insert into suporte(status, usuariopessoafisica, usuariopessoajuridica, historico) " +
                "values(?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        try {

                stmt.setString(1,suporte.getStatus() );
            if (suporte.getUsuarioPessoaFisica() != null) {
                stmt.setString(2, suporte.getUsuarioPessoaFisica().getNome());
                stmt.setString(3, "Não aplicável");
            } else if (suporte.getUsuarioPessoaJuridica() != null) {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, suporte.getUsuarioPessoaJuridica().getNome());
            } else {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, "Não aplicável");
            }
            stmt.setString(4, suporte.getHistorico());



            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
}

