package com.mamutawah.store.services;

import java.util.List;

import com.mamutawah.store.models.Category;
import com.mamutawah.store.models.Product;
import com.mamutawah.store.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Category create(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  public List<Category> getAllFiltered(List<Category> categories) {
    List<Category> allCategories = this.getAll();
    for (Category category : categories) {
      if (allCategories.contains(category)) {
        allCategories.remove(category);
      }
    }
    return allCategories;
  }

  public Category getOne(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }

  public void addProduct(Product product, Category category) {
    Category c = categoryRepository.findById(category.getId()).orElse(null);
    if (c != null) {
      List<Product> tempProduct = c.getProducts();
      if (tempProduct.contains(product)) {
        System.out.println("It is here!");
      } else {
        tempProduct.add(product);
        c.setProducts(tempProduct);
        categoryRepository.save(c);
      }
    }
  }
}
