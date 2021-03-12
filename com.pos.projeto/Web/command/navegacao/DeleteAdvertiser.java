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
import repositorios.AnuncianteRepositorio;

public class DeleteAdvertiser  implements Command {

	private AnuncianteRepositorio advertiserRepositorio;
	public DeleteAdvertiser() {
		if(advertiserRepositorio == null)
		{
			this.advertiserRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			
			Advertiser advertiser = new Advertiser("","","","","");
			
			advertiser.setId(request.getParameter("id"));
			
			this.advertiserRepositorio.excluir(advertiser);
			
			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListAdvertiser");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}