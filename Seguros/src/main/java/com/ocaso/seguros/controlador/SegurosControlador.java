package com.ocaso.seguros.controlador;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Seguro;
import com.ocaso.seguros.persistencia.SegurosDAO;
import com.ocaso.seguros.persistencia.SegurosDAOImplJpa;

public class SegurosControlador {
	
	SegurosDAO seguros;

	public SegurosControlador() {
		seguros = new SegurosDAOImplJpa();
	}
	
	public void ejer1() {
		List<Seguro> seguro = seguros.findAll();
		for (Seguro s : seguro) {
			System.out.println(s.toString());
		}
	}
	
	public void ejer2() {
		List<Object[]> seguro = seguros.findNifAndNombre();
		for (Object[] o : seguro) {
			System.out.println("NIF: " + o[0] + " Nombre: " + o[1]);
		}	
	}
	
	public void ejer3() {
		Seguro  s = seguros.getByName("maria", "garcia", "lozano");
		System.out.println(" El NIF de Maria Garcia Lozano es " +s.getNif());
	}
	
	public void ejer9() {
		List<Object[]> seguro = seguros.getSeguroNifCount();
		for (Object[] o : seguro) {
			System.out.println("Nombre: " + o[0] + " NIF: " + o[1] + " Nº de asistencias " + o[2]);
		}	
	}
	
	public void ejer10() {
		List<Object> seguro = seguros.getNombreAlergia();
		for(Object o : seguro) {
			System.out.println(o);
		}
	}
	
}

