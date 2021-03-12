package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.User;
import repositorios.UsuarioRepositorio;

public class EditUser implements Command {

	private UsuarioRepositorio userRepositorio;
	public EditUser() {
		if(userRepositorio == null)
		{
			this.userRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = null;
			if(request.getParameter("id") != null) {
				user = this.userRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				user = new User("", "", "");
			}
			
			request.setAttribute("user", user);

			RequestDispatcher d = request.getRequestDispatcher("/User/EditUser.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
