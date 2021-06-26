package com.pvj.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pvj.model.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{

}
