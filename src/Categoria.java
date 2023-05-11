public enum Categoria {
	MENSALISTA("MENSALISTA"),
	HORISTA("HORISTA");

	private String nome;	

	Categoria(String string) {

		this.nome = string;

	}

	/**
	 * Verifica se a categoria do cliente é horista
	 * @return true ou false
	 */
	public static boolean ehHorista(Categoria categoria) {

		boolean c = false;

		if(categoria == MENSALISTA) c = true;
		else c = false;

		return c;	
	}

	/**
	 * @return nome
	 */
	@Override
	public String toString(){
		return nome;
	}
}
