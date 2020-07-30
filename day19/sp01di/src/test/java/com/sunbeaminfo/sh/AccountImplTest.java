package com.sunbeaminfo.sh;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:bank.properties")
@ComponentScan(basePackages = {"com.sunbeam.sh", "com.sunbeaminfo.sh"})
@SpringBootTest
class AccountImplTest {
	@Autowired
	private Account acc;
	
	@Test
	void testDeposit() {
		acc.setBalance(10000);
		acc.deposit(1000);
		assertTrue(acc.getBalance() == 11000);
	}

	@Test
	void testWithdraw() {
		acc.setBalance(10000);
		acc.withdraw(1000);
		assertTrue(acc.getBalance() == 9000);
	}

	@Test
	void testWithdrawException() {
//		fail("Not yet implemented");
		acc.setBalance(1000);
		assertThrows(RuntimeException.class, () -> {
			acc.withdraw(2000);
		});
	}
}
