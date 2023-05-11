
public class Moto implements ITipoVeiculo{

	private static final int TAMANHO_MOTO = 1;
	private static final double VALOR_HORA = 5.0;
	//private double preco;

	/**
	 * @return Tamanho da moto (1 por padrï¿½o )
	 */
	public Integer tamanho() {
		return TAMANHO_MOTO;
	}

	/**
	 * @return Preço da moto (5 por padrï¿½o )
	 */
	@Override
	public double preco() {
		return VALOR_HORA;
	}


}
