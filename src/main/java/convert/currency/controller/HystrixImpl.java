package convert.currency.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Component
public class HystrixImpl {
	@Autowired
	ConversionFactorProxy proxy;

	@HystrixCommand(fallbackMethod="fallbackConvertCurrency")
	public  ResponseEntity<Response> convertCurrency(String countryCode,Double amount) {
		Response rsp=new Response();
		try {
			Response cFactor=proxy.getConversionFactor(countryCode).getBody();
			System.err.println("cFactor : "+cFactor.toString());
			if(cFactor.getStatus()==200) {
				Double convertedValue=amount*cFactor.getFactorValue();
				rsp.setConvertedValue(convertedValue);
				System.out.println("SUCCESS : "+cFactor.getFactorValue());
			}
			rsp.setFactorValue(cFactor.getFactorValue());
			rsp.setError(cFactor.getError());
			rsp.setMessage(cFactor.getMessage());
			rsp.setStatus(cFactor.getStatus());
		}catch(Exception e) {
			//throw new RuntimeException();
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(rsp);
	}

	public ResponseEntity<Response> fallbackConvertCurrency(String countryCode,Double amount) {
		Response rsp=new Response();
		rsp.setFactorValue(null);
		rsp.setError("Service temporary unavailable!");
		rsp.setMessage("Service is not available,Please try again after some time!");
		rsp.setStatus(400);

		return ResponseEntity.ok().body(rsp);
	}
}