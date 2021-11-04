package aplicacaoEscala.dao;

import static aplicaEscala.util.JpaUtil.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import aplicacaoEscala.model.Usuario;

public class UsuarioDao extends DaoGeneric<Usuario> {

	public boolean verificaUsuarioExiste(String loginUsuario) {
		try {

			EntityManager gerenciarEntidade = getEntityManager();

			TypedQuery<Integer> query = gerenciarEntidade.createQuery(
					"select count(u) from Usuario u where u.login = :usuario", Integer.class);

			query.setParameter("usuario", loginUsuario);
			

			Integer usuarioEncontrado = query.getSingleResult();
			if (usuarioEncontrado == null) {
				System.out.println("Usuario não existe, pode cadastrá-lo");
			}
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public boolean usuarioEsenhaSaoCompativeisComBanco(String loginUsuario, String senha) {
		try {

			EntityManager gerenciarEntidade = getEntityManager();

			TypedQuery<Integer> query = gerenciarEntidade.createQuery(
					"select count(u) from Usuario u where u.login = :usuario and u.senha = :senha", Integer.class);

			query.setParameter("usuario", loginUsuario);
			query.setParameter("senha", senha);

			Integer usuarioEncontrado = query.getSingleResult();
			if (usuarioEncontrado != null) {
				System.out.println("Usuario e senha são compatíveis");
			}
			return true;

		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}

	}

	public Usuario getUserByLogin(String usuario) throws Exception {
		try {
			TypedQuery<Usuario> query = getEntityManager().createNamedQuery("obterUsuarioPorLogin", Usuario.class);
			query.setParameter("login", usuario);
			return query.getSingleResult();
		} catch (Exception e) {
			throw new Exception("Deu erro a consulta");
		} finally {
			System.out.println("Deu tudo certinho garotinho.");
		}
	}

	public List<Usuario> retornaTodosUsuarios() throws Exception {
		try {
			TypedQuery<Usuario> query = getEntityManager().createNamedQuery("retornaTudo", Usuario.class);
			return query.getResultList();
		} catch (Exception e) {
			throw new Exception("Deu erro a consulta");
		} finally {
			System.out.println("Deu tudo certinho garotinho.");
		}
	}

}