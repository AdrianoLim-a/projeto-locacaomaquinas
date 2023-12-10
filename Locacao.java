import java.time.LocalDate;

public class Locacao {
    private int numeroTransacao;
    private Maquina maquina;
    private UsuarioPessoaFisica usuarioPessoaFisica;
    private UsuarioPessoaJuridica usuarioPessoaJuridica;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    private String situacaoPedido;
    private double valor;

    public Locacao() {
    }

    public UsuarioPessoaFisica getUsuarioPessoaFisica() {
        return usuarioPessoaFisica;
    }

    public void setUsuarioPessoaFisica(UsuarioPessoaFisica usuarioPessoaFisica) {
        this.usuarioPessoaFisica = usuarioPessoaFisica;
    }

    public UsuarioPessoaJuridica getUsuarioPessoaJuridica() {
        return usuarioPessoaJuridica;
    }

    public void setUsuarioPessoaJuridica(UsuarioPessoaJuridica usuarioPessoaJuridica) {
        this.usuarioPessoaJuridica = usuarioPessoaJuridica;
    }


    public Locacao(int numeroTransacao, Maquina maquina, Usuario usuario, LocalDate dataRetirada, LocalDate dataDevolucao) {
        setNumeroTransacao(numeroTransacao);
        setMaquina(maquina);
        setDataRetirada(dataRetirada);
        setDataDevolucao(dataDevolucao);
        setValor(valor);
    }

    public Locacao(int numeroTransacao, Maquina maquina, Usuario usuario, LocalDate dataRetirada, LocalDate dataDevolucao, double valor) {
    }

    public int getNumeroTransacao() {
        return numeroTransacao;
    }

    public void setNumeroTransacao(int numeroTransacao) {
        this.numeroTransacao = numeroTransacao;
    }

    public Maquina getMaquina() {
        return this.maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }


    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getSituacaoPedido() {
        return situacaoPedido;
    }

    public void setSituacaoPedido(String situacaoPedido) {
        this.situacaoPedido = situacaoPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void mostrar(boolean isPessoaFisica) {
        System.out.println("\n#############LOCAÇÃO###############");
        System.out.println("Número de Transação: " + getNumeroTransacao());
        if (getMaquina() != null) {
            System.out.println("Máquina: " + getMaquina().getNome());
        } else {
            System.out.println("Máquina: Não disponível");
        }

        if (isPessoaFisica) {
            System.out.println("Usuário Pessoa Física: " + getUsuarioPessoaFisica().getNome());
        } else {
            System.out.println("Usuário Pessoa Jurídica: " + getUsuarioPessoaJuridica().getNome());
        }

        System.out.println("Data de Retirada: " + getDataRetirada());
        System.out.println("Data de Devolução: " + getDataDevolucao());
        System.out.println("Situação do Pedido: " + getSituacaoPedido());
        System.out.println("Valor: " + getValor());
    }



}
