package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Announcement;
import repositorios.AnuncioRepositorio;

public class ShowAnnouncement implements Command {

	private AnuncioRepositorio announcementRepositorio;
	public ShowAnnouncement() {
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
			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/ShowAnnouncements.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}