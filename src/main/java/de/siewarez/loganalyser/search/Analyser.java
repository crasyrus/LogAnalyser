/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search;

import de.siewarez.loganalyser.search.resource.Resource;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.util.Assert;

public class Analyser {

  private Resource resource;
  private List<Case<?>> cases = new LinkedList<>();

  public Analyser() {
  }

  public ResultContainer analyse() throws IOException, IllegalStateException {
    Assert.notNull(resource, "No resource specified");

    ResultContainer results = new ResultContainer();
    if (!cases.isEmpty()) {
      while (resource.hasNext()) {
        String data = resource.getNextData();
        for (Case<?> c : cases) {
          if (c.find(data)) {
            results.add(c, c.createResult(resource.getDate(), data));
          }
        }
      }
    }
    return results;
  }

  public List<Case<?>> getCases() {
    return cases;
  }

  public void setCases(List<Case<?>> cases) {
    this.cases = cases;
  }

  public void addCase(Case<?> c) {
    cases.add(c);
  }

  public boolean removeCase(Case<?> c) {
    return cases.remove(c);
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }
}
