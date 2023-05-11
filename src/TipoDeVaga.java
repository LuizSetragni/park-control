
public enum TipoDeVaga {

	PEQUENA("Pequena", 1),
	NORMAL("Normal", 2),
	GRANDE("Grande", 3);

	private String nome;
	private int tamanho; 

	/**
	 * Tamanho das vagas
	 * @return tamanho
	 */
	public int tamanho() { return tamanho; }

	TipoDeVaga(String nome, int tamanho) {

		this.nome = nome;
		this.tamanho = tamanho;

	}

	/**
	 * @return nome
	 */
	@Override
	public String toString(){
		return nome;
	}
}
