/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

import de.siewarez.loganalyser.search.AbstractCase;

public class StringCase extends AbstractCase<String> {

  public StringCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public String convertStringToType(String s) {
    return s;
  }

  @Override
  public Class<String> getType() {
    return String.class;
  }
}
