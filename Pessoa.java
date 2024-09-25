public abstract class Pessoa {
    private String nome;
    private int idade;
    private TipoDocumento tipoDocumento;

    public Pessoa(String nome, int idade, TipoDocumento tipoDocumento) throws IdadeInvalidaException {
        if (idade < 0) {
            throw new IdadeInvalidaException("Idade não pode ser negativa.");
        }
        this.nome = nome;
        this.idade = idade;
        this.tipoDocumento = tipoDocumento;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public abstract void exibirInformacoes();
    public abstract String getTipoPessoa();
}
