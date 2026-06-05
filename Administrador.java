// Administrador herda de Usuario e tem permissão total no sistema
public class Administrador extends Usuario {

    public Administrador(String nomeCompleto, String cpf, String email, String cargo, String login, String senha) {
        super(nomeCompleto, cpf, email, cargo, login, senha, "administrador");
    }

    // Ação específica do administrador
    public void gerenciarSistema() {
        System.out.println("Administrador " + getNomeCompleto() + " está gerenciando o sistema.");
    }

    @Override
    public void exibirDados() {
        System.out.println("--- Administrador ---");
        super.exibirDados();
    }
}
