import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaquinaDAO {

        private Conexao conexao = new Conexao();

        public int inserir(Maquina maquina) {
            conexao.conectar();

            String Sql = "insert into maquina(nome,categoria, avaliacoes,imagens, valorlocacao) " +
                    "values(?,?,?,?,?)";

            PreparedStatement stmt = conexao.prepareStatement(Sql);
            try {
                stmt.setString(1, maquina.getNome());
                stmt.setString(2, maquina.getCategoria());
                stmt.setString(3, maquina.getAvaliacoes());
                stmt.setString(4, maquina.getImagens());
                stmt.setDouble(5, maquina.getValorLocacao());
                return stmt.executeUpdate();
            } catch (SQLException err) {
                System.err.println(err.getMessage());
                return 0;
            } finally {
                conexao.desconectar();
            }
        }

    public int alterar(Maquina maquina) {
        conexao.conectar();

        String Sql = "update maquina set nome=?, categoria=?,avaliacoes=?,imagens=?," +
                "valorlocacao=? where codigo=?";

        PreparedStatement stmt = conexao.prepareStatement(Sql);
        try {
            stmt.setString(1, maquina.getNome());
            stmt.setString(2, maquina.getCategoria());
            stmt.setString(3, maquina.getAvaliacoes());
            stmt.setString(4, maquina.getImagens());
            stmt.setDouble(5, maquina.getValorLocacao());
            stmt.setInt(6,maquina.getCodigo());
            return stmt.executeUpdate();
        } catch (SQLException err) {
            System.err.println(err.getMessage());
            return 0;
        } finally {
            conexao.desconectar();
        }
    }

}