package tests.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Account;
import testes.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {

		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		acc.deposit(amount);

		assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;

		acc.deposit(amount);

		assertEquals(expectedValue, acc.getBalance());

	}

	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

		double expectedValue = 0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithdraw();

		assertTrue(expectedValue == acc.getBalance());
		assertTrue(result == initialBalance);
	}

	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

		Account acc = AccountFactory.createAccount(800.00);

		acc.withdraw(500.0);

		assertEquals(300.0, acc.getBalance());
	}

	@Test
	public void withdrawShouldThrowExceptionWhenSufficientBalance() {

		assertThrows(IllegalArgumentException.class, () -> {

			Account acc = AccountFactory.createAccount(800.00);

			acc.withdraw(801.0);
		});
	}
}
