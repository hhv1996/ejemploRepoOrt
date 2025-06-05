package ej3;

public class Propiedad {
	private String domicilio;
	private double precio;
	private TipoProp tipoPropiedad;
	
	public Propiedad(String domicilio, double precio, TipoProp tipoPropiedad) {
		this.domicilio = domicilio;
		this.precio = precio;
		this.tipoPropiedad = tipoPropiedad;
	}
	
	
	public TipoProp getTipo() {
		return this.tipoPropiedad;
	}
	
	public String getDomicilio () {
		return this.domicilio;
	}
	
	public void mostrarPropiedad () {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Propiedad [domicilio=" + domicilio + ", precio=" + precio + "]";
	}
}
