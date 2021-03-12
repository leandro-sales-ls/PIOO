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

public class LoginUser implements Command {

	private UsuarioRepositorio userRepositorio;
	public LoginUser() {
		if(userRepositorio == null)
		{
			this.userRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			if(request.getParameter("login") == null && request.getParameter("senha") == null)
			{
				request.getSession().setAttribute("userLogado", null);
				RequestDispatcher d = request.getRequestDispatcher("/User/LoginUser.jsp");
				d.forward(request,response);

			}
			else
			{

				User user = new User(request.getParameter("login").toString(), request.getParameter("senha").toString());

				if(user.EValido())
				{
					user = this.userRepositorio.Login(user);	
					if(user != null)
					{
						request.getSession().setAttribute("userLogado", user);
						RequestDispatcher d = request.getRequestDispatcher("/index.jsp");
						d.forward(request,response);
					}
					else
					{
						request.getSession().setAttribute("userLogado", null);
						RequestDispatcher d = request.getRequestDispatcher("/User/LoginUser.jsp");
						d.forward(request,response);
					}
				}
				else
				{
					request.getSession().setAttribute("userLogado", null);
					RequestDispatcher d = request.getRequestDispatcher("/User/LoginUser.jsp");
					d.forward(request,response);

				}
			}

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
