import java.util.InputMismatchException;
import java.util.Scanner;
import javax.management.InvalidAttributeValueException;



@SuppressWarnings("unused")

public class APP {

	public static void limparTela(){
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}
	public static int menu(Scanner teclado) throws IllegalStateException{
		//limparTela();
		System.out.println("MENU");
		System.out.println("==========================");
		System.out.println("1 - Cadastro");
		System.out.println("2 - Extrato");
		System.out.println("0 - Sair");

		int opcao = -1;

		try{
			opcao  = teclado.nextInt();
			teclado.nextLine();
		}catch(InputMismatchException ex){
			System.out.println("Por favor, digite somente os números do menu.");
			teclado.nextLine();  
		}

		return opcao;
	}

	/**
	 * Pausa para leitura de mensagens em console
	 * @param teclado Scanner de leitura
	 */
	static void pausa(Scanner teclado){
		System.out.println("Enter para continuar.");
		teclado.nextLine();
	}

	public static void main(String[] args) {
		limparTela();

		Estacionamento estacionamento = Estacionamento.get();
		Tempos tempo;
		int placa = 0;
		String nome = "";
		String tipo = "";
		String aux = "";
		String temp = "";
		int veiculo;
		int manobrist = 0;
		int lavaJ = 0;
		int cobert = 0;
		Servicos[] lista = Servicos.values();
		double valorTotal = 0;

		Scanner teclado = new Scanner(System.in);
		int opcao = -1;

		do{
			opcao = menu(teclado);
			//limparTela();

			switch(opcao){
			case 1: {
				System.out.println("CADASTRO");
				System.out.println("==========================");
				System.out.println("Nome: ");
				nome = teclado.nextLine();
				System.out.println("Plano: (MENSALISTA/HORISTA)");
				tipo = teclado.nextLine();
				tipo.toUpperCase();
				System.out.println("Veículo: ");	
				veiculo = teclado.nextInt();
				System.out.println("Placa: ");
				placa = teclado.nextInt();
				System.out.println("Previsão Permanencia: (hh:mm): ");
				temp = teclado.nextLine();
				
				temp = teclado.nextLine();
				System.out.println("\nManobrista? (1-SIM || 2-NÃO): ");
				manobrist = teclado.nextInt();
				System.out.println("Lava-Jato? (1-SIM || 2-NÃO): ");
				lavaJ = teclado.nextInt();
				System.out.println("Cobertura? (1-SIM || 2-NÃO): ");
				cobert = teclado.nextInt();


				switch(veiculo){
				case 1:{
					ITipoVeiculo veiculo1 = new Carro();
					Cliente meuCliente = new Cliente(nome, tipo, veiculo1);
					Veiculo carro1 = new Veiculo(veiculo1, placa, temp, meuCliente);
					carro1.estacionar();
					valorTotal = carro1.pagar();
					break;
				}
				case 2:{
					ITipoVeiculo veiculo1 = new Moto();
					Cliente meuCliente = new Cliente(nome, tipo, veiculo1);
					Veiculo moto1 = new Veiculo(veiculo1, placa, temp, meuCliente);
					moto1.estacionar();
					valorTotal = moto1.pagar();
					break;
				}
				case 3:{
					ITipoVeiculo veiculo1 = new VeiculoGrande();
					Cliente meuCliente = new Cliente(nome, tipo, veiculo1);
					Veiculo veiculoGrande1 = new Veiculo(veiculo1, placa, temp, meuCliente);
					veiculoGrande1.estacionar();
					valorTotal = veiculoGrande1.pagar();
					break;
				}
				default:{
					System.out.println("Veículo não encontrado!");
				}
				}
				break;
			}
			case 2:{
				System.out.println("EXTRATO");
				System.out.println("==========================");

				System.out.println("EXTRATO CLIENTE");
					System.out.println("Nome: " + nome);
					System.out.println("Plano: " + tipo);
					System.out.println("Placa: " + placa);
					System.out.println("Tempo: " + temp);

					if(manobrist == 1 || lavaJ == 1 || cobert == 1 && !tipo.equals("MENSALISTA")){
					System.out.println("Serviços Adicionais: ");
					}
					if(manobrist == 1 && tipo.equals("HORISTA")){
						System.out.println("Manobrista: R$ " + Servicos.MANOBRISTA.getValor());
						valorTotal += estacionamento.getManobrista();
					}
					else if(lavaJ == 1 && tipo.equals("HORISTA")){ 
						System.out.println("Lava-Jato: R$ " + Servicos.LAVAGEM.getValor());
						valorTotal += estacionamento.getLavagem();
					}
					else if(cobert == 1 && tipo.equals("HORISTA")){
						System.out.println("Cobertura: R$ " + Servicos.COBERTURA.getValor());
						valorTotal += estacionamento.getCobertura();
						
					}
					System.out.println("\n"); 					

					System.out.println("Valor: R$ " + (valorTotal));
					

				break;
			}
			}
		}while(opcao!=0);
	}
}
