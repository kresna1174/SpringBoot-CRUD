package net.javadev.crud;

import net.javadev.crud.model.Product;
import net.javadev.crud.repository.EmployeeRepository;
import net.javadev.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.javadev.crud.model.employee;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

//	@Autowired
//	private ProductRepository productRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setProductName("PROMAG");
//		product.setStock("2929299");
//		product.setSupplier("kresna");
//		productRepository.save(product);
//	}

//	@Autowired
//	private EmployeeRepository employeeRepository;
//	@Override
//	public void run(String... args) throws Exception {
//		employee employee = new employee();
//		employee.setFirstName("Kresna");
//		employee.setLastName("Cahyono");
//		employee.setEmailId("KresnaCahyono7@gmail.com");
//		employeeRepository.save(employee);
//	}
}