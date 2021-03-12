package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Advertiser;
import domain.Announcement;
import domain.Category;
import repositorios.AnuncianteRepositorio;
import repositorios.AnuncioRepositorio;
import repositorios.CategoriaRepositorio;

public class EditAnnouncement implements Command {

	private CategoriaRepositorio categoryRepositorio;
	private AnuncianteRepositorio advertiserRepositorio;
	private AnuncioRepositorio announcementRepositorio;
	
	public EditAnnouncement() {
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
			Announcement announcement = null;
			
			if(request.getAttribute("id") != null)
			{
				announcement = this.announcementRepositorio.selecionarConsulta(request.getAttribute("id").toString());
			}
			else
			{
				announcement = new Announcement(new Category(""), new Advertiser("", "", "", "", ""), new Date());
			}
			List<Category> categorys = this.categoryRepositorio.listarConsulta("");
			List<Advertiser> advertisers = this.advertiserRepositorio.listarConsulta("");
			
			request.setAttribute("categorys", categorys);
			request.setAttribute("advertisers", advertisers);
			request.setAttribute("announcement", announcement);

			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/EditAnnouncement.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}