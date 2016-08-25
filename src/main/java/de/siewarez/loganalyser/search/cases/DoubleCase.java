/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.siewarez.loganalyser.search.cases;

/**
 *
 * @author Klaus
 */
public class DoubleCase extends NumberCase<Double> {

    public DoubleCase(String name, String regEx, String valueLimiter) {
        super(name, regEx, valueLimiter);
    }
    
    @Override
    public Double convertStringToType(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException ex) {
            return -1d;
        }
    }
}
