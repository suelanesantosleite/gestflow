import java.util.ArrayList;
import java.util.List;

// Classe que representa um projeto da empresa
public class Projeto {
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataTerminoPrevista;
    private String status; // planejado, em andamento, concluído, cancelado
    private Gerente gerenteResponsavel;
    private List<Tarefa> tarefas;
    private List<Equipe> equipes;

    public Projeto(String nome, String descricao, String dataInicio, String dataTerminoPrevista, Gerente gerenteResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.gerenteResponsavel = gerenteResponsavel;
        this.status = "planejado";
        this.tarefas = new ArrayList<>();
        this.equipes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }

    public String getDataTerminoPrevista() { return dataTerminoPrevista; }
    public void setDataTerminoPrevista(String dataTerminoPrevista) { this.dataTerminoPrevista = dataTerminoPrevista; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Gerente getGerenteResponsavel() { return gerenteResponsavel; }
    public void setGerenteResponsavel(Gerente gerenteResponsavel) { this.gerenteResponsavel = gerenteResponsavel; }

    public List<Tarefa> getTarefas() { return tarefas; }
    public List<Equipe> getEquipes() { return equipes; }

    // Adiciona uma tarefa ao projeto
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa '" + tarefa.getDescricao() + "' adicionada ao projeto " + nome);
    }

    // Aloca uma equipe no projeto
    public void alocarEquipe(Equipe equipe) {
        equipes.add(equipe);
        System.out.println("Equipe '" + equipe.getNome() + "' alocada ao projeto " + nome);
    }

    // Gera um relatório simples do projeto
    public void gerarRelatorio() {
        System.out.println("\n===== RELATÓRIO DO PROJETO =====");
        System.out.println("Projeto: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Gerente: " + gerenteResponsavel.getNomeCompleto());
        System.out.println("Início: " + dataInicio + " | Término previsto: " + dataTerminoPrevista);
        System.out.println("Status: " + status);

        System.out.println("\nEquipes alocadas:");
        if (equipes.isEmpty()) {
            System.out.println("  Nenhuma equipe alocada.");
        } else {
            for (Equipe e : equipes) {
                System.out.println("  - " + e.toString());
            }
        }

        System.out.println("\nTarefas:");
        if (tarefas.isEmpty()) {
            System.out.println("  Nenhuma tarefa cadastrada.");
        } else {
            for (Tarefa t : tarefas) {
                System.out.println("  - " + t.toString());
            }
        }
        System.out.println("================================\n");
    }

    public void exibirDados() {
        System.out.println("Projeto: " + nome);
        System.out.println("Status: " + status);
        System.out.println("Gerente: " + gerenteResponsavel.getNomeCompleto());
        System.out.println("Início: " + dataInicio + " | Término: " + dataTerminoPrevista);
    }

    @Override
    public String toString() {
        return nome + " [" + status + "]";
    }
}
