package beans;

public class ProdutoBean {

	//Atributos
	private int idEstoque, idCentroAtendimento, validadeItem, quantidadeItem;
	private String nomeItem, descricaoItem;
	private double valorItem;
	
	// Set e Get
	public int getIdEstoque() {
		return idEstoque;
	}
	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}
	public int getIdCentroAtendimento() {
		return idCentroAtendimento;
	}
	public void setIdCentroAtendimento(int idCentroAtendimento) {
		this.idCentroAtendimento = idCentroAtendimento;
	}
	public String getNomeItem() {
		return nomeItem;
	}
	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	public int getValidadeItem() {
		return validadeItem;
	}
	public void setValidadeItem(int validadeItem) {
		this.validadeItem = validadeItem;
	}
	public int getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	public double getValorItem() {
		return valorItem;
	}
	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}
	
}
