/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search;

import java.util.Date;

public class Result<E> implements Comparable<Result<?>> {

  private Date datum;
  private E value;
  private String line;

  public Result(Date datum, E value) {
    this.datum = datum;
    this.value = value;
  }

  public Date getDatum() {
    return new Date(datum.getTime());
  }

  public void setDatum(Date datum) {
    this.datum = new Date(datum.getTime());
  }

  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return datum + " - " + value;
  }

  @Override
  public int compareTo(Result<?> o) {
    return datum.compareTo(o.getDatum());
  }
}
