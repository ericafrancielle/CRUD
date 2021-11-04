package aplicacaoEscala.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import aplicaEscala.util.CriptografiaUtil;
import aplicacaoEscala.dao.UsuarioDao;
import aplicacaoEscala.model.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

	private Usuario usuario;
	private UsuarioDao dao;

	@PostConstruct
	public void inicializar() {
		usuario = new Usuario();
		dao = new UsuarioDao();

	}

	public void logar() {
		try {

			usuario.setSenha(CriptografiaUtil.criptografa(usuario.getSenha()));

			if (usuarioSenhaOk()) {
				redireciona();
			} else {
				Messages.addGlobalError("Usuario ou senha não correspondem aos cadastrados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean usuarioSenhaOk() {
		return dao.usuarioEsenhaSaoCompativeisComBanco(usuario.getLogin(), usuario.getSenha());
	}

	public String redireciona() {
		return "index?faces-redirect=true";
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
