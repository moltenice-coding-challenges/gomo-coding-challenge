package com.intilled.uvt.model;

import org.junit.Test;

import static org.junit.Assert.fail;

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
}