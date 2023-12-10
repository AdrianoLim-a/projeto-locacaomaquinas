import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class LocacaoDAO {
    private Conexao conexao = new Conexao();

    public int inserir(Locacao locacao) {
        conexao.conectar();

        String sql = "insert into locacao(maquina, usuariopessoafisica, usuariopessoajuridica, dataretirada, datadevolucao, valor) " +
                "values(?,?,?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        try {
            if (locacao != null && locacao.getMaquina() != null) {
                stmt.setString(1, locacao.getMaquina().getNome());
            }

            if (locacao.getUsuarioPessoaFisica() != null) {
                stmt.setString(2, locacao.getUsuarioPessoaFisica().getNome());
                stmt.setString(3, "Não aplicável");
            } else if (locacao.getUsuarioPessoaJuridica() != null) {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, locacao.getUsuarioPessoaJuridica().getNome());
            } else {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, "Não aplicável");
            }

            stmt.setDate(4, Date.valueOf(locacao.getDataRetirada()));
            stmt.setDate(5, Date.valueOf(locacao.getDataDevolucao()));
            stmt.setDouble(6, locacao.getValor());

            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
}
