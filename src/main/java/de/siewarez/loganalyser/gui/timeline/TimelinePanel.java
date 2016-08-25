/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.gui.timeline;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import de.siewarez.loganalyser.search.Case;
import de.siewarez.loganalyser.search.Result;
import de.siewarez.loganalyser.search.ResultContainer;
import de.siewarez.loganalyser.search.cases.BooleanCase;
import java.awt.event.MouseAdapter;

public class TimelinePanel extends JPanel {

  private static final Font FONT = new Font("Serif", Font.PLAIN, 10);
  private static final int ABSTAND_DATE = 50;
  private static final int ZOOM = 10000;
  private final ResultContainer resultContainer;
  private Date start;
  private Date end;
  private final List<Timeline<?>> lines = new LinkedList<>();
  private long duration;
  private DateFormat df;

  public TimelinePanel(ResultContainer resultContainer, DateFormat df) {
    this.df = df;
    this.resultContainer = resultContainer;
    this.setBackground(Color.WHITE);

    start = resultContainer.getStartDate();
    end = resultContainer.getEndDate();
    init();
    calcDuration();
    createLines();
  }

  private void init() {
    this.addMouseListener(new MouseAdapter() {

      @Override
      public void mousePressed(MouseEvent e) {
        if (e.getPoint().x > TimelinePanel.this.getWidth() / 2) {
          start = new Date(start.getTime() + ZOOM);
          end = new Date(end.getTime() + ZOOM);
        } else {
          start = new Date(start.getTime() - ZOOM);
          end = new Date(end.getTime() - ZOOM);
        }
        calcDuration();
        updateLines();
        repaint();
      }
    });

    this.addMouseWheelListener((MouseWheelEvent e) -> {
      int anz = e.getWheelRotation();

      if (anz < 0) {
        zoomIn();
      } else {
        zoomOut();
      }
    });
  }

  public TimelinePanel() {
    this(null, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));
  }

  @SuppressWarnings("unchecked")
  private void createLines() {
    for (Case<?> c : resultContainer.getResults().keySet()) {
      if (c instanceof BooleanCase) {
        List<Result<Boolean>> l = new LinkedList<>();
        for (Result<?> r : resultContainer.getResults().get(c)) {
          l.add((Result<Boolean>) r);
        }
        lines.add(new BooleanTimeline((Case<Boolean>) c, l, start, end));
      }
//            else if(c instanceof NumberCase){
//                 List<Result<Number>> l = new LinkedList<Result<Number>>();
//                for(Result<?> r : result.get(c)){
//                    l.add((Result<Number> )r);
//                }
//                lines.add(new NumberTimeline((Case<Number>)c, l, getWidthSecond(), LINE_PADDING*i));
//            }

    }
  }

  private void updateLines() {
    for (Timeline<?> line : lines) {
      line.setStart(start);
      line.setEnd(end);
    }
  }

  private void calcDuration() {
    duration = end.getTime() - start.getTime();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);

    int h = this.getHeight() - 20;
    int w = this.getWidth();
    double hPerLine = h / (double) lines.size();
    double widthMilliSecond = w / (double) duration;

    int i = 0;
    for (Timeline<?> line : lines) {
      line.setY((int) Math.round(h - 20 - (hPerLine * i)));
      line.setWidthMilliSecond(widthMilliSecond);
      line.paint(g);
      i++;
    }

    //Zeitbeschriftung
    g.setFont(FONT);
    FontMetrics fm = g.getFontMetrics();
    double dateWidth = fm.getStringBounds(df.format(new Date()), g).getWidth();
    int dateHeigth = (int) Math.ceil(fm.getStringBounds(df.format(new Date()), g).getHeight());

    int anzZeiten = (int) (w / (ABSTAND_DATE + Math.round(dateWidth)));

    int x = 0;
    Date d;
    for (int j = 0; j < anzZeiten; j++) {
      g.setColor(Color.BLACK);
      d = new Date(start.getTime() + (long) ((j * (dateWidth + ABSTAND_DATE) + dateWidth / 2) / widthMilliSecond));
      g.drawString(df.format(d), x, h);

      g.setColor(Color.LIGHT_GRAY);
      g.drawLine(x + ((int) dateWidth / 2), h - dateHeigth, x + ((int) dateWidth / 2), 0);

      x += dateWidth + ABSTAND_DATE;
    }
  }

  private void zoomOut() {
    start = new Date(start.getTime() - ZOOM);
    end = new Date(end.getTime() + ZOOM);
    calcDuration();
    updateLines();
    repaint();
  }

  private void zoomIn() {
    start = new Date(start.getTime() + ZOOM);
    end = new Date(end.getTime() - ZOOM);
    calcDuration();
    updateLines();
    repaint();
  }
}
