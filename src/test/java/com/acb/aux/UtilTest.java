package com.acb.aux;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created on 22.06.24.
 */
class UtilTest {

    @Test
    void base10() {
        assertEquals(123, Util.base10(Util.readIntegers("123")));
        assertEquals(3, Util.base10(Util.readIntegers("3")));
        assertEquals(4123, Util.base10(Util.readIntegers("4123")));
        assertEquals(4123, Util.base10(List.of(4,1,2,3)));
    }
}
