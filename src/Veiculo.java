@SuppressWarnings("unused")
public class Veiculo {

	private static final Integer T_PEQUENA = 1;
	private static final Integer T_NORMAl = 2;
	private static final Integer T_GRANDE = 3;

	private Integer tamanho;
	private double preco;
	private int id;
	private Estacionamento estacionamento;
	private Tempos tempo;
	private Cliente cliente;
	private String placa;


	/**
	 * Construtor. Devolve um cliente com 0 pedidos e categoria de fidelidade
	 * @param tipo Moto / Carro / Veiculo Grande
	 * @param id Placa do Ve�culo
	 */
	public Veiculo(ITipoVeiculo tipo, int id, String tempo, Cliente cliente/*, String placa*/) {
		this.tamanho = tipo.tamanho();
		this.id = id;
		this.preco = tipo.preco();
		this.tempo = new Tempos(tempo);
		this.cliente = cliente;
		//this.placa = placa;
		this.estacionamento = Estacionamento.get();
	}

	/**
	 * Encontra a vaga de acordo com o tamanho do ve�culo
	 * @return vaga certa
	 */
	private Vaga encontraVaga() {

		Vaga vaga;

		if(this.tamanho.equals(T_PEQUENA))
		{
			vaga = estacionamento.getVagaPequena().remove(0);
		}
		else if(this.tamanho.equals(T_NORMAl) || this.tamanho.equals(T_PEQUENA))
		{
			vaga = estacionamento.getVagaNormal().remove(0);
		}
		else if(this.tamanho.equals(T_GRANDE) || this.tamanho.equals(T_NORMAl) || this.tamanho.equals(T_PEQUENA))
		{
			vaga = estacionamento.getVagaGrande().remove(0);
		}
		else vaga = null;

		return vaga;
	}

	/**
	 * Estaciona o veiculo de acordo com seu tamanho e ocupa a vaga.
	 */
	public void estacionar() {
		Vaga vaga = encontraVaga();
		if (vaga != null && vaga.vagaLivre()) {
			this.estacionamento.vagaOcupada.put(this.id, vaga);//"vagaOcupada" coloca o id do carro na vaga.
			vaga.ocupar(this);//"ocupar()" define a vaga como ocupada.
		}
	}

	/**
	 * Valor a pagar de acordo com o tipo de motorista:
	 * Horista multiplica o valor do tempo com o valor do carro.
	 * Mensalista não paga por hora, mas se for a data de pagar
	 * a mensalidade ou ja passou desta data ele paga (valor fixo de R$30,00).
	 * @return valor
	 */
	public double pagar(){
		double valor = 0;
		if(!Categoria.ehHorista(this.cliente.getCategoria())){ // se for cliente horista paga � hora
			valor = getPreco();
		}	
		else if(Categoria.ehHorista(this.cliente.getCategoria())){// se for mensalista:

			if(this.cliente.mensalidade()) this.cliente.getMensalidade();// n�o paga se n�o for a data de pagar a mensalidade.
			else valor = 0;// paga se n�o for a data de pagar a mensalidade.
		}

		return valor;
	}

	/**
	 * @return hora
	 */
	public int getTempo(){
		return this.tempo.getHora();
	}

	/**
	 * @return preco de acordo com o tempo que o ve�culo estava estacionado
	 */
	public double getPreco() {

		return this.preco * getTempo();

	}

	/**
	 * Liberar a vaga.
	 */
	public void sair() {
		Vaga vaga = estacionamento.vagaOcupada.remove(this.id);//Remove o ve�culo da vaga.
		vaga.liberar();//a vaga n�o possui mais ve�culo estacionado e coloca-a dispon�vel.

		if(this.tamanho.equals(T_PEQUENA))
		{
			this.estacionamento.getVagaPequena().add(vaga);//aumenta as vagas pequenas disponiveis
		}
		else if(this.tamanho.equals(T_NORMAl) || this.tamanho.equals(T_PEQUENA))
		{
			this.estacionamento.getVagaNormal().add(vaga);//aumenta as vagas normais disponiveis
		}
		else if(this.tamanho.equals(T_GRANDE) || this.tamanho.equals(T_NORMAl) || this.tamanho.equals(T_PEQUENA))
		{
			this.estacionamento.getVagaGrande().add(vaga);//aumenta as vagas grandes disponiveis
		}

	}
}
