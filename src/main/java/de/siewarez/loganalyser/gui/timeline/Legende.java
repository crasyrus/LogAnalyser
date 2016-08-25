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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import de.siewarez.loganalyser.search.Case;

public class Legende extends JPanel {

  public Legende(List<Case<?>> cases) {
    super();
    this.setBackground(Color.WHITE);
    setLayout(new GridLayout(cases.size(), 2));

    JPanel color;
    for (Case<?> c : cases) {
      color = new JPanel();
      //color.setBackground(c.getColor());
      color.setPreferredSize(new Dimension(10, 10));

      add(color);
      add(new JLabel(c.getName()));

    }
  }
}
