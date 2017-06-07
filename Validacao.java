package projetovendas;

public class Validacao {
	
	private boolean isDadoInformadoNulo;
	
	public boolean isDadoInformadoNulo (String n){
		
		//if (n.trim().equals(""))
		if ("".equals(n.trim()))
			return this.isDadoInformadoNulo = true;
		else
			return this.isDadoInformadoNulo = false;
	}

	public boolean isDadoInformadoNulo() {
		return isDadoInformadoNulo;
	}

	public void setDadoInformadoNulo(boolean isDadoInformadoNulo) {
		this.isDadoInformadoNulo = isDadoInformadoNulo;
	}

}