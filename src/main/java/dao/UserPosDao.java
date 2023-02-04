package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDao {

	private Connection connection;

	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userposjava) {
		try {
			String sql = "insert into userposjava(nome, email) values (?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);// onde insert
			 // utilizando os get's para // inserir de forma dinamica
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit(); // salva no banco

		} catch (SQLException e) {
			try {
				connection.rollback(); // reverte operação
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(result.getLong("id"));
			userposjava.setNome(result.getString("nome"));
			userposjava.setEmail(result.getString("email"));

			list.add(userposjava);
		}
		return list;
	}

	// consultar o objeto
	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();

		String sql = "select * from userposjava where id = " + id;
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) { // return only one or nothing
			retorno.setId(result.getLong("id"));
			retorno.setNome(result.getString("nome"));
			retorno.setEmail(result.getString("email"));

		}
		return retorno;
	}

	public void atualizar(Userposjava userposjava) {
		try {
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			statement.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
