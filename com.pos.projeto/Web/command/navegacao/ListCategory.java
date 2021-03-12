package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import command.Command;
import domain.Category;
import repositorios.CategoriaRepositorio;

public class ListarCategoria implements Command {

	private CategoriaRepositorio categoryRepositorio;
	public ListarCategoria() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<Category> categorys = this.categoryRepositorio.listarConsulta("");

			request.setAttribute("categorys", categorys);

			RequestDispatcher d = request.getRequestDispatcher("/Category/ListarCategoria.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}
