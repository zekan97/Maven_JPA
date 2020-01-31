package com.ocaso.seguros;

import javax.persistence.EntityManager;

import com.ocaso.seguros.controlador.AsistenciaControlador;
import com.ocaso.seguros.controlador.SegurosControlador;
import com.ocaso.seguros.persistencia.Utilidades;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		EntityManager em = null; 
		
		try {
			em = Utilidades.getEntityManagerFactory().createEntityManager();	

			SegurosControlador e1 = new SegurosControlador();
			e1.ejer10();
			/*
			AsistenciaControlador a1 = new AsistenciaControlador();
			a1.ejer8();
*/
			
		} catch (Exception e ) {
			//e.printStackTrace();
			if (em != null) {
				e.printStackTrace();
				System.out.println("Se va a hacer rollback de la transacción");
				em.getTransaction().rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		Utilidades.closeEntityManagerFactory();
    }
   
}
