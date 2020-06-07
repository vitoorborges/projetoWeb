package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.Bean.UsuarioBean;

import java.sql.ResultSet;

public class UsuarioDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	private ArrayList<UsuarioBean> listaUsuario = new ArrayList<UsuarioBean>();
	
	public UsuarioDao() {
		conn = new ConnectionFactory().getConnection();
	}
	
	public boolean insereUsuario(UsuarioBean usuarioBean){
		String sql = "INSERT INTO usuario (id_usuario, username, password) values(?,?,?)";
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.setString(2, usuarioBean.getLogin());
			ps.setString(3, usuarioBean.getSenha());
			ps.execute();
			ps.close();
			return true;
			
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<UsuarioBean> listarUsuarios(){
		
		String sql = "SELECT * FROM usuario";
		
		try {
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				UsuarioBean usuarioBean = new UsuarioBean(rs.getString("username"), rs.getString("password"));
				listaUsuario.add(usuarioBean);
			}
			
		} catch (Exception e) {
			
		}
		
		return listaUsuario;
		
	}
	public UsuarioBean validarUsuario(UsuarioBean usuario){
		
		String sql = "SELECT id_usuario, username FROM usuario WHERE username = ? and password = ?";
		UsuarioBean usuarioBean = null;
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			ps.close();
			
			
			
			while(rs.next()){
				 usuarioBean = new UsuarioBean(rs.getString("username"), rs.getString("password"));
			}
			
			
			
		} catch (Exception e) {
		
		}
		return usuarioBean;
		
	}
	

}
