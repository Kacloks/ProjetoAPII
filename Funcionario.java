public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, int idade, TipoDocumento tipoDocumento, String cargo) throws IdadeInvalidaException {
        super(nome, idade, tipoDocumento);
        this.cargo = cargo;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Cargo: " + cargo);
        System.out.println("Tipo de Documento: " + getTipoDocumento());
    }

    @Override
    public String getTipoPessoa() {
        return "Funcionario";
    }
}
