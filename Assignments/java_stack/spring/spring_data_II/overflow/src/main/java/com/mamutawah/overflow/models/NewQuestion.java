package com.mamutawah.overflow.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewQuestion {

  @NotBlank
  private String question;

  @NotBlank(message = "You must add tag")
  @Pattern(regexp = "^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){0,2}$", message = "Tags must be separated by commas, max 3")
  private String tags;

  public NewQuestion() {
  }

  public String[] splitTags() {
    return this.tags.split("\\s*,\\s*");
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
   * @return String return the tags
   */
  public String getTags() {
    return tags;
  }

  /**
   * @param tags the tags to set
   */
  public void setTags(String tags) {
    this.tags = tags;
  }

}
