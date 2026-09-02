package sistemabancario;

import static org.hamcrest.CoreMatchers.*;	//inserido manualmente

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadorasContasTeste1 {

	//1° - tem que ter a referencia de qual classe quer fazer o teste
	private GerenciadoraContas gerContas;
	
	//fazendo metodo de teste
	@Test
	public void testeTransfereValor() {
		//Montando o cenario (1a fase)
		int idConta01= 1;
		int idConta02 =2;
		
		ContaCorrente conta01 = new ContaCorrente(idConta01, 200, true);
		ContaCorrente conta02 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		//adicionar as duas contas de teste
		contaDoBanco.add(conta01);
		contaDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		
		//Execução da regra de negocio selecionada para teste (2a fase)
		boolean sucesso = gerContas.transfereValor(idConta01, 50, idConta02); //a conta01 tem 200 e estara transferindo 50 para conta02 - retornara true ou false
		
		//Verificações e análises (3a fase)
		assertThat(sucesso, is(true)); // ou assertTrue(sucesso)  --- completude
		assertThat(conta01.getSaldo(), is(150.0)); // verificando o saldo da conta01
		assertThat(conta02.getSaldo(), is(50.0));  // verificando o saldo da conta02
		
		
	}
	
	@Test
	public void testeTransfereValorAMais() {
		
		//referencia
		GerenciadoraContas gerenContas;
		
		//1a fase -- montagem do cenario
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente c1 = new ContaCorrente(idConta01, 100, true);
		ContaCorrente c2 = new ContaCorrente(idConta02, 0, true);	
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(c1);
		contaDoBanco.add(c2);
		
		gerenContas = new GerenciadoraContas(contaDoBanco);
		
		//2a fase - execução do teste
		boolean sucess = gerenContas.transfereValor(idConta01, 200, idConta02);
		
		//3a fase - Verificações e análises 
		assertThat(sucess, is(true)); // ou assertTrue(sucess)
		assertThat(c1.getSaldo(), is(-100.0)); 
		assertThat(c2.getSaldo(), is(200.0)); 
		
	}
	
	@Test
	public void testeTransfereValorNegativo() {
		GerenciadoraContas gerContas;
		
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente c1 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente c2 = new ContaCorrente(idConta02, 0, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(c1);
		contaDoBanco.add(c2);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		assertThat(sucesso, is(true)); // ou assertTrue(sucess)
		assertThat(c1.getSaldo(), is(-300.0)); 
		assertThat(c2.getSaldo(), is(200.0));
		
	}
	
	@Test
	public void testeTransfereValorNegativoComSaldoNegativo() {
		GerenciadoraContas gerContas;
		
		int idConta01 = 1;
		int idConta02 = 2;
		
		ContaCorrente c1 = new ContaCorrente(idConta01, -100, true);
		ContaCorrente c2 = new ContaCorrente(idConta02, -100, true);
		
		List<ContaCorrente> contaDoBanco = new ArrayList<>();
		contaDoBanco.add(c1);
		contaDoBanco.add(c2);
		
		gerContas = new GerenciadoraContas(contaDoBanco);
		
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		assertThat(sucesso, is(true)); // ou assertTrue(sucess)
		assertThat(c1.getSaldo(), is(-300.0)); 
		assertThat(c2.getSaldo(), is(100.0));
	}
	
}
