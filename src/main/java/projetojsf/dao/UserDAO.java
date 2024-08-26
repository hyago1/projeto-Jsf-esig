package projetojsf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.context.FacesContext;

public class UserDAO {

	
	
	public Connection GetConnection() throws SQLException {
		Connection conexao = null;
		try {
			Class.forName("org.postgresql.Driver");
			 conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "postgres",
				"root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
		
	}
	
	public boolean isTabelaVazia() {
        boolean isVazia = false;

        try  {
            String sql = "SELECT COUNT(*) FROM users";
            PreparedStatement statement = GetConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                isVazia = (count == 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isVazia;
    }

	
	
	public void salvar(String user, String senha) {
		
		
		
		
		
		System.out.println("Inicio PostgreSQLMySQL");
		try {
		
			if (GetConnection() != null && !GetConnection().isClosed()) {
				System.out.println("Conectado ao banco de dados!");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("Conectado ao banco de dados! 11111111111111111111111111");
				System.out.println("");
				System.out.println("");
				System.out.println("");

				PreparedStatement pstmConsulta = GetConnection().prepareStatement("select * from users where usuario = (?) and senha = (?)");
				pstmConsulta.setString(1, user);
				pstmConsulta.setString(2, senha);

				ResultSet rs = pstmConsulta.executeQuery();
System.out.println(isTabelaVazia());
				if(!isTabelaVazia()) {
					while (rs.next()) {
					if (rs.getString("usuario").toString().equals(user)) {
						System.out.println("Usuario Ja existe");
						System.out.println(rs.getString("usuario"));
						FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarTarefa.jsf");

					
						pstmConsulta.close();
					} else {
						System.out.println("Nao existe");
						System.out.println(user);
						System.out.println(rs.getString("usuario"));
						PreparedStatement pstm = GetConnection()
								.prepareStatement("insert INTO users (usuario, senha) values (?, ?)");
						pstm.setString(1, user);
						pstm.setString(2, senha);
						pstm.close();

					}

				}
					
					rs.close();
				}else {
					try {
						PreparedStatement pstm = GetConnection()
							.prepareStatement("insert INTO users (usuario, senha) values (?, ?)");
					pstm.setString(1, user);
					pstm.setString(2, senha);
					pstm.close();
					} catch (Exception e) {
						System.out.println(e);
					}
					
					System.out.println("849654d4ew1dewd1xe14==============================================");
					
				}
				
				

	

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
}
