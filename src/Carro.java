
public class Carro implements ITipoVeiculo {

	private static final int TAMANHO_CARRO = 2;
	private static final double VALOR_HORA = 7.0;
	/**
	 * @return Tamanho do carro (2 por padr�o)
	 */
	public Integer tamanho(){		
		return TAMANHO_CARRO;
	}

	/**
	 * @return Pre�o da moto (7 por padr�o )
	 */
	@Override
	public double preco() {
		return VALOR_HORA;
	}
}
