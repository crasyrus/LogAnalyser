/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

public class IntegerCase extends NumberCase<Integer> {

  public IntegerCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public Integer convertStringToType(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException ex) {
      return -1;
    }
  }

  @Override
  public Class<Integer> getType() {
    return Integer.class;
  }
}
