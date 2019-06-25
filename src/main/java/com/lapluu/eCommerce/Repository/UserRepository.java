package com.lapluu.eCommerce.Repository;

import com.lapluu.eCommerce.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
