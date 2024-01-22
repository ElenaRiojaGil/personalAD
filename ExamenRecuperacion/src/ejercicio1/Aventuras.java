package ejercicio1;

public class Aventuras {
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	private String correo;
	private boolean vip;
	private String nacionalidad;
	
	public Aventuras() {
		super();
	}
	
	public Aventuras(String nombre, String apellidos, String telefono, String direccion, String correo, boolean vip,
			String nacionalidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.vip = vip;
		this.nacionalidad = nacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return "Aventuras [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", direccion="
				+ direccion + ", correo=" + correo + ", vip=" + vip + ", nacionalidad=" + nacionalidad + "]";
	}
}
