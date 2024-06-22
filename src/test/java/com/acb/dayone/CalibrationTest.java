package com.acb.dayone;

import com.acb.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on 21.06.24.
 */
class CalibrationTest {

    @Test
    void lineSum() {
    /*1abc2
    pqr3stu8vwx
    a1b2c3d4e5f
    treb7uchet*/

        assertArrayEquals(new int[] {1}, Calibration.firstAndLast("1"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("12"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("132"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("1a3bc2"));

        assertEquals(11, Calibration.lineSum("1721"));
        assertEquals(38, Calibration.lineSum("pqr3stu8vwx"));
        assertEquals(15, Calibration.lineSum("a1b2c3d4e5f"));
        assertEquals(77, Calibration.lineSum("treb7uchet"));
    }

    @Test
    void sum() {
        final Calibration calibration = new Calibration(List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"));
        assertEquals(142, calibration.sum());
    }

    @Test
    void sumOne() {
        final Calibration calibration = new Calibration(Util.readStrings("/day1/input1.txt"));
        assertEquals(54239, calibration.sum());
    }
}
