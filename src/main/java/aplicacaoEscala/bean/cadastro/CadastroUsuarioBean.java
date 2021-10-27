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
import aplicacaoEscala.dao.UsuarioDao;
import aplicacaoEscala.model.Comunidade;
import aplicacaoEscala.model.Usuario;

@SuppressWarnings("serial")
@ViewScoped
@ManagedBean
public class CadastroUsuarioBean implements Serializable {

	private Usuario usuario;
	private UsuarioDao dao;
	private String nome_Usuario;
	private List<Usuario> usuarios;
	private Usuario selecionado;
	private List<Comunidade> comunidades;
	private Comunidade comunidade;

	@PostConstruct
	public void inicializarPagina() {
		usuario = new Usuario();
		dao = new UsuarioDao();
		usuarios = dao.listar(usuario);
		System.out.println("Inicializou");
	}

	public void novo() {
		try {
			usuario = new Usuario();
			comunidade = new Comunidade();
			DaoComunidade dao = new DaoComunidade();
			comunidades = dao.listar(comunidade);

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Erro ao tentar gerar um novo usuario");
			erro.printStackTrace();
		}

	}

	public void cadastrar()  {
	
		try {
			nome_Usuario = usuario.getNome();
			if (dao.consultarLogin(usuario.getLogin(), usuario.getSenha()) == false) {
				dao.salvar(usuario); 
				String msg = "Usuario = " + usuario.getNome() + " salvo com sucesso!";
				FacesMessage menssagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
				FacesContext contexto = FacesContext.getCurrentInstance();
				contexto.addMessage(null, menssagem);
			}

		} catch (Exception e) {
			Messages.addGlobalError("Erro ao gravar usuario no banco de dados.");
			e.printStackTrace();
		} finally {

			usuarios = dao.listar(usuario);

		}

	}

	public void editar(ActionEvent evento) {
		comunidade = new Comunidade();
		DaoComunidade dao = new DaoComunidade();
		comunidades = dao.listar(comunidade);
		
		usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioselecionado");
		Messages.addFlashGlobalInfo("Nome: " + usuario.getNome());

	}

	public void excluirUsuario(Integer id) {
		try {
			UsuarioDao daousuario = new UsuarioDao();
			daousuario.deletarPorId(Usuario.class, id);
			org.omnifaces.util.Messages.addGlobalInfo("Usuário removido", usuario);
		} catch (Exception erro) {
			org.omnifaces.util.Messages.addFlashGlobalError("Ocorreu erro ao remover usuario");
			erro.getStackTrace();
		} finally {

			usuarios = dao.listar(usuario);

		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome_Usuario() {
		return nome_Usuario;
	}

	public void setNome_Usuario(String nome_Usuario) {
		this.nome_Usuario = nome_Usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Usuario selecionado) {
		this.selecionado = selecionado;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
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

}
