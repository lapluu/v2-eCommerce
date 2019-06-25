package com.lapluu.eCommerce;

import com.lapluu.eCommerce.Model.Category;
import com.lapluu.eCommerce.Model.Product;
import com.lapluu.eCommerce.Model.Profile;
import com.lapluu.eCommerce.Model.User;
import com.lapluu.eCommerce.Repository.ProductRepository;
import com.lapluu.eCommerce.Repository.UserRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ECommerceApplicationTests {

	final static Logger logger = Logger.getLogger(ECommerceApplicationTests.class);
    @Autowired
	UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
//	@Test
	public void contextLoads() {
	}
	@Test
	public void addUserRepositoryTest(){
		for (User user : userRepository.findAll()) {
		    Profile profile= user.getProfile();

            logger.info("Hello " + ( profile != null ? profile.toString(): " Null"));
			logger.info("Hello " + user.toString());
		}
	}
	@Test
	public void addProductRepositoryTest(){
		for (Product product : productRepository.findAll()) {
			Category category= product.getCategory();
			logger.info("Category : " + ( category != null ? category.toString(): "Null"));
			logger.info("Product : " + product.toString());
		}
	}

}
