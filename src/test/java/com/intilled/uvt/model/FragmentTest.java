package com.intilled.uvt.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class FragmentTest {

    @Test(expected = IllegalArgumentException.class)
    public void test_fragmentDoesNotAllowEndBeforeStart() {
        new Fragment(1000, 0);
    }

    @Test
    public void test_fragmentAllowsStandardEntries() {
        try {
            new Fragment(0, 1000);
            new Fragment(0, 0);
            new Fragment(1000, 1000);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected Exception: " + e.getClass().getSimpleName());
        }
    }

    @Test
    public void test_isSubsetOf() {
        Fragment fragment1 = new Fragment(0L, 1000L);
        Fragment fragment2 = new Fragment(100L, 200L);
        Fragment fragment3 = new Fragment(150L, 160L);
        assertTrue(fragment2.isSubsetOfAnElementIn(Arrays.asList(fragment1, fragment2, fragment3)));
        assertFalse(fragment2.isSubsetOfAnElementIn(Arrays.asList(fragment2, fragment3)));
        assertTrue(fragment3.isSubsetOfAnElementIn(Arrays.asList(fragment2, fragment3)));
        assertFalse(fragment1.isSubsetOfAnElementIn(Collections.singleton(fragment1)));
    }
}