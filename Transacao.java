
public class Transacao {

	private String tipo;
	private int qtde;
	private double precoUnitario;

	public Transacao(String tipo, int qtde, double precoUnitario) {
		this.tipo = tipo;
		this.qtde = qtde;
		this.precoUnitario = precoUnitario;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public String toCommaText() {
		return tipo + ";" + qtde + ";" + precoUnitario;
	}

}
