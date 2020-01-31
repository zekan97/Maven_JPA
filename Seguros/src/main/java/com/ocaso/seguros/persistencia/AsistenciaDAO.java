package com.ocaso.seguros.persistencia;

import java.util.List;

import com.ocaso.seguros.modelo.Asistencia;

public interface AsistenciaDAO extends GenericDAO<Asistencia,Integer>  {
	
	public List<Asistencia> getAsistenciaRangoDinero1 ();
	public List<Integer> getIdAsistenciaRangoDinero2();
	public Object getSuma();
	public Object getMedia();
	public Object getCuenta();
}
