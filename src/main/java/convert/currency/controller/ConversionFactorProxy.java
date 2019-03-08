package convert.currency.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway")
@RibbonClient(name = "conversionfactor")
public interface ConversionFactorProxy {
	@GetMapping("/conversionfactor/{countryCode}")
	public ResponseEntity<Response> getConversionFactor(@PathVariable(name="countryCode") String countryCode);
}