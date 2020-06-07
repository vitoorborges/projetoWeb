package br.com.BO;

import java.util.ArrayList;

import br.com.Bean.UsuarioBean;
import br.com.DAO.UsuarioDao;

public class UsuarioBO {
	
	public ArrayList<UsuarioBean> mostrarUsuarios(){
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.listarUsuarios();
	}
	
	public String insereUsuario(String username, String password){
		
		UsuarioBean usuarioBean = new UsuarioBean(username, password);
		UsuarioDao usuarioDao = new UsuarioDao();
		
		if(usuarioDao.insereUsuario(usuarioBean)){
			return "Index.jsp";
		}else{
			return "Erro.jsp";
		}
		
	}
	
public UsuarioBean validaUsuario(String username, String password){
		
		UsuarioBean usuarioBean = new UsuarioBean(username, password);
		UsuarioDao usuarioDao = new UsuarioDao();
		
		return usuarioDao.validarUsuario(usuarioBean);
		
	}

}
