public abstract class Usuario {

    private int codigo;
    private String nome;
    private String email;
    private String historico;
    private String endereco;


    public Usuario(){}

    public Usuario(int codigo, String nome, String email,  String endereco, String historico){
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
        setHistorico(historico);

    }


    public void mostrar(){
        System.out.println("#############USUARIO###############");
        System.out.println("Nome: "+ getNome());
        System.out.println("Email: "+ getEmail());
        System.out.println("Endereço: "+ getEndereco());
        System.out.println("Historico: "+getHistorico());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public abstract void acessarCatalago(Plataforma plataforma);
}
