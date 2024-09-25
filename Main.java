/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("Deseja adicionar uma pessoa? (s/n)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
                break;
            }

            try {
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();

                System.out.print("Digite a idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consumir o newline

                System.out.print("Digite o tipo de documento (CPF, RG, CNH): ");
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
                System.out.println("Tipo de documento inválido.");
            }

            System.out.println();
        }

        // Exibir informações de todas as pessoas
        System.out.println("\nLista de Pessoas:");
        for (Pessoa pessoa : listaPessoas) {
            pessoa.exibirInformacoes();
            System.out.println();
        }

        scanner.close();
    }
}*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir o newline

            System.out.print("Digite o tipo de documento (CPF, RG, CNH): ");
            String tipoDocStr = scanner.nextLine();
            TipoDocumento tipoDocumento = TipoDocumento.valueOf(tipoDocStr.toUpperCase());

            System.out.print("É um funcionário ou cliente? (f/c): ");
            String tipoPessoa = scanner.nextLine();

            Pessoa pessoa = null;
            if (tipoPessoa.equalsIgnoreCase("f")) {
                System.out.print("Digite o cargo: ");
                String cargo = scanner.nextLine();
                pessoa = new Funcionario(nome, idade, tipoDocumento, cargo);
                System.out.println("Funcionário adicionado com sucesso!");
            } else if (tipoPessoa.equalsIgnoreCase("c")) {
                System.out.print("Digite a preferência de produto: ");
                String preferenciaProduto = scanner.nextLine();
                pessoa = new Cliente(nome, idade, tipoDocumento, preferenciaProduto);
                System.out.println("Cliente adicionado com sucesso!");
            } else {
                System.out.println("Tipo de pessoa inválido.");
                return; // Encerra o programa se o tipo for inválido
            }

            // Exibe as informações da pessoa criada
            System.out.println("\nInformações da Pessoa:");
            pessoa.exibirInformacoes();
        } catch (IdadeInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de documento inválido.");
        }

        scanner.close();
    }
}

