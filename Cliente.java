public class Cliente extends Pessoa {
    private String preferenciaProduto;

    public Cliente(String nome, int idade, TipoDocumento tipoDocumento, String preferenciaProduto) throws IdadeInvalidaException{
        super(nome, idade, tipoDocumento);
        this.preferenciaProduto = preferenciaProduto;
    }

    public Cliente(String nome, int idade, TipoDocumento tipoDocumento) throws IdadeInvalidaException {
        super(nome, idade, tipoDocumento);
        this.preferenciaProduto = "Preferência não informada";
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Preferência de Produto: " + preferenciaProduto);
        System.out.println("Tipo de Documento: " + getTipoDocumento());
    }

    @Override
    public String getTipoPessoa() {
        return "Cliente";
    }

    private static class IdadeInvalida extends Exception {

        public IdadeInvalida() {
        }
    }
}
