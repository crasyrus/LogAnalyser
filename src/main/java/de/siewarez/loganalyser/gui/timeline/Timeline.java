/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.gui.timeline;

import java.awt.Component;
import java.util.Date;
import java.util.List;
import de.siewarez.loganalyser.search.AbstractCase;
import de.siewarez.loganalyser.search.Case;
import de.siewarez.loganalyser.search.Result;

public class Timeline<E> extends Component {

  public static final int Y_HEIGTH = 10;
  private Case<E> aktCase;
  private List<Result<E>> result;
  private int y = -1;
  private double widthMilliSecond = -1;
  private Date start;
  private Date end;

  public Timeline(Case<E> aktCase, List<Result<E>> result, Date start, Date end) {
    this.aktCase = aktCase;
    this.result = result;
    this.start = start;
    this.end = end;
  }

  public Case<E> getAktCase() {
    return aktCase;
  }

  public void setAktCase(AbstractCase<E> aktCase) {
    this.aktCase = aktCase;
  }

  public Date getEnd() {
    return end;
  }

  public void setEnd(Date end) {
    this.end = end;
  }

  public List<Result<E>> getResult() {
    return result;
  }

  public void setResult(List<Result<E>> result) {
    this.result = result;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public double getWidthMilliSecond() {
    return widthMilliSecond;
  }

  public void setWidthMilliSecond(double widthMilliSecond) {
    this.widthMilliSecond = widthMilliSecond;
  }

  @Override
  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
