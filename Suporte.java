import java.util.List;
import java.util.ArrayList;
public class Suporte {
    private int numeroChamado;
    private String status;
    private String historico;

    private UsuarioPessoaJuridica usuarioPessoaJuridica;

    private UsuarioPessoaFisica usuarioPessoaFisica;

    private List<Suporte> locacaoSuporte = new ArrayList<>();

    public Suporte(){};

    public Suporte(int numeroChamado, String status, Usuario usuario, String historico){
        setNumeroChamado(numeroChamado);
        setStatus(status);
        setHistorico(historico);
        if (usuario instanceof UsuarioPessoaFisica) {
            setUsuarioPessoaFisica((UsuarioPessoaFisica) usuario);
        } else if (usuario instanceof UsuarioPessoaJuridica) {
            setUsuarioPessoaJuridica((UsuarioPessoaJuridica) usuario);
        }

    }
    public int getNumeroChamado() {
        return numeroChamado;
    }

    public void setNumeroChamado(int numeroChamado) {
        this.numeroChamado = numeroChamado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }


    public List<Suporte> getLocacaoSuporte() {
        return locacaoSuporte;
    }

    public void setLocacaoSuporte(List<Suporte> locacaoSuporte) {
        this.locacaoSuporte = locacaoSuporte;
    }

    public UsuarioPessoaJuridica getUsuarioPessoaJuridica() {
        return usuarioPessoaJuridica;
    }

    public void setUsuarioPessoaJuridica(UsuarioPessoaJuridica usuarioPessoaJuridica) {
        this.usuarioPessoaJuridica = usuarioPessoaJuridica;
    }

    public UsuarioPessoaFisica getUsuarioPessoaFisica() {
        return usuarioPessoaFisica;
    }

    public void setUsuarioPessoaFisica(UsuarioPessoaFisica usuarioPessoaFisica) {
        this.usuarioPessoaFisica = usuarioPessoaFisica;
    }

        public void criarChamado(int numeroChamado, String status, Usuario usuario,String historico) {
        Suporte novoChamado = new Suporte(numeroChamado, status,usuario, historico);
        locacaoSuporte.add(novoChamado);
        novoChamado.setNumeroChamado(numeroChamado);
        novoChamado.setStatus(status);
        if (usuario instanceof UsuarioPessoaFisica) {
            novoChamado.setUsuarioPessoaFisica((UsuarioPessoaFisica) usuario);
        } else if (usuario instanceof UsuarioPessoaJuridica) {
            novoChamado.setUsuarioPessoaJuridica((UsuarioPessoaJuridica) usuario);
        }
        novoChamado.setHistorico(historico);
        System.out.println("Chamado de suporte criado com sucesso!");
    }


    public void consultarChamados() {
        if (locacaoSuporte.isEmpty()) {
            System.out.println("Não há chamados de suporte cadastrados.");
        } else {
            try {
                for (Suporte chamado : locacaoSuporte) {
                    System.out.println("Número do Chamado: " + chamado.getNumeroChamado());
                    System.out.println("Status: " + chamado.getStatus());
                    System.out.println("Histórico: " + chamado.getHistorico());
                    System.out.println("------------");
                }
            }catch(Exception error2){
                System.out.println("Numero de Chamado não localizado" +error2.getMessage());
            }
        }
    }


    public void mostrar(Suporte chamado, boolean isPessoaFisica) {
        System.out.println("\n#############CHAMADO SUPORTE###############");

        System.out.println("Status: " + chamado.getStatus());
        if (isPessoaFisica && chamado.getUsuarioPessoaFisica() != null) {
            System.out.println("Usuário Pessoa Física: " + chamado.getUsuarioPessoaFisica().getNome());
        } else if (!isPessoaFisica && chamado.getUsuarioPessoaJuridica() != null) {
            System.out.println("Usuário Pessoa Jurídica: " + chamado.getUsuarioPessoaJuridica().getNome());
        } else {
            System.out.println("Usuário: Não disponível");
        }
        System.out.println("Histórico: " + chamado.getHistorico());
    }

}
