package com.mamutawah.store.repositories;

import java.util.List;

import com.mamutawah.store.models.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

  List<Product> findAll();

}
