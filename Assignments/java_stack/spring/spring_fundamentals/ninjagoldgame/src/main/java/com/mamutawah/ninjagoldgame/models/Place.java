package com.mamutawah.ninjagoldgame.models;

import java.util.Random;

public class Place {

  private int id;

  private String name;
  private boolean negative;
  private boolean positive;
  private int min;
  private int max;

  public Place(int id, String name, boolean positive, boolean negative, int min, int max) {
    setName(name);
    setPositive(positive);
    setNegative(negative);
    setMax(max);
    setMin(min);
    setId(id);
  }

  public int find() {

    int intRangeMin = this.min;
    int intRangeMax = this.max;
    int value = 0;

    if (this.negative) {
      intRangeMin = (-1) * this.max;
    }

    if (!this.positive && this.negative) {
      intRangeMax = (-1) * this.min;
    }

    Random r = new Random();
    value = r.nextInt((intRangeMax + 1) - intRangeMin) + intRangeMin;

    // int count = 0;
    // while (value < 50) {
    // value = r.nextInt((intRangeMax + 1) - intRangeMin) + intRangeMin;
    // System.out.println(count + " " + value);

    // count++;
    // if (count > 1000) {
    // break;
    // }
    // }

    return value;
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
   * @return boolean return the negative
   */
  public boolean isNegative() {
    return negative;
  }

  /**
   * @param negative the negative to set
   */
  public void setNegative(boolean negative) {
    this.negative = negative;
  }

  /**
   * @return int return the min
   */
  public int getMin() {
    return min;
  }

  /**
   * @param min the min to set
   */
  public void setMin(int min) {
    this.min = min;
  }

  /**
   * @return int return the max
   */
  public int getMax() {
    return max;
  }

  /**
   * @param max the max to set
   */
  public void setMax(int max) {
    this.max = max;
  }

  /**
   * @return boolean return the positive
   */
  public boolean isPositive() {
    return positive;
  }

  /**
   * @param positive the positive to set
   */
  public void setPositive(boolean positive) {
    this.positive = positive;
  }

  /**
   * @return int return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

}
