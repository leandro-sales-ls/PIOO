package repositorios;

import domain.User;

public interface UsuarioRepositorio extends RepositorioBase<User> {

	User AlterarSenha(User objeto);
	User Login(User objeto);
	
}
