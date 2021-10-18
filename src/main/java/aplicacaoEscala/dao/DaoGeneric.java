package aplicacaoEscala.dao;

import static aplicaEscala.util.JpaUtil.getEntityManager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class DaoGeneric<Entidade> {


	public void salvar(Entidade entidade) throws Exception {
		EntityManager gerenciarEntidade = getEntityManager();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.merge(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}
	}

	public void deletar(Entidade entidade) throws Exception {
		EntityManager gerenciarEntidade = getEntityManager();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.remove(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}

	}

	public void deletarPorId(Class<Entidade> classe, Integer id) {
		EntityManager gerenciadorEntidade = getEntityManager();
		Object objeto = null;
		try {
			gerenciadorEntidade.getTransaction().begin();
			objeto = gerenciadorEntidade.find(classe, id);
			gerenciadorEntidade.remove(objeto);
			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception e) {
			gerenciadorEntidade.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			gerenciadorEntidade.close();
		}
	}

	public void update(Entidade entidade) throws Exception {
		EntityManager gerenciarEntidade = getEntityManager();
		try {
			gerenciarEntidade.getTransaction().begin();
			gerenciarEntidade.merge(entidade);
			gerenciarEntidade.getTransaction().commit();

		} catch (Exception e) {
			gerenciarEntidade.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			gerenciarEntidade.close();
		}

	}
	public void updatePorId(Class<Entidade> classe, Integer id) {
		EntityManager gerenciadorEntidade = getEntityManager();
		Object objeto = null;
		try {
			gerenciadorEntidade.getTransaction().begin();
			objeto = gerenciadorEntidade.find(classe, id);
			gerenciadorEntidade.merge(objeto);
			gerenciadorEntidade.getTransaction().commit();
		} catch (Exception e) {
			gerenciadorEntidade.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			gerenciadorEntidade.close();
		}
	}
	

	@SuppressWarnings("unchecked")
	public Entidade buscarPorID(Class<Entidade> classe, Integer id) {

		EntityManager gerenciarEntidade = getEntityManager();
		Object objeto = null;
		try {
			objeto = gerenciarEntidade.find(classe, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gerenciarEntidade.close();
		}
		return (Entidade) objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> listar(Entidade entidade) {
		EntityManager gerenciarEntidade = getEntityManager();
		List<Entidade> listaEntidadeGenerica = new ArrayList<Entidade>();
		try {
			listaEntidadeGenerica = gerenciarEntidade.createQuery("FROM " + entidade.getClass().getName())
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaEntidadeGenerica;
	}

	public Object listarPorId(Long id, Class<Entidade> entidade) {
		EntityManager gerenciarEntidade = getEntityManager();
		Object resultado = null;
		try {

			resultado = gerenciarEntidade.find(entidade, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			gerenciarEntidade.close();
		}
		return resultado;
	}
	

}
