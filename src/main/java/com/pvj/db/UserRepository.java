package com.pvj.db;  
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pvj.model.User;  
//repository that extends CrudRepository  

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  
{  
}  