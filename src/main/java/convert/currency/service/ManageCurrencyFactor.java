package convert.currency.service;

import javax.persistence.Entity;
import javax.persistence.Id;

 @Entity
public class ManageCurrencyFactor {
 
 @Id
 private String currency;
 private double factor;
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}



public double getFactor() {
	return factor;
}
public void setFactor(double factor) {
	this.factor = factor;
}
@Override
public String toString() {
	return "ManageCurrecyFactor [currency=" + currency + ", factor=" + factor + "]";
}



}
