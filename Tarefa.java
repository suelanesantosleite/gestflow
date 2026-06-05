// Classe que representa uma tarefa dentro de um projeto
public class Tarefa {
    private String descricao;
    private String status; // pendente, em andamento, concluída
    private String responsavel;
    private String dataInicio;
    private String dataFim;

    public Tarefa(String descricao, String responsavel, String dataInicio, String dataFim) {
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = "pendente";
    }

    // Getters e Setters
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }

    public String getDataInicio() { return dataInicio; }
    public void setDataInicio(String dataInicio) { this.dataInicio = dataInicio; }

    public String getDataFim() { return dataFim; }
    public void setDataFim(String dataFim) { this.dataFim = dataFim; }

    public void exibirDados() {
        System.out.println("Tarefa: " + descricao);
        System.out.println("Responsável: " + responsavel);
        System.out.println("Início: " + dataInicio + " | Fim: " + dataFim);
        System.out.println("Status: " + status);
    }

    @Override
    public String toString() {
        return descricao + " [" + status + "]";
    }
}
