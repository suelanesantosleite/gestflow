// Colaborador herda de Usuario e executa as tarefas do projeto
public class Colaborador extends Usuario {

    public Colaborador(String nomeCompleto, String cpf, String email, String cargo, String login, String senha) {
        super(nomeCompleto, cpf, email, cargo, login, senha, "colaborador");
    }

    // Ação específica do colaborador
    public void executarTarefa(Tarefa tarefa) {
        System.out.println("Colaborador " + getNomeCompleto() + " executando tarefa: " + tarefa.getDescricao());
        tarefa.setStatus("em andamento");
    }

    @Override
    public void exibirDados() {
        System.out.println("--- Colaborador ---");
        super.exibirDados();
    }
}
