package entidades;

public class ProdutoImportado extends Produto{

	private Double livreDeAlfandega;

	public ProdutoImportado(String nome, Double preco, Double livreDeAlfandega) {
		super(nome, preco);
		this.livreDeAlfandega = livreDeAlfandega;
	}

	public Double getLivreDeAlfandega() {
		return livreDeAlfandega;
	}

	public void setLivreDeAlfandega(Double livreDeAlfandega) {
		this.livreDeAlfandega = livreDeAlfandega;
	}
	
	
	public String etiquetaDePreco() {
		return getNome() + " $ " + String.format("%.2f", precoTotal()) + " (Livre de alfandega: $"
				+ String.format("%.2f", livreDeAlfandega) + ")";
	}
	
	public double precoTotal() {
		return getPreco() + livreDeAlfandega;
	}
}
