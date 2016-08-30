/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.gui.timeline;

import de.siewarez.loganalyser.export.ResultExporter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import de.siewarez.loganalyser.search.ResultContainer;

public class TimeLineExporter implements ResultExporter {

  private DateFormat df;

  public TimeLineExporter() {
    this("yyyy-MM-dd HH:mm:ss.SSS");
  }

  public TimeLineExporter(String dateformat) {
    this(new SimpleDateFormat(dateformat));
  }

  public TimeLineExporter(DateFormat df) {
    this.df = df;
  }

  @Override
  public void export(ResultContainer resultContainer) {
    new DlgTimeline(new JFrame(), resultContainer, df, true);
  }
}
