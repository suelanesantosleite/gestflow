import java.util.ArrayList;
import java.util.List;

// Classe que representa uma equipe de trabalho
public class Equipe {
    private String nome;
    private String descricao;
    private List<Usuario> membros;

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Usuario> getMembros() { return membros; }

    // Adiciona um membro à equipe
    public void adicionarMembro(Usuario usuario) {
        membros.add(usuario);
        System.out.println(usuario.getNomeCompleto() + " adicionado(a) à equipe " + nome);
    }

    // Remove um membro da equipe
    public void removerMembro(Usuario usuario) {
        membros.remove(usuario);
        System.out.println(usuario.getNomeCompleto() + " removido(a) da equipe " + nome);
    }

    public void exibirDados() {
        System.out.println("Equipe: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Membros:");
        for (Usuario u : membros) {
            System.out.println("  - " + u.toString());
        }
    }

    @Override
    public String toString() {
        return nome + " (" + membros.size() + " membros)";
    }
}
