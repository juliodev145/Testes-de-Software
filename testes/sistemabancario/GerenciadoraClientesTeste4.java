package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais
 * operações sobre cliente realizadas pela classe {@link GerenciadoraClientes}
 * @author julio.pinto
 * @date 26/08/2026
 */

public class GerenciadoraClientesTeste4 { //testando os metodos testPesquisaCliente() e testRemoveCliente()
	
	private GerenciadoraClientes gerClientes;
	
	int idCliente01 = 1;	//feito para facilitar na manutencao
	int idCliente02 = 2;
	
	
	//Metodo de testes
	@Before		//before - cria o cenario
	public void setUp() {
		Cliente cliente1 = new Cliente(idCliente01, "Jarbas", 45, "jarbas@email.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "Lucas", 18, "lucas@email.com", 2, true);
		
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}	
		
	//Metodo de testes
	@After	//limpa o cenario
	public void tearDown() {	//esvazia a lista a cada teste
		//desmontagem/limpeza do cenario global
		gerClientes.limpa();
	}
	
	@Test  //annotation para chamada da biblioteca (@Te + ctrl + espaço)
	public void testPesquisaCliente(){	//para metodos o 'test' vem na frente
		
		//---------------1a fase: MONTAGEM DO CENARIO-------------------------------
		//Montagem do cenário construida pelo metodo setUp automaticamente por causa do @Before
		
		
		
		//---------------------2a fase: EXECUÇÃO DO TESTE---------------------
		Cliente clienteRetorno = gerClientes.pesquisaCliente(idCliente01);
		
		
		
		//-----------------3a fase: AVALIAÇÃO E ANÁLISE-----------------------
		// ideal é testar com todos os argumentos
		assertThat(clienteRetorno.getId(), is(1));	//precisa ter o: import static org.hamcrest.CoreMatchers.*;
		assertThat(clienteRetorno.getNome(), is("Jarbas"));
		
	}
	
	@Test
	public void testPesquisaClienteInexistente() {
		
		//---------------1a fase: MONTAGEM DO CENARIO-------------------------------
		//Montagem do cenário construida pelo metodo setUp automaticamente por causa do @Before
		
		
		
		//---------------------2a fase: EXECUÇÃO DO TESTE---------------------
		Cliente clienteRetorno = gerClientes.pesquisaCliente(40);
		
		
		
		//-----------------3a fase: AVALIAÇÃO E ANÁLISE-----------------------
		// ideal é testar com todos os argumentos
		assertNull(clienteRetorno);
		
		
	}
	
	
	
	@Test  
	public void testRemoveCliente(){	//para metodos o 'test' vem na frente
		
		//---------------1a fase: MONTAGEM DO CENARIO-------------------------------
		//Montagem do cenário construida pelo metodo setUp automaticamente por causa do @Before
		
		
		
		//-------------------2a fase: EXECUÇÃO DO TESTE---------------------------
		boolean resultadoRetorno = gerClientes.removeCliente(idCliente01);
		
		
		
		//----------------------3a fase: AVALIAÇÃO E ANÁLISE--------------------------
		assertThat(resultadoRetorno, is(true)); 
		assertThat(gerClientes.getClientesDoBanco().size(), is(1)); 
		assertThat(gerClientes.pesquisaCliente(idCliente02).getId(), is(2)); 
		assertNull(gerClientes.pesquisaCliente(idCliente01));	
	
	}
	
	@Test
	public void testRemoveClienteInexistente() {
		//---------------1a fase: MONTAGEM DO CENARIO-------------------------------
		//Montagem do cenário construida pelo metodo setUp automaticamente por causa do @Before
		
		
		
		//-------------------2a fase: EXECUÇÃO DO TESTE---------------------------
		boolean resultadoRetorno = gerClientes.removeCliente(40);
		
		
		
		//----------------------3a fase: AVALIAÇÃO E ANÁLISE--------------------------
		//assertFalse(resultadoRetorno); == assertThat(resultadoRetorno, is(false));
		
		assertThat(resultadoRetorno, is(false)); // o resultado tem que ser falso pois o id nao existe 
		assertThat(gerClientes.getClientesDoBanco().size(), is(2)); //pois tem 2 id's de clietes, o id 40 nao existe
		assertNull(gerClientes.pesquisaCliente(40));	//ao pesquisar id 40, da null pois foi ele que foi removido
	}
	
}
