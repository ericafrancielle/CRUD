package aplicacaoEscala.dao;

import static aplicaEscala.util.JpaUtil.getEntityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import aplicacaoEscala.model.Comunidade;

public class DaoComunidade extends DaoGeneric<Comunidade> {
	private static final String SELECT = "select c from Comunidade c where c.nomeComunidade=:nome_Comunidade";

	public boolean consultarComunidade(String nome_Comunidade) {

		try {
			EntityManager gerenciarEntidade = getEntityManager();

			TypedQuery<Comunidade> consulta = gerenciarEntidade.createQuery(SELECT, Comunidade.class);
			consulta.setParameter("nome_Comunidade", nome_Comunidade);
			List<Comunidade> comunidadeEncontrada = consulta.getResultList();
			if (comunidadeEncontrada.isEmpty()) {
				System.out.println("Comunidade pode ser cadastrada ");
				gerenciarEntidade.close();
				return true;
			} else {
				System.out.println("Comunidade não pode ser cadastrada");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro ao consultar se Comunidade cadastrada já existe");
			return false;
		}

	}

	

}
