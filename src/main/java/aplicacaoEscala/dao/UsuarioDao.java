package aplicacaoEscala.dao;

import static aplicaEscala.util.JpaUtil.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import aplicacaoEscala.model.Usuario;

public class UsuarioDao extends DaoGeneric<Usuario> {

	@SuppressWarnings({ "unused", "unchecked" })
	public boolean consultarLogin(String loginUsuario, String senha) {
		try {
			
			EntityManager gerenciarEntidade = getEntityManager();
			
			
			TypedQuery<Usuario> query =  gerenciarEntidade.
					createQuery("select u from Usuario u where u.login = :usuario and u.senha = :senha", Usuario.class);
			
			query.setParameter("usuario", loginUsuario);
			query.setParameter("senha", senha);
			
			Usuario usuarioEncontrado = query.getSingleResult();
			
			System.out.println("Usuário já está cadastrado ");
			gerenciarEntidade.close();
             return true;
		} catch (Exception e) {
			System.out.println("Login não é cadastrado");
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