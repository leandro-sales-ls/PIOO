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

public class DeleteAnnouncement  implements Command {

	private AnuncioRepositorio announcementRepositorio;
	public DeleteAnnouncement() {
		if(announcementRepositorio == null)
		{
			this.announcementRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Announcement announcement = new Announcement(new Category(""), new Advertiser("", "", "", "", ""), new Date());
			
			announcement.setId(request.getParameter("id"));
			
			this.announcementRepositorio.excluir(announcement);
		
			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListAnnouncement");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}