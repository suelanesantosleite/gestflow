// Gerente herda de Usuario e é responsável por projetos
public class Gerente extends Usuario {

    public Gerente(String nomeCompleto, String cpf, String email, String cargo, String login, String senha) {
        super(nomeCompleto, cpf, email, cargo, login, senha, "gerente");
    }

    // Ação específica do gerente
    public void acompanharProjeto(Projeto projeto) {
        System.out.println("Gerente " + getNomeCompleto() + " acompanhando projeto: " + projeto.getNome());
    }

    @Override
    public void exibirDados() {
        System.out.println("--- Gerente ---");
        super.exibirDados();
    }
}
