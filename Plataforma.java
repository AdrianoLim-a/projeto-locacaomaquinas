import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
public class Plataforma {

    private int identificador;
    private List<Maquina> catalago = new ArrayList<Maquina>();
    private String opcaoEntrega;

    private String opcaoRetirada;

    private String avaliacao;

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    private List<Locacao> locacoes = new ArrayList<>();
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public List<Maquina> getCatalago() {
        return catalago;
    }

    public void setCatalago(List<Maquina> catalago) {
        this.catalago = catalago;
    }

    public String getOpcaoEntrega() {
        return opcaoEntrega;
    }

    public void setOpcaoEntrega(String opcaoEntrega) {
        this.opcaoEntrega = opcaoEntrega;
    }

    public String getOpcaoRetirada() {
        return opcaoRetirada;
    }

    public void setOpcaoRetirada(String opcaoRetirada) {
        this.opcaoRetirada = opcaoRetirada;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
    public Maquina cadastrarMaquina(int codigo, String nome, String categoria, String avaliacoes, String imagens, double valorLocacao){
        Maquina novaMaquina = new Maquina(codigo,nome,categoria,avaliacoes,imagens,valorLocacao);
        catalago.add(novaMaquina);
        novaMaquina.mostrar();
        return novaMaquina;
    }
    public Maquina pesquisarMaquina(String nome) {
        try {
            for (Maquina maquina : catalago) {
                if (maquina.getNome().equalsIgnoreCase(nome)) {
                    return maquina;
                }
            }
        } catch ( Exception erro1) {
            System.out.println("Maquina não localizada" +erro1.getMessage());
        }
        return null;
    }

    public Locacao gerarLocacao(int numeroTransacao, Maquina maquina, Usuario usuario, LocalDate dataRetirada, LocalDate dataDevolucao, double valor, boolean isPessoaFisica) {
        long diasUtilizados = ChronoUnit.DAYS.between(dataRetirada, dataDevolucao);
        double valorLocacaoMaquina = maquina.getValorLocacao();
        valor = valorLocacaoMaquina * diasUtilizados;

        Locacao novaLocacao = new Locacao(numeroTransacao, maquina, usuario, dataRetirada, dataDevolucao, valor);
        novaLocacao.setNumeroTransacao(numeroTransacao);
        novaLocacao.setSituacaoPedido("Gerado");
        novaLocacao.setMaquina(maquina);
        novaLocacao.setDataRetirada(dataRetirada);
        novaLocacao.setDataDevolucao(dataDevolucao);
        valorLocacaoMaquina = maquina.getValorLocacao();
        valor = maquina.getValorLocacao() * diasUtilizados;
        novaLocacao.setValor(valor);
        if (isPessoaFisica && usuario instanceof UsuarioPessoaFisica) {
            novaLocacao.setUsuarioPessoaFisica((UsuarioPessoaFisica) usuario);
        } else if (!isPessoaFisica && usuario instanceof UsuarioPessoaJuridica) {
            novaLocacao.setUsuarioPessoaJuridica((UsuarioPessoaJuridica) usuario);
        }
        locacoes.add(novaLocacao);
        return novaLocacao;
    }



}
