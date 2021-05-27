package tests.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import entities.Financing;
import testes.factory.FinancingFactory;

public class FinancingTests {
	
	
	@Test
	public void entryShouldBeTwentyPercentOfTotalAmount() {

		Double expectedValue = 200.0;
		Double totalAmount = 10000.0;
		Financing fin = FinancingFactory.createFinancing(totalAmount, 1500.0, 24);

		Double entry = fin.entry();

		assertEquals(expectedValue,entry);
	}

	@Test
	public void quotaShouldBeRemainingEightyPercentOfTotalAmountDividedByMonths() {

		Double expectedValue = 4900.0;
		Double totalAmount = 50000.0;
		Integer months = 10;

		Financing fin = FinancingFactory.createFinancing(totalAmount, 10000.0, months);

		Double quota = fin.quota();

		assertEquals(expectedValue,quota);

	}

	@Test
	public void constructorShouldThrowExceptionWhenQuoteBiggerThenIncome() {

		assertThrows(IllegalArgumentException.class, () -> {

			Financing fin = FinancingFactory.createFinancing(20000.0, 500.0, 14);
		});

	}

	@Test
	public void constructorShouldSetAllAtributesWhenQuoteSmallerThenIncome() {

		Double expectedTotalAmount = 10000.0;
		Double expectedIncome = 1000.0;
		Integer expectedMonths = 24;

		Financing fin = FinancingFactory.createFinancing(expectedTotalAmount, expectedIncome, expectedMonths);

		assertEquals(expectedTotalAmount, fin.getTotalAmount());
		assertEquals(expectedIncome, fin.getIncome());
		assertEquals(expectedMonths, fin.getMonths());

	}
	
	@Test
	public void setTotalAmountShouldThrowExceptionWhenQuoteBiggerThenIncome() {
		
		assertThrows(IllegalArgumentException.class, () -> {

			Financing fin = FinancingFactory.createFinancing(20000.0, 5000.0, 10);
			fin.setTotalAmount(50000.0);
		});
	}
	
	@Test
	public void setTotalAmountShouldSetTotalAmountAtributeWhenSmallerThenIncome() {
	
		Financing fin = FinancingFactory.createFinancing(10000.0,7000.0,12);
		fin.setTotalAmount(40000.0);
		
		assertEquals(40000.0, fin.getTotalAmount());
			
	}
	
	@Test
	public void setIncomeShouldThrowExceptionWhenQuoteBiggerThenIncome() {
		
		assertThrows(IllegalArgumentException.class, () -> {

			Financing fin = FinancingFactory.createFinancing(20000.0, 5000.0, 10);
			fin.setIncome(1000.0);
		});
	}
	
	@Test
	public void setIncomeAmountShouldSetIncomeAtributeWhenSmallerThenIncome() {
	
		Financing fin = FinancingFactory.createFinancing(5000.0,1000.0,10);
		fin.setIncome(2000.0);
		
		assertEquals(2000.0, fin.getIncome());
			
	}

	@Test
	public void setMonthsShouldThrowExceptionWhenQuoteBiggerThenIncome() {
		
		assertThrows(IllegalArgumentException.class, () -> {

			Financing fin = FinancingFactory.createFinancing(20000.0, 5000.0, 10);
			fin.setMonths(5);
		});
	}
	
	@Test
	public void setMonthsShouldSetMonthsAtributeWhenSmallerThenIncome() {
	
		Financing fin = FinancingFactory.createFinancing(5000.0,1000.0,10);
		fin.setMonths(15);
		
		assertEquals(15, fin.getMonths());
			
	}


}
