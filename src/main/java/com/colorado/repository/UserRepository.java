package com.colorado.repository;

import com.colorado.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by colorado on 12/03/17.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}
