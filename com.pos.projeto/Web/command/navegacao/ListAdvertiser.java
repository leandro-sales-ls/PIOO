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
import domain.Announcement;
import domain.Category;
import repositorios.AnuncianteRepositorio;
import repositorios.AnuncioRepositorio;

public class ListAdvertiser  implements Command {

	private AnuncianteRepositorio advertiserRepositorio;
	public ListAdvertiser() {
		if(advertiserRepositorio == null)
		{
			this.advertiserRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Advertiser> advertisers = this.advertiserRepositorio.listarConsulta("");
		
			request.setAttribute("advertisers", advertisers);
			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/ListAdvertiser.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}