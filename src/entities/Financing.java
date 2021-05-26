package entities;

public class Financing {
	
	private Double totalAmount;
	private Double income;
	private Integer months;
	
	public Financing() {		
	}
	
	public Financing(Double totalAmount, Double income, Integer months) {
		
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
		
		if(quota() > income / 2)
			throw new IllegalArgumentException("The income should be bigger then quota");
	}

	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Double totalAmount) {
		if(((totalAmount - (totalAmount * 0.02)) / months) > income / 2)
			throw new IllegalArgumentException("The income should be bigger then quota");
		
		this.totalAmount = totalAmount;
	}
	
	public Double getIncome() {
		return income;
	}
	
	public void setIncome(Double income) {
		if(quota() > income / 2)
			throw new IllegalArgumentException("The income should be bigger then quota");
		
		this.income = income;
	}
	
	public Integer getMonths() {
		return months;
	}
	
	public void setMonths(Integer months) {
		if(((totalAmount - entry()) / months) > income / 2)
			throw new IllegalArgumentException("The income should be bigger then quota");
		
		this.months = months;
	}
	
	public double entry() {
		return totalAmount * 0.02;
	}
	
	public double quota() {		
		return (totalAmount - entry()) / months;
	}
}
