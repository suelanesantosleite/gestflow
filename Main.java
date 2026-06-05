import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principal do sistema GestFlow
public class Main {

    static List<Usuario> usuarios = new ArrayList<>();
    static List<Projeto> projetos = new ArrayList<>();
    static List<Equipe> equipes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("  Bem-vindo ao GestFlow!");
        System.out.println("  Sistema de Gestão de Projetos");
        System.out.println("=================================\n");

        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> listarUsuarios();
                case 3 -> cadastrarProjeto();
                case 4 -> listarProjetos();
                case 5 -> cadastrarEquipe();
                case 6 -> listarEquipes();
                case 7 -> cadastrarTarefa();
                case 8 -> gerarRelatorio();
                case 0 -> System.out.println("\nSistema encerrado. Até logo!");
                default -> System.out.println("\nOpção inválida. Tente novamente.\n");
            }
        }
    }

    static void exibirMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Listar Usuários");
        System.out.println("3. Cadastrar Projeto");
        System.out.println("4. Listar Projetos");
        System.out.println("5. Cadastrar Equipe");
        System.out.println("6. Listar Equipes");
        System.out.println("7. Cadastrar Tarefa em Projeto");
        System.out.println("8. Gerar Relatório de Projeto");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void cadastrarUsuario() {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Perfil (1-Administrador / 2-Gerente / 3-Colaborador): ");
        String perfil = scanner.nextLine();

        Usuario usuario;
        switch (perfil) {
            case "1" -> usuario = new Administrador(nome, cpf, email, cargo, login, senha);
            case "2" -> usuario = new Gerente(nome, cpf, email, cargo, login, senha);
            default -> usuario = new Colaborador(nome, cpf, email, cargo, login, senha);
        }

        usuarios.add(usuario);
        System.out.println("\nUsuário cadastrado com sucesso!\n");
    }

    static void listarUsuarios() {
        System.out.println("\n--- LISTA DE USUÁRIOS ---");
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.\n");
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println((i + 1) + ". " + usuarios.get(i).toString());
            }
            System.out.println();
        }
    }

    static void cadastrarProjeto() {
        System.out.println("\n--- CADASTRO DE PROJETO ---");

        // Verifica se tem gerente disponível
        List<Gerente> gerentes = new ArrayList<>();
        for (Usuario u : usuarios) {
            if (u instanceof Gerente) gerentes.add((Gerente) u);
        }

        if (gerentes.isEmpty()) {
            System.out.println("Nenhum gerente cadastrado. Cadastre um gerente primeiro.\n");
            return;
        }

        System.out.print("Nome do projeto: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de início (dd/mm/aaaa): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de término prevista (dd/mm/aaaa): ");
        String dataFim = scanner.nextLine();

        System.out.println("Selecione o gerente responsável:");
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println((i + 1) + ". " + gerentes.get(i).getNomeCompleto());
        }
        int idx = 0;
        try {
            idx = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            idx = 0;
        }

        Gerente gerente = gerentes.get(Math.min(idx, gerentes.size() - 1));
        Projeto projeto = new Projeto(nome, descricao, dataInicio, dataFim, gerente);
        projetos.add(projeto);
        System.out.println("\nProjeto cadastrado com sucesso!\n");
    }

    static void listarProjetos() {
        System.out.println("\n--- LISTA DE PROJETOS ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.\n");
        } else {
            for (int i = 0; i < projetos.size(); i++) {
                System.out.println((i + 1) + ". " + projetos.get(i).toString());
            }
            System.out.println();
        }
    }

    static void cadastrarEquipe() {
        System.out.println("\n--- CADASTRO DE EQUIPE ---");
        System.out.print("Nome da equipe: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Equipe equipe = new Equipe(nome, descricao);

        if (!usuarios.isEmpty()) {
            System.out.println("Deseja adicionar membros? (s/n): ");
            String resp = scanner.nextLine();
            if (resp.equalsIgnoreCase("s")) {
                listarUsuarios();
                System.out.print("Digite o número do usuário para adicionar (0 para parar): ");
                String entrada = scanner.nextLine();
                while (!entrada.equals("0")) {
                    try {
                        int idx = Integer.parseInt(entrada) - 1;
                        if (idx >= 0 && idx < usuarios.size()) {
                            equipe.adicionarMembro(usuarios.get(idx));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    }
                    System.out.print("Próximo (0 para parar): ");
                    entrada = scanner.nextLine();
                }
            }
        }

        equipes.add(equipe);
        System.out.println("\nEquipe cadastrada com sucesso!\n");
    }

    static void listarEquipes() {
        System.out.println("\n--- LISTA DE EQUIPES ---");
        if (equipes.isEmpty()) {
            System.out.println("Nenhuma equipe cadastrada.\n");
        } else {
            for (int i = 0; i < equipes.size(); i++) {
                System.out.println((i + 1) + ". " + equipes.get(i).toString());
            }
            System.out.println();
        }
    }

    static void cadastrarTarefa() {
        System.out.println("\n--- CADASTRAR TAREFA EM PROJETO ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.\n");
            return;
        }

        listarProjetos();
        System.out.print("Selecione o projeto: ");
        int idx = 0;
        try {
            idx = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            idx = 0;
        }

        Projeto projeto = projetos.get(Math.min(idx, projetos.size() - 1));

        System.out.print("Descrição da tarefa: ");
        String descricao = scanner.nextLine();
        System.out.print("Responsável: ");
        String responsavel = scanner.nextLine();
        System.out.print("Data de início (dd/mm/aaaa): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Data de fim (dd/mm/aaaa): ");
        String dataFim = scanner.nextLine();

        Tarefa tarefa = new Tarefa(descricao, responsavel, dataInicio, dataFim);
        projeto.adicionarTarefa(tarefa);
        System.out.println("\nTarefa cadastrada com sucesso!\n");
    }

    static void gerarRelatorio() {
        System.out.println("\n--- GERAR RELATÓRIO ---");
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto cadastrado.\n");
            return;
        }

        listarProjetos();
        System.out.print("Selecione o projeto: ");
        int idx = 0;
        try {
            idx = Integer.parseInt(scanner.nextLine()) - 1;
        } catch (NumberFormatException e) {
            idx = 0;
        }

        projetos.get(Math.min(idx, projetos.size() - 1)).gerarRelatorio();
    }
}
