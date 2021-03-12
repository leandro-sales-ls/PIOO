package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Category;
import repositorios.CategoriaRepositorio;

public class SaveCategory  implements Command {

	private CategoriaRepositorio categoryRepositorio;
	public SaveCategory() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Category category = new Category(request.getParameter("nome"));

			if(request.getParameter("isnew") != "true")
			{
				category.setId(request.getParameter("id"));
				isNovo = false;
			}

			if(category.EValido())
			{
				if(isNovo)
				{
					this.categoryRepositorio.inserir(category);
				}
				else
				{
					this.categoryRepositorio.alterar(category);
				}
			}

			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarCategoria");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}