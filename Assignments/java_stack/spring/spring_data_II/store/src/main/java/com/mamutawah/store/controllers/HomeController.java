package com.mamutawah.store.controllers;

import javax.validation.Valid;

import com.mamutawah.store.models.Category;
import com.mamutawah.store.models.CategoryProduct;
import com.mamutawah.store.models.Product;
import com.mamutawah.store.services.CategoryService;
import com.mamutawah.store.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  private final ProductService productService;
  private final CategoryService categoryService;

  public HomeController(ProductService productService, CategoryService categoryService) {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("categories", categoryService.getAll());
    model.addAttribute("products", productService.getAll());
    return "index.jsp";
  }

  @RequestMapping("/products/new")
  public String createProduct(@ModelAttribute("product") Product product) {
    return "products/new.jsp";
  }

  @RequestMapping(value = "/products/new", method = RequestMethod.POST)
  public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
    if (result.hasErrors()) {
      return "products/new.jsp";
    }
    productService.create(product);
    return "redirect:/";
  }

  @RequestMapping("/categories/new")
  public String createCategory(@ModelAttribute("category") Category category) {
    return "categories/new.jsp";
  }

  @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
  public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
    if (result.hasErrors()) {
      return "categories/new.jsp";
    }
    categoryService.create(category);
    return "redirect:/";
  }

  @RequestMapping("/categories/{id}")
  public String viewCategory(@ModelAttribute("category_product") CategoryProduct category_product, Model model,
      @PathVariable("id") Long id) {

    Category cat = categoryService.getOne(id);
    model.addAttribute("category", cat);
    model.addAttribute("products", productService.getAllFiltered(cat.getProducts()));
    return "categories/view.jsp";
  }

  @RequestMapping(value = "/categories/{id}", method = RequestMethod.POST)
  public String addProduct(@Valid @ModelAttribute("category_product") CategoryProduct category_product,
      BindingResult result, @PathVariable("id") Long id) {
    if (result.hasErrors()) {
      return "categories/view.jsp";
    }
    categoryService.addProduct(category_product.getProduct(), category_product.getCategory());
    return "redirect:/categories/" + id;
  }

  @RequestMapping("/products/{id}")
  public String viewProduct(@ModelAttribute("category_product") CategoryProduct category_product, Model model,
      @PathVariable("id") Long id) {
    Product prod = productService.getOne(id);
    model.addAttribute("product", prod);
    model.addAttribute("categories", categoryService.getAllFiltered(prod.getCategories()));
    return "products/view.jsp";
  }

  @RequestMapping(value = "/products/{id}", method = RequestMethod.POST)
  public String addCategory(@Valid @ModelAttribute("category_product") CategoryProduct category_product,
      BindingResult result, @PathVariable("id") Long id) {
    if (result.hasErrors()) {
      return "products/view.jsp";
    }
    productService.addCategory(category_product.getProduct(), category_product.getCategory());
    return "redirect:/products/" + id;
  }

}
