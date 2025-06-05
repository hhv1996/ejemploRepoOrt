package ej3;

import java.util.ArrayList;

public class Inmobiliaria {
	private ArrayList<Barrio> barrios;
	
	
	
	public Inmobiliaria() {
		this.barrios = new ArrayList<Barrio>();
	}

	public void mostrarPropiedades() {
		for (Barrio barrio : barrios) {
			barrio.mostrarPropiedades();
		}
	}
	
	public ArrayList<Barrio> obtenerBarrioMaxProp() {
		ArrayList <Barrio> barriosMaxProp = new ArrayList<Barrio>();
		int cantPropiedades = 0;
		int cantMaxima = Integer.MIN_VALUE;
		
		for (Barrio barrio : barrios) {
			cantPropiedades = barrio.cantPropiedades();
			if (cantPropiedades >= cantMaxima) {
				if (cantPropiedades > cantMaxima) {
					cantMaxima = cantPropiedades;
					barriosMaxProp.clear();
					barriosMaxProp.add(barrio);
				}else {
					barriosMaxProp.add(barrio);
				}
			}
		}
		
		return barriosMaxProp;
		
	}
	
	public Propiedad borrarPropiedad (String domicilio) {
		Propiedad propiedadBorrada = null;
		Barrio barrio = null;
		int indice = 0;
		
		while (propiedadBorrada  == null && indice < this.barrios.size()) {
			barrio = this.barrios.get(indice);
			propiedadBorrada = barrio.borrarPropiedad(domicilio);
			indice++;
		}
		
		return propiedadBorrada;
	}
	
	public void cambiarPropiedadDeBarrio (String domicilio, Barrio barrioNuevo) {
		Barrio barrioEncontrado = buscarBarrio(domicilio);
		Propiedad propiedadCambiar = null;
		if (barrioEncontrado != null) {
			propiedadCambiar = barrioEncontrado.borrarPropiedad(domicilio);
			barrioNuevo.agregarPropiedad(propiedadCambiar);
		}
	}
	
	public Barrio buscarBarrio(String domicilio) {
		int indice = 0;
		Barrio barrioEvaluado = null;
		Barrio barrioEncontrado = null;
		
		
		while (barrioEncontrado == null && indice < barrios.size()) {
			barrioEvaluado = this.barrios.get(indice);
			if(barrioEvaluado.buscarPropiedad(domicilio) != null) {
				barrioEncontrado = barrioEvaluado;
			}
		}
		return barrioEncontrado;
	}

}
