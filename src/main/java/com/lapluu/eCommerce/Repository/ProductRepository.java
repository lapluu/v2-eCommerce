package com.lapluu.eCommerce.Repository;

import com.lapluu.eCommerce.Model.Product;
import com.lapluu.eCommerce.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
