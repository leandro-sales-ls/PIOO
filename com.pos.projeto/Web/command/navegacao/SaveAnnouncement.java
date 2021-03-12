package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Advertiser;
import domain.Announcement;
import domain.Category;
import repositorios.AnuncioRepositorio;

public class SaveAnnouncement implements Command {

	private AnuncioRepositorio announcementRepositorio;
	public SaveAnnouncement() {
		if(announcementRepositorio == null)
		{
			this.announcementRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Category category = new Category("");			
			Advertiser advertiser = new Advertiser("", "", "", "", "");
			category.setId(request.getParameter("categoryId").toString());
			advertiser.setId(request.getParameter("advertiserId").toString());

			Announcement announcement = new Announcement(category, advertiser, new Date());


			if(!request.getParameter("isnew").equals("true"))
			{
				announcement.setId(request.getParameter("id"));
				isNovo = false;
			}


			if(isNovo)
			{
				this.announcementRepositorio.inserir(announcement);
			}
			else
			{
				this.announcementRepositorio.alterar(announcement);
			}


			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListAnnouncement");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}