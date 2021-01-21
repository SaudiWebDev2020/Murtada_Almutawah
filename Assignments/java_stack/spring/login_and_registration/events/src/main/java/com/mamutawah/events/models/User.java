package com.mamutawah.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @Email
  private String email;

  // DONE Location - One to many. Location <Many>, User = One
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id", nullable = false)
  private Location location;

  // DONE Joined List
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "events_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
  private List<Event> joining;

  // DONE - message/comments many to many
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "messages", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "event_id"))
  private List<Message> messageWall;

  private String password;

  // @Transient
  // private String passwordConfirmation;

  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;

  @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
  private List<Event> hosts;

  public User() {
  }

  public User(String firstName, String lastName, String email, Location location, String password) {
    setFirstName(firstName);
    setLastName(lastName);
    setEmail(email);
    setLocation(location);
    setPassword(password);
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public String getFullName() {
    return this.firstName + " " + this.lastName;
  }
  // Getters & Setters

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
   * @return String return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return String return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return String return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return Location return the location
   */
  public Location getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * @return List<Event> return the joining
   */
  public List<Event> getJoining() {
    return joining;
  }

  /**
   * @param joining the joining to set
   */
  public void setJoining(List<Event> joining) {
    this.joining = joining;
  }

  /**
   * @return List<Message> return the messageWall
   */
  public List<Message> getMessageWall() {
    return messageWall;
  }

  /**
   * @param messageWall the messageWall to set
   */
  public void setMessageWall(List<Message> messageWall) {
    this.messageWall = messageWall;
  }

  /**
   * @return String return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return String return the passwordConfirmation public String
   *         getPasswordConfirmation() { return passwordConfirmation; }
   * 
   *         /**
   * @param passwordConfirmation the passwordConfirmation to set public void
   *                             setPasswordConfirmation(String
   *                             passwordConfirmation) { this.passwordConfirmation
   *                             = passwordConfirmation; }
   */

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
   * @return List<Event> return the hosts
   */
  public List<Event> getHosts() {
    return hosts;
  }

  /**
   * @param hosts the hosts to set
   */
  public void setHosts(List<Event> hosts) {
    this.hosts = hosts;
  }

}
