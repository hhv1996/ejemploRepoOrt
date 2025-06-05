package ej3;

import java.util.ArrayList;

public class Barrio {
	private String nombre;
	private ArrayList<Propiedad> propiedades;
	
	public Barrio(String nombre) {
		this.nombre = nombre;
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	
	public void agregarPropiedad (Propiedad propiedad) {
		this.propiedades.add(propiedad);
	}
	
	public void mostrarPropiedades (TipoProp tipoPropiedad) {
		for (Propiedad unaPropiedad : this.propiedades) {
			if (tipoPropiedad == unaPropiedad.getTipo()) {
				unaPropiedad.mostrarPropiedad();
			}
		}
	}

	
	public void mostrarPropiedades () {
		System.out.println("------------------------------" + this.toString() + "------------------------------");
		for (Propiedad unaPropiedad : this.propiedades) {
			unaPropiedad.mostrarPropiedad();
		}
	}
	
	public int cantPropiedades () {
		return this.propiedades.size();
	}


	@Override
	public String toString() {
		return "Barrio [nombre=" + nombre + "]";
	}
	
	public Propiedad buscarPropiedad(String domicilio) {
		int indice = 0;
		Propiedad propiedadEvaluada = null;
		Propiedad propiedadEncontrada = null;
		
		
		while (propiedadEncontrada == null && indice < cantPropiedades()) {
			propiedadEvaluada = this.propiedades.get(indice);
			if(propiedadEvaluada.getDomicilio().equals(domicilio)) {
				propiedadEncontrada = propiedadEvaluada;
			}
		}
		return propiedadEncontrada;
	}
	
	public Propiedad borrarPropiedad (String domicilio) {
		Propiedad propiedadEncontrada = buscarPropiedad(domicilio);
		
		if (propiedadEncontrada != null) {
			this.propiedades.remove(propiedadEncontrada);
		}
		
		return propiedadEncontrada;
	}
	
}
