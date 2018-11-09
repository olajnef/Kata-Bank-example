package kataBankTest;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import kataBankClasses.Account;
import kataBankClasses.Account.Operation;
import kataBankClasses.Client;

public class KataBankTest {
	private Account accountForDeposit;
	private Account accountForWithDraw;
	private Client client;

	@Before
	public void setUp() throws Exception {
		client = new Client();
		client.setName("Toto");
		accountForDeposit = new Account(client,50,100,LocalDate.now(),Operation.deposit);
		accountForWithDraw = new Account(client,50,100,LocalDate.now(),Operation.withdraw);

	}
	
	@Test
	public void account_operation_type_should_be_deposit_when_we_call_deposit_service(){
		
		long currentBalance=accountForWithDraw.deposit(accountForWithDraw.getAmount(), accountForWithDraw.getBalance());
		assertEquals("the operation is not a deposit",currentBalance,accountForWithDraw.getBalance());
	}

	@Test
	public void should_deposit_positif_amount() {
	long currentBalance = accountForDeposit.deposit(accountForDeposit.getAmount(),accountForDeposit.getBalance());
	assertEquals(accountForDeposit.getAmount()+accountForDeposit.getBalance(), currentBalance);
	}
	
	@Test(expected=IllegalStateException.class) 
	public void should_not_deposit_negatif_amount(){
		accountForDeposit.deposit(-50, accountForDeposit.getBalance());
		
	}
	

}
