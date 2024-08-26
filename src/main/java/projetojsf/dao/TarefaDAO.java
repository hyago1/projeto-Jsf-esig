package projetojsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projetojsf.model.tarefaModel;

import projetojsf.model.tarefaModel;

public class TarefaDAO {

	public Connection GetConnection() throws SQLException {
		Connection conexao = null;
		try {
			Class.forName("org.postgresql.Driver");
			conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;

	}
	
	

	public List<tarefaModel> getTarefas() throws SQLException {

		List<tarefaModel> tarefas = new ArrayList<>();

		String sql = "SELECT numero, titulo, responsavel, descricao , concluida FROM tarefas";
		PreparedStatement statement = GetConnection().prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int numero = resultSet.getInt("numero");
			String titulo = resultSet.getString("titulo");
			String responsavel = resultSet.getString("responsavel");
			String descricao = resultSet.getString("descricao");
			String concluida = resultSet.getString("concluida");
			tarefas.add(new tarefaModel(numero, titulo, responsavel, descricao, concluida));
		}
		return tarefas;

	}
	
	
	public void excluir(int numero) {

System.out.println("DELETE ------------------");
		try {

			if (GetConnection() != null && !GetConnection().isClosed()) {
				System.out.println("Conectado ao banco de dados!");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				PreparedStatement pstm = GetConnection().prepareStatement(
						"delete from tarefas where numero =  ?");

System.out.println("DELETE ------------------");
				pstm.setInt(1, numero);
			

				ResultSet rs = pstm.executeQuery();
			
				rs.close();
				pstm.close();
				GetConnection().close();

			} else {
				

System.out.println("DELETE ------------------");
				System.out.println("Não foi possível conectar ao banco de dados: 00000000000000000000000000000");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void concluir(int numero) {

System.out.println("DELETE ------------------");
		try {

			if (GetConnection() != null && !GetConnection().isClosed()) {
				System.out.println("Conectado ao banco de dados!");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				PreparedStatement pstm = GetConnection().prepareStatement( 
						"update tarefas set concluida = 'true' where numero = ?;");

System.out.println("update ------------------");
				pstm.setInt(1, numero);
			

				ResultSet rs = pstm.executeQuery();
			
				rs.close();
				pstm.close();
				GetConnection().close();

			} else {
				

				System.out.println("Não foi possível conectar ao banco de dados: 00000000000000000000000000000");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
 	public void salvar(String titulo, String descricao, String responsavel, String prioridade, Date data) {
		System.out.println("Inicio PostgreSQLMySQL");
		try {

			if (GetConnection() != null && !GetConnection().isClosed()) {
				System.out.println("Conectado ao banco de dados!");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				PreparedStatement pstm = GetConnection().prepareStatement(
						"INSERT INTO tarefas (titulo, descricao, responsavel, prioridade, data) VALUES (?, ?, ?, ?, ?)");
				java.sql.Date sqlDate = new java.sql.Date(data.getTime());

				pstm.setString(1, titulo);
				pstm.setString(2, descricao);
				pstm.setString(3, responsavel);
				pstm.setString(4, prioridade);
				pstm.setDate(5, sqlDate);

				ResultSet rs = pstm.executeQuery();
				while (rs.next()) {
					System.out.println(": " + rs.getString("titulo"));
				}
				rs.close();
				pstm.close();
				GetConnection().close();
				
				

			} else {
				System.out.println("Não foi possível conectar ao banco de dados: 00000000000000000000000000000");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
				System.out.println("Não foi possível conectar ao banco de dados. *********************");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fim PostgreSQLMySQL");
	}



 	public List<tarefaModel> buscarTarefas() throws SQLException{
 		List<tarefaModel> tarefas = new ArrayList<>();

		String sql = "SELECT numero, titulo, responsavel, descricao , concluida FROM tarefas";
		PreparedStatement statement = GetConnection().prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int numero = resultSet.getInt("numero");
			String titulo = resultSet.getString("titulo");
			String responsavel = resultSet.getString("responsavel");
			String descricao = resultSet.getString("descricao");
			String concluida = resultSet.getString("concluida");
			tarefas.add(new tarefaModel(numero, titulo, responsavel, descricao, concluida));
		}
		

		return tarefas;
		
	}
 		
 	




}
