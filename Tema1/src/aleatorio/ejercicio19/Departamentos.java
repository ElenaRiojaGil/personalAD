package aleatorio.ejercicio19;

public class Departamentos {
	
	 public Departamentos() {
		 super();
	 }
	 
	public Departamentos(int numero, String nombre, String localidad) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.localidad = localidad;
	}
	private int numero;
	private String nombre; // 25 caracteres
	private String localidad; // 50 caracteres
	
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
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String toString() {
		return "Departamento [numero=" + numero + ", nombre=" + nombre + ", localidad=" + localidad + "]";
	}
	

}