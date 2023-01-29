package curso_java_jdbc_crud.java_crud;

import org.junit.Test;

import dao.UserPosDao;
import model.Userposjava;

public class TestBancoJdbc{
	
	@Test
	public void initBanco(){
		UserPosDao userposdao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(3L);
		userposjava.setNome("Ana Clara");
		userposjava.setEmail("teste@gmail.com");
		
		userposdao.salvar(userposjava);
	}
}
