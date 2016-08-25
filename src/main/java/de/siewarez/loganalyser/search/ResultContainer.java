/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResultContainer {

  private final Map<Case<?>, List<Result<?>>> results = new HashMap<>();

  public Map<Case<?>, List<Result<?>>> getResults() {
    return results;
  }

  public void add(Case<?> c, Result<?> result) {
    results.computeIfAbsent(c, t -> new LinkedList<>()).add(result);
  }

  public void clear() {
    results.clear();
  }

  public Date getStartDate() {
    if (results.isEmpty()) {
      return null;
    }
    List<Result<?>> l = toChronoligicalList();
    return l.get(0).getDatum();
  }

  public Date getEndDate() {
    if (results.isEmpty()) {
      return null;
    }
    List<Result<?>> l = toChronoligicalList();
    return l.get(l.size() - 1).getDatum();
  }

  public List<Result<?>> toChronoligicalList() {
    List<Result<?>> all = new ArrayList<>();
    for (Case<?> c : results.keySet()) {
      all.addAll(results.get(c));
    }
    Collections.sort(all);
    return all;
  }
}
