


public class Cliente {

	private static final double MENSALIDADE = 50.0;
	//private static final Calendar nextMonthFirst = (Calendar)date.clone();

	private String nome;
	private String tipo;
	private ITipoVeiculo veiculo;
	private Categoria categoria;
	//private LocalDateTime dt;

	/**
	 * Construtor.
	 */
	public Cliente(String nome, String tipo, ITipoVeiculo veiculo) {

		this.nome = nome;
		this.tipo = tipo;
		this.categoria = Categoria.valueOf(tipo);
		this.veiculo = veiculo;

	}

	/**
	 * @return categoria
	 */
	public Categoria getCategoria(){
		return this.categoria;
	}

	/**
	 * Verificar se está na hora de pagar ou se já passou a data da mensalidade.
	 * @return true ou false
	 */
	public boolean mensalidade(){

		Tempos tempo = new Tempos();

		boolean valor = false;	

		if(tempo.ehAntes()){// se o hoje for igual ou depois do ultimo dia do m�s
 			valor = true;						// retorna true
		}
		return valor;
	}

	/**
	 * @return mensalidade
	 */
	public double getMensalidade(){
		return MENSALIDADE;
	}
	/**
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @return veiculo
	 */
	public ITipoVeiculo getVeiculo() {
		return veiculo;
	}

}
