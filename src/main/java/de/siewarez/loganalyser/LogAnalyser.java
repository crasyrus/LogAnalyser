/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.siewarez.loganalyser.export.ResultExporter;
import de.siewarez.loganalyser.export.TimeLineExporter;
import de.siewarez.loganalyser.search.Analyser;
import de.siewarez.loganalyser.search.resource.LogFileResource;
import de.siewarez.loganalyser.search.ResultContainer;
import de.siewarez.loganalyser.search.cases.DefaultBooleanCase;

public class LogAnalyser {

  public static void main(String[] args) {

    try {
      Analyser analyse = new Analyser();

      File file = new File("C:\\Users\\Andree\\Desktop\\testLog.txt");
      analyse.setResource(new LogFileResource(file, "yyyy-MM-dd HH:mm:ss.SSS"));

      DefaultBooleanCase case1 = new DefaultBooleanCase("Klo 1", "Klopause 1 = ", "\n");
      analyse.addCase(case1);

      DefaultBooleanCase case2 = new DefaultBooleanCase("Klo 2", "Klopause 2 = ", "\n");
      analyse.addCase(case2);

      DefaultBooleanCase case3 = new DefaultBooleanCase("Klo 3", "Klopause 3 = ", "\n");
      analyse.addCase(case3);

      DefaultBooleanCase case4 = new DefaultBooleanCase("Klo 4", "Klopause 4 = ", "\n");
      analyse.addCase(case4);

      ResultContainer resultContainer = analyse.analyse();

//            ResultExporter exporter = new ChronologicalTxtExporter("C:\\Users\\Klaus\\Desktop\\testResult.txt", false, PrintModus.LINE, "yyyy-MM-dd HH:mm:ss.SSS");
      ResultExporter exporter = new TimeLineExporter();
      exporter.export(resultContainer);

    } catch (IOException ex) {
      Logger.getLogger(LogAnalyser.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
