package com.mamutawah.store.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "categories_products", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;

  public Category() {

  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  // ...
  // getters and setters
  // ...

  /**
   * @return Long return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * @return String return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return Date return the createdAt
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * @param createdAt the createdAt to set
   */
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * @return Date return the updatedAt
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }

  /**
   * @param updatedAt the updatedAt to set
   */
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  /**
   * @return List<Product> return the products
   */
  public List<Product> getProducts() {
    return products;
  }

  /**
   * @param products the products to set
   */
  public void setProducts(List<Product> products) {
    this.products = products;
  }

}
