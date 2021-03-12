package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Advertiser;
import domain.Category;
import infra.repositorios.AnuncianteRepositorio;
import repositorios.CategoriaRepositorio;

public class SaveAdvertiser implements Command {

	private AnuncianteRepositorio advertiserRepositorio;
	public SaveAdvertiser() {
		if(advertiserRepositorio == null)
		{
			this.advertiserRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Advertiser advertiser = new Advertiser(request.getParameter("nome"), request.getParameter("documento"), request.getParameter("endereco"), request.getParameter("cidade"), request.getParameter("telefone"));

			if(!request.getParameter("isnew").equals("true"))
			{
				advertiser.setId(request.getParameter("id"));
				isNovo = false;
			}

			if(advertiser.EValido())
			{
				if(isNovo)
				{
					this.advertiserRepositorio.inserir(advertiser);
				}
				else
				{
					this.advertiserRepositorio.alterar(advertiser);
				}
			}

			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListAdvertiser");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}