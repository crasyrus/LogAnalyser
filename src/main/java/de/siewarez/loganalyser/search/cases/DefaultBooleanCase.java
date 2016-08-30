/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

public class DefaultBooleanCase extends BooleanCase {

  public DefaultBooleanCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public Boolean convertStringToType(String s) {
    return Boolean.valueOf(s);
  }
}
