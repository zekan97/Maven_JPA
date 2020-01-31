package com.ocaso.seguros.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Seguro;



public class SegurosDAOImplJpa extends GenericDAOImplJpa<Seguro,Integer> implements  SegurosDAO {

	public List<Seguro> findAll() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Seguro> q = em.createQuery("select s from Seguro s", Seguro.class);
		//q.setParameter("nombre", nombre);
		return q.getResultList();		
	}
	
	public List<Object[]> findNifAndNombre() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object[]> q = em.createQuery("select s.nif, s.nombre from Seguro s", Object[].class);
		return q.getResultList();	
	}
	
	public Seguro getByName(String nombre, String ape1, String ape2) {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Seguro> q =  em.createQuery("select s from Seguro s"
				+ " where s.nombre = :nombre and s.ape1 = :ape1 and s.ape2 "
				+ "= :ape2", Seguro.class)
				.setParameter("nombre", nombre)
				.setParameter("ape1", ape1)
				.setParameter("ape2", ape2);
		Seguro resultado = q.getSingleResult();
		return resultado;		
	}
	
	public List<Object[]> getSeguroNifCount() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object[]> q = em.createQuery("select s.nombre, s.nif, count(s.nombre) from Seguro s join Asistencia a on s.id"
				+ " = a.seguro group by s.nif", Object[].class);
		return q.getResultList();		
	}
	
	public List<Object> getNombreAlergia() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object> q = em.createQuery("select e.nombreAlergia from Enfermedad e "
				+ "right join Seguro s on e.id = s.enfermedad ", Object.class);
		return q.getResultList();
	}
}
