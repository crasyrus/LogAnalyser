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

public abstract class BooleanCase extends AbstractCase<Boolean> {

  public BooleanCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public abstract Boolean convertStringToType(String s);

  @Override
  public Class<Boolean> getType() {
    return Boolean.class;
  }
}
