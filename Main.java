public class Main {
    public static void main(String[] args) {
        try {
            Funcionario funcionario = new Funcionario("João", 30, TipoDocumento.CPF, "Gerente");
            Cliente cliente = new Cliente("Maria", 25, TipoDocumento.rg, "Eletrônicos");

       
            System.out.println("Informações do Funcionário:");
            funcionario.exibirInformacoes();

            System.out.println("\nInformações do Cliente:");
            cliente.exibirInformacoes();

            Cliente clienteInvalido = new Cliente("Carlos", -5, TipoDocumento.RG, "Roupas");
        } catch (IdadeInvalida e) {
            systen.out.println("Erro:" + e.getMessage());
        }
    }
}
