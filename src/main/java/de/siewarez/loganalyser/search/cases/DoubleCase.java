/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

public class DoubleCase extends NumberCase<Double> {

  public DoubleCase(String name, String regEx, String valueLimiter) {
    super(name, regEx, valueLimiter);
  }

  @Override
  public Double convertStringToType(String s) {
    try {
      return Double.parseDouble(s);
    } catch (NumberFormatException ex) {
      return -1d;
    }
  }

  @Override
  public Class<Double> getType() {
    return Double.class;
  }
}
