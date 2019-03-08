package convert.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import convert.currency.dao.CurrenncyRepo;
import convert.currency.service.ConvertRequestBuilder;
import convert.currency.service.ConvertedCurrency;
import convert.currency.service.ManageCurrencyFactor;

@RestController
public class ConvertCurrencyController {

	
	
	@Autowired
	HystrixImpl hystrixImpl;
	/**
	 * 
	 * @param currencycode
	 * @param amount
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST,  value="/convertCurrency")
	@ResponseBody
	public ConvertedCurrency convertCurrency(@PathVariable(name = "countryCode") String countryCode, @PathVariable(name = "amount") Double amount  ){
		
		ConvertedCurrency convertedCurrency=new ConvertedCurrency();
		try {
			hystrixImpl.convertCurrency(countryCode, amount);
		
				
			
		} catch (Exception e) {
		
		e.printStackTrace();
		
		}
		
		return convertedCurrency;
	}
	
}
