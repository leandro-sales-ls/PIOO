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

public class DeleteCategory   implements Command {

	private CategoriaRepositorio categoryRepositorio;
	public DeleteCategory() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Category category = new Category("");
			category.setId(request.getParameter("id"));
			
			this.categoryRepositorio.excluir(category);
			
			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarCategoria");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}