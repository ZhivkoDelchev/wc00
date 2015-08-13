package com.wc00;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jako on 13.8.2015.
 */
public class TestClassTest {

    private TestClass sut;

    @Before
    public void setUp() throws Exception {
        sut = new TestClass();
    }

    @Test
    public void testName() throws Exception {
        assertEquals(-1, sut.test());
    }
}