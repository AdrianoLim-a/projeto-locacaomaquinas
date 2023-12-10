import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class FeedbackDAO {
    private Conexao conexao = new Conexao();

    public int inserir(Feedback feedback) {
        conexao.conectar();

        String sql = "insert into feedback(maquina, usuariopessoafisica, usuariopessoajuridica, comentario) " +
                "values(?,?,?,?)";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        try {
            if (feedback != null && feedback.getMaquina() != null) {
                stmt.setString(1, feedback.getMaquina().getNome());
            }

            if (feedback.getUsuarioPessoaFisica() != null) {
                stmt.setString(2, feedback.getUsuarioPessoaFisica().getNome());
                stmt.setString(3, "Não aplicável");
            } else if (feedback.getUsuarioPessoaJuridica() != null) {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, feedback.getUsuarioPessoaJuridica().getNome());
            } else {
                stmt.setString(2, "Não aplicável");
                stmt.setString(3, "Não aplicável");
            }
                stmt.setString(4, feedback.getComentario());



            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }
}
