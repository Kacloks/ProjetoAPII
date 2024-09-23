import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Pessoa (Funcionário ou Cliente)");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Remover Pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPessoa(listaPessoas, scanner);
                    break;
                case 2:
                    listarPessoas(listaPessoas);
                    break;
                case 3:
                    atualizarPessoa(listaPessoas, scanner);
                    break;
                case 4:
                    removerPessoa(listaPessoas, scanner);
                    break;
                case 5:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void adicionarPessoa(List<Pessoa> listaPessoas, Scanner scanner) {
        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o tipo de documento (CPF, RG, PASSAPORTE, CNH): ");
            String tipoDocStr = scanner.nextLine();
            TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocStr.toUpperCase());

            System.out.print("É um funcionário ou cliente? (f/c): ");
            String tipoPessoa = scanner.nextLine();

            if (tipoPessoa.equalsIgnoreCase("f")) {
                System.out.print("Digite o cargo: ");
                String cargo = scanner.nextLine();
                Funcionario funcionario = new Funcionario(nome, idade, tipoDocumento, cargo);
                listaPessoas.add(funcionario);
                System.out.println("Funcionário adicionado com sucesso!");
            } else if (tipoPessoa.equalsIgnoreCase("c")) {
                System.out.print("Digite a preferência de produto: ");
                String preferenciaProduto = scanner.nextLine();
                Cliente cliente = new Cliente(nome, idade, tipoDocumento, preferenciaProduto);
                listaPessoas.add(cliente);
                System.out.println("Cliente adicionado com sucesso!");
            } else {
                System.out.println("Tipo de pessoa inválido.");
            }

        } catch (IdadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: Tipo de documento inválido.");
        }
    }

    private static void listarPessoas(List<Pessoa> listaPessoas) {
        if (listaPessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            for (Pessoa pessoa : listaPessoas) {
                pessoa.exibirInformacoes();
                System.out.println("-----------------");
            }
        }
    }

    private static void atualizarPessoa(List<Pessoa> listaPessoas, Scanner scanner) {
        System.out.print("Digite o nome da pessoa a ser atualizada: ");
        String nome = scanner.nextLine();
        Pessoa pessoaEncontrada = null;

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoaEncontrada = pessoa;
                break;
            }
        }

        if (pessoaEncontrada != null) {
            try {
                System.out.print("Digite a nova idade: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine(); 

                if (pessoaEncontrada instanceof Funcionario) {
                    Funcionario funcionario = (Funcionario) pessoaEncontrada;
                    System.out.print("Digite o novo cargo: ");
                    String novoCargo = scanner.nextLine();
                    funcionario = new Funcionario(funcionario.getNome(), novaIdade, funcionario.getTipoDocumento(), novoCargo);
                    listaPessoas.set(listaPessoas.indexOf(pessoaEncontrada), funcionario);
                    System.out.println("Funcionário atualizado com sucesso!");
                } else if (pessoaEncontrada instanceof Cliente) {
                    Cliente cliente = (Cliente) pessoaEncontrada;
                    System.out.print("Digite a nova preferência de produto: ");
                    String novaPreferencia = scanner.nextLine();
                    cliente = new Cliente(cliente.getNome(), novaIdade, cliente.getTipoDocumento(), novaPreferencia);
                    listaPessoas.set(listaPessoas.indexOf(pessoaEncontrada), cliente);
                    System.out.println("Cliente atualizado com sucesso!");
                }
            } catch (IdadeInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    private static void removerPessoa(List<Pessoa> listaPessoas, Scanner scanner) {
        System.out.print("Digite o nome da pessoa a ser removida: ");
        String nome = scanner.nextLine();
        Pessoa pessoaRemover = null;

        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                pessoaRemover = pessoa;
                break;
            }
        }

        if (pessoaRemover != null) {
            listaPessoas.remove(pessoaRemover);
            System.out.println("Pessoa removida com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
}
