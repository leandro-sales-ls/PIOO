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


public class SaveUser  implements Command {

	private UsuarioRepositorio categoryRepositorio;
	public SaveUser() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			User userlogado = (User)request.getSession().getAttribute("userLogado");
			User user = new User(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"));

			if(!request.getParameter("isnew").equals("true"))
			{
				user.setId(request.getParameter("id"));
				isNovo = false;
			}

			if(user.EValido())
			{
				if(isNovo)
				{
					this.categoryRepositorio.inserir(user);
				}
				else
				{
					this.categoryRepositorio.alterar(user);
				}
			}

			
			if(userlogado == null)
			{
				request.getRequestDispatcher("Controller?command=LoginUser").forward(request,response);
			}
			else
			{
				request.getRequestDispatcher("Controller?command=ListUser").forward(request,response);
			}
		

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}