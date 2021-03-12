package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.User;
import repositorios.UsuarioRepositorio;

public class ListUser implements Command {

	private UsuarioRepositorio userRepositorio;
	public ListUser() {
		if(userRepositorio == null)
		{
			this.userRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<User> users = this.userRepositorio.listarConsulta("");

			request.setAttribute("users", users);

			RequestDispatcher d = request.getRequestDispatcher("/User/ListUser.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}

