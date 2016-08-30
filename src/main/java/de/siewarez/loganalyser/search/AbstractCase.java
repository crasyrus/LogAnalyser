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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCase<E> implements Case<E> {

  private final Matcher matcher;
  private final String valueLimiter;
  private final String name;
  private final String regEx;

  public AbstractCase(String name, String regEx, String valueLimiter) {
    this.matcher = Pattern.compile(regEx).matcher("");
    this.valueLimiter = valueLimiter;
    this.name = name;
    this.regEx = regEx;
  }

  @Override
  public boolean find(String check) {
    matcher.reset(check);
    return matcher.find();
  }

  @Override
  public Result<E> createResult(Date datum, String line) {
    Result<E> r = new Result<>(new Date(datum.getTime()), this.findValue(line));
    r.setLine(line);
    return r;
  }

  @Override
  public String getName() {
    return name;
  }

  public Matcher getMatcher() {
    return matcher;
  }

  public String getValueLimiter() {
    return valueLimiter;
  }

  public String getRegEx() {
    return regEx;
  }

  @Override
  public String toString() {
    return name;
  }

  private E findValue(String check) {
    int start = matcher.end();
    String result = check.substring(start, !"\n".equals(valueLimiter) ? check.indexOf(valueLimiter, start) : check.length());
    return convertStringToType(result);
  }
}
