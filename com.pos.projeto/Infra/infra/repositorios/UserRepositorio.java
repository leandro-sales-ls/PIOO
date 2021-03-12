package infra.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import domain.User;

public class UsuarioRepositorio extends RepositorioBase implements repositorios.UsuarioRepositorio {


	@Override
	public void inserir(User objeto) throws SQLException {
		try {  

			String query = "insert into User(guid, nome, login, senha) values (?, ?, ?, ?)" ;

			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getId());
			ps.setString(2, objeto.getNome());
			ps.setString(3, objeto.getLogin());
			ps.setString(4, objeto.getSenha());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao inserir category");  
			objeto.adicionarMensagem("Erro ao inserir category");
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
	public void alterar(User objeto) throws SQLException {
		try {  

			String query = "update user set nome = ?, login = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getLogin());
			ps.setString(3, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar advertiser");  
			objeto.adicionarMensagem("Erro ao alterar advertiser");
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
	public void excluir(User objeto) throws SQLException {
		try {  

			String query = "delete from user where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao excluir category");  
			objeto.adicionarMensagem("Erro ao excluir category");
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
	public List<User> listarConsulta(String filtro) throws SQLException {
		ArrayList<User> objetos = new ArrayList<User>();

		try {  

			String query = "select guid, nome, login from user ";

			if(!filtro.isEmpty())
			{
				query += filtro;
			}

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ResultSet resultado = ps.executeQuery();



			while(resultado.next())
			{
				User objeto = new User(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
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
	public User selecionarConsulta(String codigo) throws SQLException {
		User objeto = null;

		try {  
			String query = "select guid, nome, login from user where guid = ?";
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, codigo);
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				objeto = new User(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar category");  
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

	@Override
	public User AlterarSenha(User objeto) {
		try {  

			String query = "update user set senha = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getSenha());
			ps.setString(2, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar advertiser");  
			objeto.adicionarMensagem("Erro ao alterar advertiser");
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

	@Override
	public User Login(User objeto) {
		try {  
			String query = "select guid, nome, login from user where login = ? and senha = ?";
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getLogin());
			ps.setString(2, objeto.getSenha());
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				objeto = new User(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar category");  
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


