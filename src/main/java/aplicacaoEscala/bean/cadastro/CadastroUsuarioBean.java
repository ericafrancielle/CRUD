package aplicacaoEscala.bean.cadastro;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import aplicacaoEscala.dao.UsuarioDao;
import aplicacaoEscala.model.Usuario;

@ViewScoped
@ManagedBean
public class CadastroUsuarioBean {
	
	private Usuario usuario;
	private UsuarioDao dao;

	@PostConstruct
	public void inicializarPagina() {
		usuario = new Usuario();
		dao = new UsuarioDao();
		System.out.println("Inicializou");
	}
	
	public void cadastrar() {
		try {
			dao.salvar(usuario);
			usuario = new Usuario();
		} catch (Exception e) {
			System.out.println("Erro ao gravar usuário no banco de dados.");
			e.printStackTrace();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
