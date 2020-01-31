package com.ocaso.seguros.persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ocaso.seguros.modelo.Asistencia;


public class AsistenciaDAOImplJpa extends GenericDAOImplJpa<Asistencia,Integer> implements  AsistenciaDAO {
	
	public List<Asistencia> getAsistenciaRangoDinero1 () {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Asistencia> q = em.createQuery("select a from Asistencia "
				+ "a where importe >= 10000",Asistencia.class);
		return q.getResultList();
	}
	
	public List<Integer> getIdAsistenciaRangoDinero2() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Integer> q = em.createQuery("select a.id from Asistencia"
				+ " a where importe >= :importe1 and importe <= :importe2",
				Integer.class)
				.setParameter("importe1", new BigDecimal(8000))
				.setParameter("importe2", new BigDecimal(15000));
		return q.getResultList();		
	}
	
	public Object getSuma() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object> q = em.createQuery("select sum(a.importe) from Asistencia a",Object.class);
		return q.getSingleResult();
	}
	
	public Object getMedia() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object> q = em.createQuery("select avg(a.importe) from Asistencia a",Object.class);
		return q.getSingleResult();
	}
	
	public Object getCuenta() {
		EntityManager em = Utilidades.getEntityManagerFactory().createEntityManager();
		TypedQuery<Object> q = em.createQuery("select count(a.importe) from Asistencia a",Object.class);
		return q.getSingleResult();
	}
}
