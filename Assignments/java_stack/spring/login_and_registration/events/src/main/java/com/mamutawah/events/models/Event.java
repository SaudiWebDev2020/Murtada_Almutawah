package com.mamutawah.events.models;

import java.text.SimpleDateFormat;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date;

  // DONE - Location many to one
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "location_id", nullable = false)
  private Location location;

  // DONE - Creator (Host) one to one
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User host;

  // DONE - Joined (List) many to many
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "events_users", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> joining;

  // DONE - message/comments many to many
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "messages", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<Message> messageWall;

  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;

  public Event() {
  }

  public Event(User host, String name, Date date, Location location) {
    setName(name);
    setLocation(location);
    setDate(date);
    setHost(host);
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  public String getDateFormatted() {
    SimpleDateFormat fm = new SimpleDateFormat("MMMM dd, YYYY");
    return fm.format(this.getDate());
  }

  public String getDateFormFormatted() {
    SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    return fm.format(this.getDate());
  }

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
   * @return Date return the date
   */
  public Date getDate() {
    return date;
  }

  /**
   * @param date the date to set
   */
  public void setDate(Date date) {
    this.date = date;
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
   * @return User return the host
   */
  public User getHost() {
    return host;
  }

  /**
   * @param host the host to set
   */
  public void setHost(User host) {
    this.host = host;
  }

  /**
   * @return List<User> return the joining
   */
  public List<User> getJoining() {
    return joining;
  }

  /**
   * @param joining the joining to set
   */
  public void setJoining(List<User> joining) {
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

}