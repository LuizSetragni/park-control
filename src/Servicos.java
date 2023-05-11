
public enum Servicos {

	MANOBRISTA("Manobrista", 3.0),
	LAVAGEM("Lavagem", 7.0),
	COBERTURA("Cobertura", 5.0);


	private double preco;

	/**
	 * @return pre�o dos servi�os
	 */
	public double getValor(){ return preco;}

	private String nome;
	Servicos(String nome, double preco) {

		this.nome = nome;
		this.preco = preco;

	}

	/**
	 * @return nome
	 */
	@Override
	public String toString(){
		return nome;
	}
}
