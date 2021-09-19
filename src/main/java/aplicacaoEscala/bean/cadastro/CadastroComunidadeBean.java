package aplicacaoEscala.bean.cadastro;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import aplicacaoEscala.dao.DaoComunidade;
import aplicacaoEscala.model.Comunidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CadastroComunidadeBean implements Serializable {
	private Comunidade comunidade;
	private DaoComunidade dao;
	private String nome_Comunidade;
	private List<Comunidade> comunidades;
	private Comunidade selecionada;

	@PostConstruct
	public void inicializarPagina() {
		comunidade = new Comunidade();
		dao = new DaoComunidade();
		comunidades = dao.listar(comunidade);
		System.out.println("Inicializou");
	}

	public void novo() {
		comunidade = new Comunidade();
	}

	public void cadastrar() {

		try {
			nome_Comunidade = comunidade.getNomeComunidade();
			if (dao.consultarComunidade(nome_Comunidade) == true) {
				dao.salvar(comunidade);
				String msg = "Comunidade = " + comunidade.getNomeComunidade() + " salva com sucesso!";
				FacesMessage menssagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
				FacesContext contexto = FacesContext.getCurrentInstance();
				contexto.addMessage(null, menssagem);
			}

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao gravar comunidade no banco de dados.");
			e.printStackTrace();
		} finally {
            
			comunidades = dao.listar(comunidade);

		}

	}

	public void editar(ActionEvent evento) {
		comunidade = (Comunidade) evento.getComponent().getAttributes().get("comunidadeselecionada");
		Messages.addFlashGlobalInfo("Nome:  " + comunidade.getNomeComunidade());

	}

	public void excluirComunidade(Integer id) {
		try {
			DaoComunidade daocomunidade = new DaoComunidade();
			daocomunidade.deletarPorId(Comunidade.class, id);
			org.omnifaces.util.Messages.addGlobalInfo("Comunidade removida", comunidade);
		} catch (Exception erro) {
			org.omnifaces.util.Messages.addFlashGlobalError("Ocorreu erro ao remover comunidade");
			erro.getStackTrace();
		} finally {

			comunidades = dao.listar(comunidade);

		}
	}

	public String getNome_Comunidade() {
		return nome_Comunidade;
	}

	public void setNome_Comunidade(String nome_Comunidade) {
		this.nome_Comunidade = nome_Comunidade;
	}

	public List<Comunidade> getComunidades() {
		return comunidades;
	}

	public void setComunidades(List<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public DaoComunidade getDao() {
		return dao;
	}

	public void setDao(DaoComunidade dao) {
		this.dao = dao;
	}

	public Comunidade getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Comunidade selecionada) {
		this.selecionada = selecionada;
	}

}
