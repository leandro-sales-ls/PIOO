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
import domain.Advertiser;
import domain.Category;
import repositorios.AnuncianteRepositorio;
import repositorios.AnuncioRepositorio;
import repositorios.CategoriaRepositorio;

public class EditAdvertiser implements Command {

	private CategoriaRepositorio categoryRepositorio;
	private AnuncianteRepositorio advertiserRepositorio;
	private AnuncioRepositorio announcementRepositorio;

	public EditAdvertiser() {
		if(categoryRepositorio == null)
		{
			this.categoryRepositorio = new infra.repositorios.CategoriaRepositorio();
		}

		if(advertiserRepositorio == null)
		{
			this.advertiserRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}

		if(announcementRepositorio == null)
		{
			this.announcementRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			Advertiser advertiser = null;
			if(request.getParameter("id") != null) {
				advertiser = this.advertiserRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				advertiser = new Advertiser("", "", "", "", "");
			}
			request.setAttribute("advertiser", advertiser);

			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/EditAdvertiser.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}