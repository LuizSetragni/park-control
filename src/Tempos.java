
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Tempos {

	String[] horasEmin;
	private int hora;
	private int minuto;
	private int tempoMin;

	
	public Tempos(){       

		//Construtor vazio
		
	}

	/**
	 * Construtor. Passa a string para int. 
	 * (sendo assim, para efetuar o calculo do horista)
	 */
	public Tempos(String h){       
		this.horasEmin = h.split(":");
		this.hora = Integer.parseInt(this.horasEmin[0]);// grava a hora
		this.minuto = Integer.parseInt(this.horasEmin[1]);// grava o minuto
		this.tempoMin = (this.hora*60) + this.minuto;// transforma a hora em minutos
	}

	/**
	 * @return minutos
	 */
	public int getTempoMin(){
		return this.tempoMin;
	}
	/**
	 * @return horas
	 */
	public int getHora(){
		return this.hora;
	}

 	/**
	 * Verifica se a data atual � igual do ultimo dia do m�s.
	 * @return true ou false
	 */
	public boolean isEqual(){

		boolean valor = false;	

		if(now().isEqual(finalDoMes())){
			valor = true;
		}

		return valor; 
	}

	/**
	 * Verifica se a data atual � antes do ultimo dia do m�s.
	 * @return true ou false
	 */
	public boolean isAfter(){

		boolean valor = false;	

		if(now().isAfter(finalDoMes())){
			valor = true;
		}

		return valor; 

	}

	/**
	 * Verifica a data do ultimo dia do m�s.
	 * @return data
	 */
	public LocalDateTime finalDoMes(){

		LocalDateTime dt = LocalDateTime.of(now().getYear(), now().getMonth().getValue(), 
				ultimoDia(), now().getHour(), now().getMinute());

		return dt;
	}

	/**
	 * Verifica o ultimo dia do m�s atual.
	 * @return dia
	 */
	public int ultimoDia() {

		YearMonth mes = YearMonth.of(LocalDateTime.now().getYear(), LocalDateTime.now().getDayOfMonth());
		LocalDate d = mes.atEndOfMonth();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd");
		String f = d.format(formatador);
		int dia = Integer.parseInt(f);

		return dia;
	}

	public boolean ehAntes(){

		boolean valor = false;	

		LocalDateTime dt1
		= LocalDateTime.parse("2021-12-18T12:45:30");


	// Parses the date
	LocalDateTime dt2
		= LocalDateTime.parse("2016-12-04T12:45:30");

		if(dt1.isAfter(dt2)){
			valor = true;
		}

		return valor; 

	}


	/**
	 * @return a hora atual
	 */
	public LocalDateTime now(){

		LocalDateTime now = LocalDateTime.now(); 

		return now;
	}
}
