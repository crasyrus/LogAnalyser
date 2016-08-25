/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.siewarez.loganalyser.search.Case;
import de.siewarez.loganalyser.search.Result;
import de.siewarez.loganalyser.search.ResultContainer;
import java.io.BufferedWriter;

public class CaseSeperatetTxtExporter extends TxtExporter {

  public CaseSeperatetTxtExporter() {
    super();
  }

  public CaseSeperatetTxtExporter(String dateformat) {
    super(dateformat);
  }

  public CaseSeperatetTxtExporter(String path, boolean append, PrintModus modus, String dateformat) {
    super(path, append, modus, dateformat);
  }

  @Override
  public void export(ResultContainer resultContainer) {
    File file = new File(getPath());
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, isAppend()))) {
      for (Case<?> c : resultContainer.getResults().keySet()) {
        writer.write(c.getName() + ":");
        writer.write(System.getProperty("line.separator"));
        for (Result<?> r : resultContainer.getResults().get(c)) {
          writer.write("\t" + (getModus() == PrintModus.VALUE ? r.toString() : r.getLine()));
          writer.write(System.getProperty("line.separator"));
        }
        writer.write(System.getProperty("line.separator"));
        writer.flush();
      }
    } catch (IOException ex) {
      Logger.getLogger(CaseSeperatetTxtExporter.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
