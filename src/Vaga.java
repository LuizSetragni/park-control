@SuppressWarnings("unused")
public abstract class Vaga {

	//	private int id;
	private final int tamanho;
	private boolean disponivel;
	private Veiculo veiculo;
	private final TipoDeVaga tipo;

	/**Construtor que cria as vagas de acordo com o tipo e tamanho */
	public Vaga(TipoDeVaga tipo, int tamanho) {

		this.tamanho = tamanho;
		this.tipo = tipo;

	}

	/**
	 * Checar se a vaga está livre
	 */
	public boolean vagaLivre() {
		return veiculo == null;
	}

	/**
	 * Ocupar vaga
	 * Aloca o ve�culo e deixa a vaga indispon�vel 
	 */
	public boolean ocupar(Veiculo veiculo) {
		this.veiculo = veiculo;
		return this.disponivel = false;
	}

	/**
	 * Liberara vaga
	 * Tira o ve�culo e deixa a vaga dispon�vel 
	 */
	public boolean liberar() {
		this.veiculo = null;
		return this.disponivel = true;
	}

	//	public int getId() {
	//		return this.id;
	//	}

	public int getTamanho() {
		return this.tamanho;
	}
}
