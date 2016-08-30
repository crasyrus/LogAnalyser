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

public interface Case<E> {

  E convertStringToType(String s);

  Result<E> createResult(Date datum, String line);

  boolean find(String check);

  Class<E> getType();
  
  String getName();
}
