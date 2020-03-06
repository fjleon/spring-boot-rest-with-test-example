package com.example.welcome.service;

import java.util.Comparator;

import org.apache.commons.lang3.StringUtils;

/**
 * Comparator object to order integers according to the numbers of matches of
 * number 1 in binary base. Decimal base value has precedence if two ordered
 * values are equals.
 */
public class BinaryComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
	int result = Integer.valueOf(StringUtils.countMatches(s1, "1")).compareTo(StringUtils.countMatches(s2, "1"));
	if (result == 0) {
	    result = Integer.valueOf(s2, 2).compareTo(Integer.valueOf(s1, 2));
	}
	return result * -1;
    }

}
