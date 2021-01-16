package com.mamutawah.store.repositories;

import java.util.List;

import com.mamutawah.store.models.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

  List<Category> findAll();

}
