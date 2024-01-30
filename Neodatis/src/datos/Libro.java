package datos;

import java.util.List;
import java.util.Objects;

public class Libro {
	 private String titulo;
	 private int agno;
	 private String editorial;
	 private int paginas;
	 private List<Autor>autores;
	 
	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(String titulo, int agno, String editorial, int paginas, List<Autor> autores) {
		super();
		this.titulo = titulo;
		this.agno = agno;
		this.editorial = editorial;
		this.paginas = paginas;
		this.autores = autores;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAgno() {
		return agno;
	}
	public void setAgno(int año) {
		this.agno = año;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autores, agno, editorial, paginas, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(autores, other.autores) && agno == other.agno && Objects.equals(editorial, other.editorial)
				&& paginas == other.paginas && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", año=" + agno + ", editorial=" + editorial + ", paginas=" + paginas
				+ ", autores=" + autores + "]";
	}
	
	
	
}
