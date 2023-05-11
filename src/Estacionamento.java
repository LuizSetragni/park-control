import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Estacionamento {

	private static Estacionamento estacionamento = null;

	/** Quantidade de vagas para cada tipo de ve�culo */
	private static final int NUMERO_DE_VAGAS_PEQUENAS = 10;
	private static final int NUMERO_DE_VAGAS_NORMAIS = 10;
	private static final int NUMERO_DE_VAGAS_GRANDES = 10;


	public Map<Integer, Vaga> vagaOcupada;
	private List<Vaga> vagaPequena;
	private List<Vaga> vagaNormal;
	private List<Vaga> vagaGrande;

	private Estacionamento() {
		vagaPequena = new LinkedList<>();
		vagaNormal = new LinkedList<>();
		vagaGrande = new LinkedList<>();
		vagaOcupada = new HashMap<>();
		/**Cria as vagas de moto */
		for (int i = 1; i <= NUMERO_DE_VAGAS_PEQUENAS; i++)
			vagaPequena.add(new VagaMoto());
		/**Cria as vagas de carro */
		for (int i = 1; i <= NUMERO_DE_VAGAS_NORMAIS; i++)
			vagaNormal.add(new VagaCarro());
		/**Cria as vagas de ve�culo grande */
		for (int i = 1; i <= NUMERO_DE_VAGAS_GRANDES; i++)
			vagaGrande.add(new VagaVeiculoGrande());

	}


	/**
	 * @return MANOBRISTA
	 */
	public double getManobrista(){
		return Servicos.MANOBRISTA.getValor();
	}

	/**
	 * @return LAVAGEM
	 */
	public double getLavagem(){
		return Servicos.LAVAGEM.getValor();
	}

	/**
	 * @return COBERTURA
	 */
	public double getCobertura(){
		return Servicos.COBERTURA.getValor();
	}

	/**
	 * @return vagas pequenas
	 */
	public List<Vaga> getVagaPequena() {
		return vagaPequena;
	}

	/**
	 * @return vagas normais
	 */
	public List<Vaga> getVagaNormal() {
		return vagaNormal;
	}

	/**
	 * @return vagas grandes
	 */
	public List<Vaga> getVagaGrande() {
		return vagaGrande;
	}

	/*Instancia a classe Estacionamento(temporario)*/
	public static Estacionamento get() {
		if (estacionamento == null)
			estacionamento = new Estacionamento();
		return estacionamento;
	}
}
