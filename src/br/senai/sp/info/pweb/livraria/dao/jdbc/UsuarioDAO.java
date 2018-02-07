package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.senai.sp.info.pweb.livraria.dao.DAO;
import br.senai.sp.info.pweb.livraria.models.Usuario;

@Repository
public class UsuarioDAO implements DAO<Usuario>{
	
	private FabricaDeConexoes fabricaDeConexoes;
	
	public UsuarioDAO() {
		fabricaDeConexoes = new FabricaDeConexoes();
	}
	
	public Usuario autenticar(Usuario usuario) {
		String sql = "SELECT id, nome, sobrenome, dt_nascimento FROM usuario WHERE email = ? AND senha = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			//Obtendo o resultado da busca
			ResultSet resultados = stmt.executeQuery();
			
			Usuario usuarioAutenticado = null;
			if(resultados.next()) {
				usuarioAutenticado = new Usuario();
				
				//Dados que vem do banco de dados
				usuarioAutenticado.setId(resultados.getLong("id"));
				usuarioAutenticado.setDataNascimento(resultados.getDate("dt_nascimento"));
				usuarioAutenticado.setNome(resultados.getString("nome"));
				usuarioAutenticado.setSobrenome(resultados.getString("sobrenome"));
				
				//Dados que vem do objeto
				usuarioAutenticado.setEmail(usuario.getEmail());
				usuarioAutenticado.setSenha(usuario.getSenha());
			}
			resultados.close();
			
			fabricaDeConexoes.fechar();
			
			return usuarioAutenticado;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Usuario buscar(Long id) {
		String sql = "SELECT nome, sobrenome, dt_nascimento, email senha FROM usuario WHERE id = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setLong(1, id);
			
			//Obtendo o resultado da busca
			ResultSet resultados = stmt.executeQuery();
			
			Usuario usuario = null;
			if(resultados.next()) {
				usuario = new Usuario();
				usuario.setId(id);
				usuario.setDataNascimento(resultados.getDate("dt_nascimento"));
				usuario.setEmail(resultados.getString("email"));
				usuario.setNome(resultados.getString("nome"));
				usuario.setSenha(resultados.getString("senha"));
				usuario.setSobrenome(resultados.getString("sobrenome"));
			}
			resultados.close();
			
			fabricaDeConexoes.fechar();
			
			return usuario;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Usuario> buscarTodos() {
		String sql = "SELECT id, nome, sobrenome, dt_nascimento, email senha FROM usuario";
		List<Usuario> usuarios = new LinkedList<>();
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Obtendo o resultado da busca
			ResultSet resultados = stmt.executeQuery();
			
			if(resultados.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultados.getLong("id"));
				usuario.setDataNascimento(resultados.getDate("dt_nascimento"));
				usuario.setEmail(resultados.getString("email"));
				usuario.setNome(resultados.getString("nome"));
				usuario.setSenha(resultados.getString("senha"));
				usuario.setSobrenome(resultados.getString("sobrenome"));
				
				//Adiciona o usuário na lista
				usuarios.add(usuario);
			}
			resultados.close();
			
			fabricaDeConexoes.fechar();
			
			return usuarios;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean emailJaExiste(String email) {
		String sql = "SELECT id FROM usuario WHERE email = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setString(1, email);
			
			//Obtendo o resultado da busca
			ResultSet resultados = stmt.executeQuery();
			boolean existe = false;
			
			if(resultados.next()) {
				existe = true;
			}
			resultados.close();
			
			fabricaDeConexoes.fechar();
			
			return existe;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void alterar(Usuario obj) {
		String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, dt_nascimento = ?, email = ?, senha = ? WHERE id = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getSobrenome());
			stmt.setDate(3, new Date(obj.getDataNascimento().getTime()));
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			stmt.setLong(6, obj.getId());
			
			stmt.execute();
			fabricaDeConexoes.fechar();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deletar(Usuario obj) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setLong(1, obj.getId());
			
			stmt.execute();
			fabricaDeConexoes.fechar();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void persistir(Usuario obj) {	    
		String sql = "INSERT INTO usuario SET nome = ?, sobrenome = ?, dt_nascimento = ?, email = ?, senha = ?";
		
		try 
		{
			fabricaDeConexoes.abrir();
			
			PreparedStatement stmt = fabricaDeConexoes.getConexao().prepareStatement(sql);
			
			//Definindo os parâmetros
			stmt.setString(1, obj.getNome());
			stmt.setString(2, obj.getSobrenome());
			stmt.setDate(3, new Date(obj.getDataNascimento().getTime()));
			stmt.setString(4, obj.getEmail());
			stmt.setString(5, obj.getSenha());
			
			stmt.execute();
			fabricaDeConexoes.fechar();
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
