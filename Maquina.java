public class Maquina {
    private int codigo;
    public String nome;
    private String categoria;
    private String avaliacoes;
    private String imagens;

    private double valorLocacao;


    public Maquina(){}
    public Maquina(int codigo, String nome, String categoria, String avaliacoes, String imagens, double valorLocacao){

        this.setCodigo(codigo);
        this.setNome(nome);
        this.setCategoria(categoria);
        this.setAvaliacoes(avaliacoes);
        this.setImagens(imagens);
        this.setValorLocacao(valorLocacao);
    };

    public void mostrar(){
        System.out.println("#############MAQUINA###############");
        System.out.println("Nome: "+ getNome());
        System.out.println("Categoria: "+ getCategoria());
        System.out.println("Avaliações: "+ getAvaliacoes());
        System.out.println("Imagens: " + getImagens());
        System.out.println("Valor de Locação " + getValorLocacao());
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(String avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public String getImagens() {
        return imagens;
    }

    public void setImagens(String imagens) {
        this.imagens = imagens;
    }


    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

}
