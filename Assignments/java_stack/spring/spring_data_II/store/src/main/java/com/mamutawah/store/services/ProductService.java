package com.mamutawah.store.services;

import java.util.List;

import com.mamutawah.store.models.Category;
import com.mamutawah.store.models.Product;
import com.mamutawah.store.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product create(Product product) {
    return productRepository.save(product);
  }

  public List<Product> getAll() {
    return productRepository.findAll();
  }

  public Product getOne(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  public void addCategory(Product product, Category category) {
    Product p = productRepository.findById(product.getId()).orElse(null);
    if (p != null) {
      List<Category> tempCat = p.getCategories();
      if (tempCat.contains(category)) {
        System.out.println("it is here before =).");
      } else {
        tempCat.add(category);
        p.setCategories(tempCat);
        productRepository.save(p);
      }

    }
  }

  public List<Product> getAllFiltered(List<Product> products) {
    List<Product> allProducts = this.getAll();
    for (Product product : products) {
      if (allProducts.contains(product)) {
        allProducts.remove(product);
      }
    }
    return allProducts;
  }
}
