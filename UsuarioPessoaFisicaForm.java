import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioPessoaFisicaForm extends JFrame {


    private JPanel Panel1;
    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtEndereco;
    private JTextField txtHistorico;
    private JTextField txtCpf;
    private JTextField txtIdade;

    private JButton btnInserir;
    private JButton alterarButton;
    private JButton pesquisarButton;
    private JTextField txtCodigo;
    private JPanel panel1;


    public UsuarioPessoaFisicaForm() {
        this.add(Panel1);
        this.setSize(300, 500);
        this.setTitle("Cadastro de Usuário Pessoa Fisica");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        btnInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioPessoaFisica obj = new UsuarioPessoaFisica();
                obj.setCpf(txtNome.getText());
                obj.setEmail(txtEmail.getText());
                obj.setEndereco(txtEndereco.getText());
                obj.setHistorico(txtHistorico.getText());
                obj.setCpf(txtCpf.getText());
                obj.setIdade(Integer.parseInt(txtIdade.getText()));
                obj.cadastrarPF();
                JOptionPane.showMessageDialog(null,
                        "Usuário cadastrado com sucesso!");
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}