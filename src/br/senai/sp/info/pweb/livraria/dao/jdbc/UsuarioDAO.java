package br.senai.sp.info.pweb.livraria.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	@Override
	public Usuario buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Usuario obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Usuario obj) {
		// TODO Auto-generated method stub
		
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
