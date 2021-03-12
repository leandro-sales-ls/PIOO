package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Category;
import repositorios.CategoriaRepositorio;

public class EditCategory implements Command {

	private CategoriaRepositorio categoryRepositorio;
	public EditCategory() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Category category = null;
			if(request.getParameter("id") != null) {
				category = this.categoryRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				category = new Category("");
			}
			
			request.setAttribute("category", category);

			RequestDispatcher d = request.getRequestDispatcher("/Category/EditCategory.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
