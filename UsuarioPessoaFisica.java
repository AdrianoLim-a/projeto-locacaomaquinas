import java.util.List;

public class UsuarioPessoaFisica extends Usuario {
    private String cpf;
    private int idade;

    public UsuarioPessoaFisica(){}


    public UsuarioPessoaFisica(int codigo, String nome, String email, String endereco, String historico, String cpf, int idade) {
        super(codigo, nome, email, historico, endereco);
        this.cpf = cpf;
        this.idade = idade;
    }
    


    @Override
    public void mostrar() {
        super.mostrar();
        System.out.println("CPF: " + getCpf());
        System.out.println("Idade: " + getIdade());
    }

    @Override
    public void acessarCatalago(Plataforma plataforma) {
        List<Maquina> catalago = plataforma.getCatalago();

        for (Maquina maquina : catalago) {
            System.out.println("Maquina: " + maquina.getNome());
        }
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public void efetuar(){
        //todo
    }
    public void acionar(){
        //todo
    }


    public void cadastrarPF(int codigo, String nome, String email,String endereco, String historico, String cpf, int idade) {

        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
        setCpf(cpf);
        setEndereco(endereco);
        setHistorico(historico);
        setIdade(idade);
    }


    public void cadastrarPF() {
        UsuarioPessoaFisicaDAO dao = new UsuarioPessoaFisicaDAO();
        if(dao.inserir(this)>=1){
            System.out.println("Usuário Cadastrado com sucesso !");
        } else {
            System.out.println("Ocorreu um erro ao inserir o Usuário !");
        }
    }
}
