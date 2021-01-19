package com.mamutawah.overflow.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "questions")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  private String question;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private List<Tag> tags;

  @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
  private List<Answer> answers;

  @Column(updatable = false)
  private Date createdAt;
  private Date updatedAt;

  public Question() {
  }

  public Question(String question, List<Tag> questionsTags) {
    setQuestion(question);
    setTags(questionsTags);
  }

  @PrePersist
  protected void onCreate() {
    this.createdAt = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
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
   * @return String return the question
   */
  public String getQuestion() {
    return question;
  }

  /**
   * @param question the question to set
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * @return Optional<Tag> return the tags
   */
  public List<Tag> getTags() {
    return tags;
  }

  /**
   * @param tags the tags to set
   */
  public void setTags(List<Tag> tags) {
    this.tags = tags;
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
   * @return Optional<Answer> return the answers
   */
  public List<Answer> getAnswers() {
    return answers;
  }

  /**
   * @param answers the answers to set
   */
  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

}
