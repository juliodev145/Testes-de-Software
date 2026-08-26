package sistemabancario;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais
 * operações sobre cliente realizadas pela classe {@link GerenciadoraClientes}
 * @author julio.pinto
 * @date 26/08/2026
 */

// para classe o 'test' vai no final
public class GerenciadoraClientesTeste2 { //testando os metodos testPesquisaCliente() e testRemoveCliente()

	private GerenciadoraClientes gerClientes; //criado a referencia, falta instanciar
	
	@Test  //annotation para chamada da biblioteca (@Te + ctrl + espaço)
	public void testPesquisaCliente(){	//para metodos o 'test' vem na frente
		
		//1a fase: MONTAGEM DO CENARIO
		//criar clientes na memória
		int idCliente01 = 1;	//feito para facilitar na manutencao
		int idCliente02 = 2;
		Cliente cliente1 = new Cliente(idCliente01, "Jarbas", 45, "jarbas@email.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "Lucas", 18, "lucas@email.com", 2, true);
		
		//criando a lista
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		//inserindo os clientes criados na lista de clientes no banco
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		//instanciando 
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//2a fase: EXECUÇÃO DO TESTE
		Cliente clienteRetorno = gerClientes.pesquisaCliente(idCliente01);
		
		//3a fase: AVALIAÇÃO E ANÁLISE
		// ideal é testar com todos os argumentos
		assertThat(clienteRetorno.getId(), is(idCliente01));	//precisa ter o: import static org.hamcrest.CoreMatchers.*;
		assertThat(clienteRetorno.getNome(), is("Jarbas"));
		
	}
	
	@Test  //annotation para chamada da biblioteca (@Te + ctrl + espaço)
	public void testRemoveCliente(){	//para metodos o 'test' vem na frente
		
		//1a fase: MONTAGEM DO CENARIO
		//criar clientes na memória
		
		int idCliente01 = 1;	//feito para facilitar na manutencao
		int idCliente02 = 2;
		
		Cliente cliente1 = new Cliente(idCliente01, "Jarbas", 45, "jarbas@email.com", 1, true);
		Cliente cliente2 = new Cliente(idCliente02, "Lucas", 18, "lucas@email.com", 2, true);
		
		//criando a lista
		List<Cliente> clientesDoBanco = new ArrayList<Cliente>();
		//inserindo os clientes criados na lista de clientes no banco
		clientesDoBanco.add(cliente1);
		clientesDoBanco.add(cliente2);
		
		//instanciando 
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		//2a fase: EXECUÇÃO DO TESTE
		boolean resultadoRetorno = gerClientes.removeCliente(idCliente01);
		
		//3a fase: AVALIAÇÃO E ANÁLISE
		assertThat(resultadoRetorno, is(true)); //testar se o retorno da true ou false
		assertThat(gerClientes.getClientesDoBanco().size(), is(1)); //2-1 = 1
		assertThat(gerClientes.pesquisaCliente(idCliente02).getId(), is(2)); // pesquisa por id 2 e da 2 (is(2))
		assertNull(gerClientes.pesquisaCliente(idCliente01));	//ao pesquisar id 1, da null pois foi ele que foi removido
	
	}
}
