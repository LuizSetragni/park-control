
public class VeiculoGrande implements ITipoVeiculo {

	private static final int TAMANHO_VEICULO = 3;
	private static final double VALOR_HORA = 12.0;
	/**
	 * @return Tamanho do veï¿½culo grande (3 por padrï¿½o)
	 */
	public Integer tamanho() {
		return TAMANHO_VEICULO;
	}

	/**
	 * @return Preço da moto (12 por padrï¿½o )
	 */
	@Override
	public double preco() {
		return VALOR_HORA;
	}
}
