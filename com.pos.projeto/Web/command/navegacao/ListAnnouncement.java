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
import repositorios.AnuncioRepositorio;
import repositorios.CategoriaRepositorio;

public class ListAnnouncement implements Command {

	private AnuncioRepositorio announcementRepositorio;
	public ListAnnouncement() {
		if(announcementRepositorio == null)
		{
			this.announcementRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Announcement> announcements = this.announcementRepositorio.listarConsulta("");
			request.setAttribute("announcements", announcements);
			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/ListAnnouncement.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}