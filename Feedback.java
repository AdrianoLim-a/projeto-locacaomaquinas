import java.util.ArrayList;
import java.util.List;

public class Feedback {

    private int numeroAvaliacao;
    private UsuarioPessoaFisica usuarioPessoaFisica;
    private UsuarioPessoaJuridica usuarioPessoaJuridica;
    private Maquina maquina;
    private String comentario;
    private List<Feedback> feedbacks;


    public Feedback(int numeroAvaliacao, Maquina maquina, Usuario usuario, String comentario) {
        setNumeroAvaliacao(numeroAvaliacao);
        setMaquina(maquina);
        setComentario(comentario);

        if (usuario instanceof UsuarioPessoaFisica) {
            setUsuarioPessoaFisica((UsuarioPessoaFisica) usuario);
        } else if (usuario instanceof UsuarioPessoaJuridica) {
            setUsuarioPessoaJuridica((UsuarioPessoaJuridica) usuario);
        }
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

    public List<Feedback> getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(List<Feedback> feedbacks) {
        this.feedbacks = feedbacks;
    }

    public Feedback() {
        this.feedbacks = new ArrayList<>();
    }

    public int getNumeroAvaliacao() {
        return numeroAvaliacao;
    }

    public void setNumeroAvaliacao(int numeroAvaliacao) {
        this.numeroAvaliacao = numeroAvaliacao;
    }


    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void cadastrar(Usuario usuario, Maquina maquina, int numeroAvaliacao, String comentario) {
        Feedback feedback = new Feedback(numeroAvaliacao, maquina, usuario, comentario);
        feedbacks.add(feedback);
        System.out.println("Feedback cadastrado com sucesso!");
    }

    public void consultar(boolean isPessoaFisica) {
        if (feedbacks.isEmpty()) {
            System.out.println("Não há feedbacks cadastrados.");
        } else {
            for (Feedback feedback : feedbacks) {

                System.out.println("Número de Avaliação: " + feedback.getNumeroAvaliacao());
                if (isPessoaFisica) {
                    System.out.println("Usuário Pessoa Física: " + getUsuarioPessoaFisica().getNome());
                } else {
                    System.out.println("Usuário Pessoa Jurídica: " + getUsuarioPessoaJuridica().getNome());
                }
                System.out.println("Máquina: " + feedback.getMaquina().getNome());
                System.out.println("Comentário: " + feedback.getComentario());
                System.out.println("------------");
            }
        }
    }

    public void mostrar(boolean isPessoaFisica) {
        System.out.println("\n#############FEEDBACK###############");

        if (isPessoaFisica && getUsuarioPessoaFisica() != null) {
            System.out.println("Usuário Pessoa Física: " + getUsuarioPessoaFisica().getNome());
        } else if (!isPessoaFisica && getUsuarioPessoaJuridica() != null) {
            System.out.println("Usuário Pessoa Jurídica: " + getUsuarioPessoaJuridica().getNome());
        } else {
            System.out.println("Usuário: Não disponível");
        }

        if (getMaquina() != null) {
            System.out.println("Máquina: " + getMaquina().getNome());
        } else {
            System.out.println("Máquina: Não disponível");
        }
        System.out.println("Comentario: " + getComentario());
    }


}