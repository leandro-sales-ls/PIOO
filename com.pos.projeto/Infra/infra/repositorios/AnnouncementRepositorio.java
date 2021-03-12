package infra.repositorios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Advertiser;
import domain.Announcement;
import domain.Category;

public class AnuncioRepositorio extends RepositorioBase implements repositorios.AnuncioRepositorio {
	
	
	@Override
	public void inserir(Announcement objeto) throws SQLException {
		try {
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String query = "insert into announcement(guid, guidadvertiser, guidcategory, datavalidade) values (?, ?, ?, ?)" ;

			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getId());
			ps.setString(2, objeto.getAnunciante().getId());
			ps.setString(3, objeto.getCategoria().getId());
			ps.setString(4, sdf.format(objeto.getDataValidade()));
			ps.executeUpdate();  

		} catch (SQLException e) {  
			System.out.println("Erro ao inserir announcement");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  
	}

	@Override
	public void alterar(Announcement objeto) throws SQLException {
		try {  

			String query = "update announcement set guidadvertiser = ?, guidcategory = ?, datavalidade = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getAnunciante().getId());
			ps.setString(2, objeto.getCategoria().getId());
			ps.setDate(3, (Date)objeto.getDataValidade());
			ps.setString(4, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar announcement");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

	}

	@Override
	public void excluir(Announcement objeto) throws SQLException {
		try {  

			String query = "delete from announcement where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao excluir announcement");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

	}

	@Override
	public List<Announcement> listarConsulta(String filtro) throws SQLException {
		ArrayList<Announcement> objetos = new ArrayList<Announcement>();

		try {  

			String query = "SELECT ANUNCIO.GUID, ANUNCIO.GUIDANUNCIANTE, ANUNCIO.GUIDCATEGORIA, ANUNCIO.DATAVALIDADE, ANUNCIO.DATACRIACAO, ANUNCIANTE.NOME AS ANUNCIANTENOME, ANUNCIANTE.DOCUMENTO, ANUNCIANTE.ENDERECO, ANUNCIANTE.CIDADE, ANUNCIANTE.TELEFONE, " + 
					"                  CATEGORIA.NOME AS CATEGORIANOME " + 
					" FROM     ANUNCIO INNER JOIN" + 
					"                  ANUNCIANTE ON ANUNCIANTE.GUID = ANUNCIO.GUIDANUNCIANTE INNER JOIN" + 
					"                  CATEGORIA ON CATEGORIA.GUID = ANUNCIO.GUIDCATEGORIA ";

			if(!filtro.isEmpty())
			{
				query += filtro;
			}

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ResultSet resultado = ps.executeQuery();



			while(resultado.next())
			{
				Category category = new Category(resultado.getString("CATEGORIANOME"));
				category.setId(resultado.getString("GUIDCATEGORIA"));
				Advertiser advertiser = new Advertiser(resultado.getString("ANUNCIANTENOME"), resultado.getString("documento"), resultado.getString("endereco"), resultado.getString("cidade"), resultado.getString("telefone"));
				advertiser.setId(resultado.getString("GUIDANUNCIANTE"));
				Announcement objeto = new Announcement(category, advertiser, (Date)resultado.getDate("DATAVALIDADE"));
				objeto.setId(resultado.getString("guid"));
				objeto.setDataCriacao((Date)resultado.getDate("datacriacao"));
				objetos.add(objeto);
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar advertiser");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

		return objetos;
	}

	@Override
	public Announcement selecionarConsulta(String codigo) throws SQLException {
		Announcement objeto = null;

		try {  
			String query = "SELECT ANUNCIO.GUID, ANUNCIO.GUIDANUNCIANTE, ANUNCIO.GUIDCATEGORIA, ANUNCIO.DATAVALIDADE, ANUNCIO.DATACRIACAO, ANUNCIANTE.NOME AS ANUNCIANTENOME, ANUNCIANTE.DOCUMENTO, ANUNCIANTE.ENDERECO, ANUNCIANTE.TELEFONE, " + 
					"                  CATEGORIA.NOME AS CATEGORIANOME " + 
					" FROM     ANUNCIO INNER JOIN" + 
					"                  ANUNCIANTE ON ANUNCIANTE.GUID = ANUNCIO.GUIDANUNCIANTE INNER JOIN" + 
					"                  CATEGORIA ON CATEGORIA.GUID = ANUNCIO.GUIDCATEGORIA " +
					" WHERE ANUNCIO.GUID = ? ";
					
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, codigo);
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				Category category = new Category(resultado.getString("CATEGORIANOME"));
				category.setId(resultado.getString("GUIDCATEGORIA"));
				Advertiser advertiser = new Advertiser(resultado.getString("ANUNCIANTENOME"), resultado.getString("documento"), resultado.getString("endereco"), resultado.getString("cidade"), resultado.getString("telefone"));
				advertiser.setId(resultado.getString("GUIDANUNCIANTE"));
				objeto = new Announcement(category, advertiser, (Date)resultado.getDate("DATAVALIDADE"));
				objeto.setId(resultado.getString("guid"));
				objeto.setDataCriacao((Date)resultado.getDate("datacriacao"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar announcement");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

		return objeto;
	}

}
