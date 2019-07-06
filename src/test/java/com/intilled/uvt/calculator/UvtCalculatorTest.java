package com.intilled.uvt.calculator;

import com.google.common.collect.Sets;
import com.intilled.uvt.model.Fragment;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UvtCalculatorTest {

    private UvtCalculator calculator;

    @Before
    public void setUp() {
        calculator = new UvtCalculator();
    }

    @Test
    public void test_calculateUvtWithExampleInPdf1() {
        Fragment fragment = new Fragment(32052L, 47179L);
        long result = calculator.calculateUvt(Collections.singleton(fragment));
        assertEquals(15127L, result);
    }


    @Test
    public void test_calculateUvtWithExampleInPdf2() {
        Fragment fragment1 = new Fragment(0L, 120000L);
        Fragment fragment2 = new Fragment(30000L, 45000L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment1, fragment2));
        assertEquals(120000L, result);
    }

    @Test
    public void test_calculateUvtWithExampleInPdf3() {
        Fragment fragment1 = new Fragment(0L, 1000L);
        Fragment fragment2 = new Fragment(2000L, 3000L);
        Fragment fragment3 = new Fragment(2500L, 4000L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment1, fragment2, fragment3));
        assertEquals(3000L, result);

        long result2 = calculator.calculateUvt(Sets.newHashSet(fragment2, fragment3, fragment1));
        assertEquals(3000L, result2);
    }

    @Test
    public void test_calculateUvtWithExampleInPdf4() {
        Fragment fragment1 = new Fragment(0L, 10L);
        long result = calculator.calculateUvt(Collections.singleton(fragment1));
        assertEquals(10L, result);
    }

    @Test
    public void test_calculateUvtWithCustomExample1() {
        Fragment fragment1 = new Fragment(0L, 1000L);
        Fragment fragment2 = new Fragment(100L, 200L);
        Fragment fragment3 = new Fragment(150L, 160L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment3, fragment1, fragment2));
        assertEquals(1000L, result);
    }

    @Test
    public void test_calculateUvtWithCustomExample2() {
        long result = calculator.calculateUvt(null);
        assertEquals(0L, result);

        long result2 = calculator.calculateUvt(Collections.emptySet());
        assertEquals(0L, result2);
    }

    @Test
    public void test_calculateUvtWithCustomExample3() {
        Fragment fragment1 = new Fragment(0L, 1000L);
        Fragment fragment2 = new Fragment(9000L, 10000L);
        Fragment fragment3 = new Fragment(11000L, 12000L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment1, fragment2, fragment3));
        assertEquals(3000L, result);
    }

    @Test
    public void test_calculateUvtWithCustomExample4() {
        Fragment fragment1 = new Fragment(0L, 0L);
        Fragment fragment2 = new Fragment(9000L, 9000L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment1, fragment2));
        assertEquals(0L, result);
    }

    @Test
    public void test_calculateUvtWithCustomExample5() {
        Fragment fragment1 = new Fragment(9000L, 9000L);
        Fragment fragment2 = new Fragment(9000L, 9000L);
        long result = calculator.calculateUvt(Sets.newHashSet(fragment1, fragment2));
        assertEquals(0L, result);
    }
}