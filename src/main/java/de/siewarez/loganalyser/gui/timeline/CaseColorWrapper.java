/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.gui.timeline;

import de.siewarez.loganalyser.search.AbstractCase;
import de.siewarez.loganalyser.search.Case;
import de.siewarez.loganalyser.search.Result;
import java.awt.Color;
import java.util.Date;

public class CaseColorWrapper<E> implements Case<E> {

  private final Case<E> c;
  private final Color color;

  public CaseColorWrapper(AbstractCase<E> c, Color color) {
    this.c = c;
    this.color = color;
  }

  @Override
  public E convertStringToType(String s) {
    return c.convertStringToType(s);
  }

  public Case<E> getCase() {
    return c;
  }

  public Color getColor() {
    return color;
  }

  @Override
  public Class<E> getType() {
    return c.getType();
  }

  @Override
  public Result<E> createResult(Date datum, String line) {
    return c.createResult(datum, line);
  }

  @Override
  public boolean find(String check) {
    return c.find(check);
  }

  @Override
  public String getName() {
    return c.getName();
  }
}
