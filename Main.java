import javax.swing.*;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        Maquina maquina = plataforma.cadastrarMaquina(1, "Copiadora", "Escritório", "0", "0", 75);
        MaquinaDAO maquinaDAO = new MaquinaDAO();
        maquinaDAO.inserir(maquina);

        UsuarioPessoaFisica usuarioPF = new UsuarioPessoaFisica();
        usuarioPF.cadastrarPF(0, "Jose Gonçalvez", "jose@gmail.com", "Rua Americo da Silva,321", "inexistente", "774.115.445-09", 25);
        usuarioPF.mostrar();
        UsuarioPessoaFisicaDAO usuarioPessoaFisicaDao = new UsuarioPessoaFisicaDAO();
        usuarioPessoaFisicaDao.inserir(usuarioPF);


        UsuarioPessoaJuridica usuarioPJ = new UsuarioPessoaJuridica();
        usuarioPJ.cadastrarPJ(2, "Ribamar Produções", "jose@ribamar.com.br", " Rua Baltazar Vidal,123","inexistente", "12.745.154/0001-00", "Otavio Costa");
        usuarioPJ.mostrar();
        UsuarioPessoaJuridicaDAO usuarioPessoaJuridicaDAO = new UsuarioPessoaJuridicaDAO();
        usuarioPessoaJuridicaDAO.inserir(usuarioPJ);

        LocalDate dataRetiradaPF = LocalDate.now();
        LocalDate dataDevolucaoPF = dataRetiradaPF.plusDays(15);

        Locacao locacaoPF = plataforma.gerarLocacao(1, maquina, usuarioPF, dataRetiradaPF, dataDevolucaoPF, 0, true);


        LocalDate dataRetiradaPJ = LocalDate.now();
        LocalDate dataDevolucaoPJ = dataRetiradaPJ.plusDays(14);
        Locacao locacaoPJ = plataforma.gerarLocacao(2, maquina, usuarioPJ, dataRetiradaPJ, dataDevolucaoPJ,0, false);

        LocacaoDAO locacaoDAO = new LocacaoDAO();
        locacaoDAO.inserir(locacaoPF);
        locacaoDAO.inserir(locacaoPJ);

        System.out.println("\nLocação para Pessoa Física:");
        locacaoPF.mostrar(true);

        System.out.println("\nLocação para Pessoa Jurídica:");
        locacaoPJ.mostrar(false);

        Feedback feedback1 = new Feedback(0,maquina,usuarioPF,"Copiadora muito ruim, nunca mais uso");
        feedback1.mostrar(true);
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        feedbackDAO.inserir(feedback1);

        Suporte suporte = new Suporte();
        suporte.criarChamado(1,"Em andamento",usuarioPF,"Não consta");
        Suporte ultimoChamado = suporte.getLocacaoSuporte().get(suporte.getLocacaoSuporte().size() - 1);
        suporte.mostrar(ultimoChamado, true);
        SuporteDAO suporteDAO = new SuporteDAO();
        suporteDAO.inserir(ultimoChamado);


        UsuarioPessoaFisicaForm janela = new UsuarioPessoaFisicaForm();
        janela.setVisible(true);

    }

}
