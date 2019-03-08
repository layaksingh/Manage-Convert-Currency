package convert.currency.dao;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;

import convert.currency.service.ManageCurrencyFactor;
public interface CurrenncyRepo extends CrudRepository<ManageCurrencyFactor, String>{
	
	ManageCurrencyFactor findBycurrency(String currency);

}
