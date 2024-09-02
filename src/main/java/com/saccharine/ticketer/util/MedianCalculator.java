package com.saccharine.ticketer.util;

import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class MedianCalculator {
    public static final Logger LOGGER = Logger.getLogger(MedianCalculator.class);

    public static double calculateMedian(List<Integer> prices) {
        if (!prices.isEmpty()) {
            Collections.sort(prices);
            int n = prices.size();
            LOGGER.info("The median of " + n + " prices");
            if (n % 2 == 1) {
                return prices.get(n / 2);
            } else {
                return (prices.get(n / 2 - 1) + prices.get(n / 2)) / 2.0;
            }
        } else {
            throw new IllegalArgumentException("The list is empty");
        }
    }
}