package aplicacaoEscala.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import aplicacaoEscala.dao.UsuarioDao;
import aplicacaoEscala.model.Usuario;

@ManagedBean
@RequestScoped
public class LoginBean {

	private Usuario usuario;
	private UsuarioDao dao;
	private String loginUsuario;

	@PostConstruct
	public void logar() {
		usuario = new Usuario();
		dao = new UsuarioDao();
		loginUsuario = usuario.getLogin();
		dao.consultarLogin();
		redireciona();

	}

	public String redireciona() {
		return "pagina?faces-redirect=true";/* /cadastro/index.hhtm */
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

}
