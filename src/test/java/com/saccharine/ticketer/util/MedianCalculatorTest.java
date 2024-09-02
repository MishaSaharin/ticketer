package com.saccharine.ticketer.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianCalculatorTest {

    @Test
    public void testCalculateMedianOddNumberOfElements() {
        List<Integer> prices = Arrays.asList(10, 20, 30, 40, 50);
        double median = MedianCalculator.calculateMedian(prices);
        Assertions.assertEquals(
                30,
                median,
                "Expected median for an odd number of elements: 30.");
    }

    @Test
    public void testCalculateMedianEvenNumberOfElements() {
        List<Integer> prices = Arrays.asList(10, 20, 30, 40);
        double median = MedianCalculator.calculateMedian(prices);
        Assertions.assertEquals(
                25,
                median,
                "Expected median for an even number of elements: 25.");
    }

    @Test
    public void testCalculateMedianOneElement() {
        List<Integer> prices = Collections.singletonList(42);
        double median = MedianCalculator.calculateMedian(prices);
        Assertions.assertEquals(
                42,
                median,
                "Expected median for one element: 42");
    }

    @Test
    public void testCalculateMedianEmptyList() {
        List<Integer> prices = Collections.emptyList();
        double median = MedianCalculator.calculateMedian(prices);
        Assertions.assertEquals(
                0,
                median,
                "Expected median for an empty list: 0");
    }

    @Test
    public void testCalculateMedianUnsortedList() {
        List<Integer> prices = Arrays.asList(50, 20, 40, 10, 30);
        double median = MedianCalculator.calculateMedian(prices);
        Assertions.assertEquals(
                30,
                median,
                "The median should be 30 after sorting the list");
    }

    @Test
    public void testCalculateMedianNullList() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            MedianCalculator.calculateMedian(null);
        }, "NullPointerException expected when passing null to method");
    }
}