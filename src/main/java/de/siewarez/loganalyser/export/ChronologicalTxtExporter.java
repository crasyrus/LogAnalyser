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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.siewarez.loganalyser.search.Result;
import de.siewarez.loganalyser.search.ResultContainer;

public class ChronologicalTxtExporter extends TxtExporter {

  public ChronologicalTxtExporter() {
    super();
  }

  public ChronologicalTxtExporter(String dateformat) {
    super(dateformat);
  }

  public ChronologicalTxtExporter(String path, boolean append, PrintModus modus, String dateformat) {
    super(path, append, modus, dateformat);
  }

  @Override
  public void export(ResultContainer container) {
    File file = new File(getPath());
    try (FileWriter writer = new FileWriter(file, isAppend())) {
      List<Result<?>> all = container.toChronoligicalList();

      for (Result<?> r : all) {
        writer.write(getModus() == PrintModus.VALUE ? r.toString() : r.getLine());
        writer.write(System.getProperty("line.separator"));
      }
    } catch (IOException ex) {
      Logger.getLogger(CaseSeperatetTxtExporter.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
