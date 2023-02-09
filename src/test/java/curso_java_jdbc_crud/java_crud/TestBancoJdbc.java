package curso_java_jdbc_crud.java_crud;

import java.util.List;

import org.junit.Test;

import dao.UserPosDao;
import model.Telefone;
import model.Userposjava;

public class TestBancoJdbc{
	
	@Test
	public void initBanco(){
		UserPosDao dao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("Ana Clara");
		userposjava.setEmail("teste@gmail.com");
		
		dao.salvar(userposjava);
	}
	
	@Test
	public void initListar(){
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();
			
			for(Userposjava userposjava : list){
				System.out.println(userposjava);
				System.out.println("--------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void initBuscar(){
		UserPosDao dao = new UserPosDao();
		try {
			Userposjava userposjava = dao.buscar(3L);
			System.out.println(userposjava);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void initAtualizar(){
		UserPosDao dao = new UserPosDao();
		try {
			Userposjava objBanco = dao.buscar(1L);
			objBanco.setNome("Nome mudado com metodo atualizar");
			dao.atualizar(objBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void initDeletar(){
		try {
			UserPosDao dao = new UserPosDao();
			dao.deletar(5l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInsertTelefone(){
		Telefone telefone = new Telefone();
		telefone.setNumero("11 4973-4843");
		telefone.setTipo("Casa");
		telefone.setUsuario(7L);
		
		UserPosDao dao = new UserPosDao();
		dao.salvarTelefone(telefone);
	}
}
