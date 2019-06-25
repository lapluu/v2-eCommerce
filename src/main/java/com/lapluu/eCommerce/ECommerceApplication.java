package com.lapluu.eCommerce;

import com.lapluu.eCommerce.Model.*;
import com.lapluu.eCommerce.Repository.ProductRepository;
import com.lapluu.eCommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);

	}
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	private void init(){

		// Mary Smith
	User userMary = new User( "MaryS77", "MarySmith@gmail.com", "JS77",
		"Active", new Profile("Smith", "Mary", Profile.Gender.FEMALE),
			new Address("795 E DRAGRAM", "TUCSON", "AZ", "85705",
					"USA", Address.AddressType.HOME));
		this.userRepository.save(userMary);

		User userJohn = new User( "JohnS88", "JohnSmith@gmail.com", "JS88",
				"Active", new Profile("Smith", "John", Profile.Gender.MALE), null);
		this.userRepository.save(userJohn);

		User userMichelle = new User( "MichelleObama99", "michelleObama@gmail.com", "obama99",
				"Active", null, new Address("300 BOYLSTON AVE E", "SEATTLE", "WA", "98102",
				"USA", Address.AddressType.SHIPPING));
		this.userRepository.save(userMichelle);
		// Products
		Product chair = new Product("Lawn Chair", "Cotagge wooden chair", "RED",
				"Large", 99.67, Product.ProductStatus.AVAILABLE, 100,
				new Category("Yard and garden ", "Furniture"," N/A"));
		this.productRepository.save(chair);

		Product iphone8 = new Product("Iphone 8", "Apple Iphone 8", "GOLD",
				"six inch", 999.67, Product.ProductStatus.AVAILABLE, 80,
				new Category("Electronic", "Cellphone"," N/A"));
		this.productRepository.save(iphone8);


	}


}
