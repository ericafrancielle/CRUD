package aplicaEscala.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import aplicacaoEscala.model.Usuario;

public class ConsultasJpql {
	
	public  static void  consulta(EntityManager em ) {
		String jpql = "select u from Usuario u ";
		TypedQuery<Usuario> typedQuery = em.createQuery(jpql, Usuario.class);
		List<Usuario> lista = typedQuery.getResultList();
		lista.forEach (u -> System.out.println(u.getLogin()));
	}

}
