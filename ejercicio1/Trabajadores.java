package ejercicio1;

public class Trabajadores {
	
	 public Trabajadores() {
		 super();
	 }
	 
	public Trabajadores(int numero, String nombre,String salario, int sindicato) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.salario=salario;
		this.sindicato=sindicato;
	}
	private int numero;
	private String nombre; // 25 caracteres
	private String salario;
	private int sindicato;	
	
	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public int getSindicato() {
		return sindicato;
	}

	public void setSindicato(int sindicato) {
		this.sindicato = sindicato;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Trabajador [numero=" + numero + ", nombre=" + nombre + ", salario=" + salario + ",sindicato="+sindicato+"]";
	}

}
