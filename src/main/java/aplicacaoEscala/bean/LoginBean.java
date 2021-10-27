package aplicacaoEscala.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

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
		try {
			List<Usuario> retornaTodosUsuarios = dao.retornaTodosUsuarios();
			retornaTodosUsuarios.forEach(System.out::println);
			
			
			Usuario usuario = dao.getUserByLogin("teste");
			
			System.out.println(usuario);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logar() {
		try {
			
			if (dao.consultarLogin(usuario.getLogin(),usuario.getSenha()) == true) {
				Messages.addFlashGlobalInfo("Usuario é cadastrado.Acesso permitido");
				redireciona();
			} else {
				Messages.addGlobalError("Usuario e/ou senha não não correspondem aos já existentes.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao consultar login");
			e.printStackTrace();
		}

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
