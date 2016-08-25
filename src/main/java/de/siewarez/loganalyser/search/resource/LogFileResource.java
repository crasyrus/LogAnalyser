/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.util.Assert;

public class LogFileResource implements Resource {

  private final List<String> lines;
  private final DateFormat df;
  private int currentIndex = -1;
  private Date lastDate;

  public LogFileResource(File file, String dateFormat) throws IOException {
    Assert.notNull(file, "No file specified");
    Assert.hasText(dateFormat, "No dateformat specified");
    try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
      lines = Arrays.asList(br.lines().toArray(String[]::new));
    }
    this.df = new SimpleDateFormat(dateFormat);
  }

  @Override
  public Date getDate() {
    Date date = parseDate(lines.get(currentIndex));
    if (date == null) {
      date = lastDate;
    } else {
      lastDate = date;
    }
    return date;
  }

  @Override
  public boolean hasNext() {
    return currentIndex + 1 < lines.size();
  }

  @Override
  public String getNextData() {
    return lines.get(++currentIndex);
  }

  private Date parseDate(String line) {
    try {
      return df.parse(line);
    } catch (ParseException ex) {
      return null;
    }
  }
}
