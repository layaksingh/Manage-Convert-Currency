package convert.currency.service;


public class ConvertedCurrency {
	
	private double convertedAmount;
	
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	@Override
	public String toString() {
		return "ConvertCurrencyModel [convertedAmount=" + convertedAmount + "]";
	}
	
	

}
