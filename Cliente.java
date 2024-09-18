public class Cliente extends Pessoa {
    private String preferenciaProduto;

    public Cliente(String nome, int idade, TipoDocumento tipoDocumento, String preferenciaProduto) {
        super(nome, idade, tipoDocumento);
        this.preferenciaProduto = preferenciaProduto;
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
}
