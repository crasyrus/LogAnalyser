/*
 *      |                    \                 |                       
 *      |      _ \   _` |   _ \     \    _` |  |  |  | (_-<   -_)   _| 
 *     ____| \___/ \__, | _/  _\ _| _| \__,_| _| \_, | ___/ \___| _|   
 *                 ____/                         ___/                  
 *
 * author: Klaus Sievers
 */
package de.siewarez.loganalyser.search.cases;

import de.siewarez.loganalyser.search.AbstractCase;

public enum ChoosableCase {
    BOOLEAN_CHOOSE_CASE("Boolean", DefaultBooleanCase.class),
    INTEGER_CHOOSE_CASE("Integer", IntegerCase.class),
    DOUBLE_CHOOSE_CASE("Double", DoubleCase.class),
    STRING_CHOOSE_CASE("Sting", StringCase.class);

    private ChoosableCase(String name, Class<? extends AbstractCase<?>> c) {
        this.name = name;
        this.c = c;
    }

    public Class<? extends AbstractCase<?>> getC() {
        return c;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    private String name;
    private Class<? extends AbstractCase<?>> c;
}
