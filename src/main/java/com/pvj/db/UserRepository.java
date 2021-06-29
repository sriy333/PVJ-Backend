package com.pvj.db;  
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pvj.model.User;  
//repository that extends CrudRepository  

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer>  
{  
}  