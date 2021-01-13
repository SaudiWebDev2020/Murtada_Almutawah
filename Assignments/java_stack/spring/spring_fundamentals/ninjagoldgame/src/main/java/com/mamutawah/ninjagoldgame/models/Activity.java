package com.mamutawah.ninjagoldgame.models;

public class Activity {

  private String status;
  private String description;

  public Activity(String status, String description) {
    setStatus(status);
    setDescription(description);
  }

  public String toString() {
    return this.status + " , " + this.description;
  }

  /**
   * @return String return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return String return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

}