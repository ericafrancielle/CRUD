package aplicaEscala.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory unidadePersistencia = null;

	public static EntityManager getEntityManager() {
		if (unidadePersistencia == null) {
			unidadePersistencia = Persistence.createEntityManagerFactory("escala");
		}
		EntityManager gerenciadorDeEntidade = unidadePersistencia.createEntityManager();

		return gerenciadorDeEntidade;
	}
}
