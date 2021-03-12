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

public class DeleteUser   implements Command {

	private UsuarioRepositorio userRepositorio;
	public DeleteUser() {
		if(userRepositorio == null)
		{
			this.userRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			User user = new User("", "");
			user.setId(request.getParameter("id"));

			this.userRepositorio.excluir(user);

			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListUser");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}