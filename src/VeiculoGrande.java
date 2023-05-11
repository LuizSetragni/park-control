
public class VeiculoGrande implements ITipoVeiculo {

	private static final int TAMANHO_VEICULO = 3;
	private static final double VALOR_HORA = 12.0;
	/**
	 * @return Tamanho do ve�culo grande (3 por padr�o)
	 */
	public Integer tamanho() {
		return TAMANHO_VEICULO;
	}

	/**
	 * @return Pre�o da moto (12 por padr�o )
	 */
	@Override
	public double preco() {
		return VALOR_HORA;
	}
}
