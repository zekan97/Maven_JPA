package com.ocaso.seguros.controlador;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.ocaso.seguros.modelo.Asistencia;
import com.ocaso.seguros.persistencia.AsistenciaDAO;
import com.ocaso.seguros.persistencia.AsistenciaDAOImplJpa;

public class AsistenciaControlador {
	
	AsistenciaDAO asistencia;

	public AsistenciaControlador() {
		asistencia = new AsistenciaDAOImplJpa();
	}
	
	public void ejer4() {
		List<Asistencia> asistencias = asistencia.getAsistenciaRangoDinero1();
		System.out.println("El id de las Asistencias con importe mayor o igual a 10000 es:");
		for (Asistencia a : asistencias) {
			System.out.println(a.getId());
		}
	}
	
	public void ejer5() {
		List<Integer> asistencias = asistencia.getIdAsistenciaRangoDinero2();
		Iterator iter = asistencias.iterator();
		while (iter.hasNext())
		  System.out.println(iter.next());
		}

	public void ejer6() {
		Object suma = asistencia.getSuma();
		System.out.println("La suma de los importes es: " + suma);
	}
	
	public void ejer7() {
		Object media = asistencia.getMedia();
		System.out.println("La media de los importes es: " + media);
	}
	
	public void ejer8() {
		Object cuenta = asistencia.getCuenta();
		System.out.println("Hay un total de " + cuenta + " seguros");
	}
}


