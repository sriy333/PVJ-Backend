package com.pvj.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pvj.model.Item;

@Repository
@Transactional
public interface ItemRepository extends CrudRepository<Item, Integer>{

}
