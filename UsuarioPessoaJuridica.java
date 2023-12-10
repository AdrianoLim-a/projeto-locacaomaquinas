import java.util.List;

public class UsuarioPessoaJuridica extends Usuario {

    private String cnpj;
    private String responsavel;

    public UsuarioPessoaJuridica (int codigo, String nome, String email, String historico, String endereco, String cnpj, String responsavel){
        super(codigo,nome,email,historico,endereco);
        setCnpj(cnpj);
        setResponsavel(responsavel);
    };

    public UsuarioPessoaJuridica() {

    }

    public void mostrar() {
        super.mostrar();
        System.out.println("CNPJ: " + getCnpj());
        System.out.println("Responsavel: " + getResponsavel());
    }

    public void cadastrarPJ(int codigo, String nome, String email, String endereco, String historico, String cnpj, String responsavel) {
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
        setEndereco(endereco);
        setHistorico(historico);
        setCnpj(cnpj);
        setResponsavel(responsavel);
    }


    public void acessarCatalago(Plataforma plataforma) {
        List<Maquina> catalago = plataforma.getCatalago();

        for (Maquina maquina : catalago) {
            System.out.println("Maquina: " + maquina.getNome());
        }
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void acionar(){
        //todo
    }


    public String getNomeEmpresa() {
        return null;
    }
}

