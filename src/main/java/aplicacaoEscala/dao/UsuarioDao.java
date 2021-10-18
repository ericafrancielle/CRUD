package aplicacaoEscala.dao;

import static aplicaEscala.util.JpaUtil.getEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import aplicacaoEscala.model.Usuario;

public class UsuarioDao extends DaoGeneric<Usuario> {

	@SuppressWarnings("unused")
	public boolean consultarLogin() {
		try {
			EntityManager gerenciarEntidade = getEntityManager();
			@SuppressWarnings("unchecked")
			TypedQuery<Usuario> query = (TypedQuery<Usuario>) gerenciarEntidade
					.createNamedQuery("select u from Usuario u where login = :loginUsuario");
			Usuario usuarioEncontrado = query.getSingleResult();
			System.out.println("Usuário já está cadastrado ");
			gerenciarEntidade.close();
             return false;
		} catch (Exception e) {
			System.out.println("Login não é cadastrado");
			return true;
		}

	}

}