package br.com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BO.UsuarioBO;
import br.com.Bean.UsuarioBean;

/**
 * Servlet implementation class ValidarLogin
 */
@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidarLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int op = Integer.parseInt(request.getParameter("operador"));

		switch (op) {
		case 1:
			String usuario = request.getParameter("txtLogin");
			String senha = request.getParameter("txtPassword");
			UsuarioBO usuarioBo = new UsuarioBO();
			UsuarioBean usuarioBean = usuarioBo.validaUsuario(usuario, senha);
			boolean result = true;
			
			if(usuarioBean != null){
				
				request.setAttribute("mensagem", "Login valido");
			}else{
				request.setAttribute("mensagem", "login invalido");
			}
			request.getSession().setAttribute("usuarioLogado", usuarioBean);
			request.setAttribute("result", result);
			request.getRequestDispatcher("Index.jsp").forward(request, response);

			break;
		
		case 2:
			String usuarioCadastro = request.getParameter("txtLoginCadastro");
			String senhaCadastro =  request.getParameter("txtPasswordCadastro");
			UsuarioBO usuarioBoCadastro = new UsuarioBO();
			String resultado = usuarioBoCadastro.insereUsuario(usuarioCadastro, senhaCadastro);
			boolean resultCadastro = true;
			
			if(resultado == "Index.jsp"){
				request.setAttribute("result", resultCadastro);
				request.setAttribute("mensagem", "Usuario Cadastrado com sucesso");
			}else{
				request.setAttribute("mensagem", "usuario não cadastrado");
			}
			
			request.getRequestDispatcher(resultado).forward(request, response);
			
			break;

		default:
			break;
		}

	}

}
