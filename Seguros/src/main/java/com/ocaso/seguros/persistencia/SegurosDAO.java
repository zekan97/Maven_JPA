package com.ocaso.seguros.persistencia;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Seguro;

public interface SegurosDAO extends GenericDAO<Seguro,Integer>  {
	
	public List<Seguro> findAll();
	public List<Object[]> findNifAndNombre();
	public Seguro getByName(String nombre, String ape1, String ape2);
	public List<Object[]> getSeguroNifCount();
	public List<Object> getNombreAlergia();


}
