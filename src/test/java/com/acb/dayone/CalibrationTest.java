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


        assertArrayEquals(new int[] {1,1}, Calibration.firstAndLast("1"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("12"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("132"));
        assertArrayEquals(new int[] {1, 2}, Calibration.firstAndLast("1a3bc2"));

        assertEquals(11, Calibration.lineSum("1721"));
        assertEquals(38, Calibration.lineSum("pqr3stu8vwx"));
        assertEquals(15, Calibration.lineSum("a1b2c3d4e5f"));
        assertEquals(77, Calibration.lineSum("treb7uchet"));
    }

    @Test
    void digitizeTest(){
        assertEquals("123", Calibration.digitize("1two3"));
        assertEquals("123", Calibration.digitize("1twothree"));
        assertEquals("234", Calibration.digitize("twothreefour"));
        assertEquals("2340", Calibration.digitize("twothreefour0"));

        assertEquals("8wo3", Calibration.digitize("eightwothree"));
        assertArrayEquals(new int[]{8,3}, Calibration.firstAndLast(Calibration.digitize("eightwothree")));
        assertArrayEquals(new int[]{6,8}, Calibration.firstAndLast(Calibration.digitize("69xvbxfffmr7one8gmch8")));
        assertArrayEquals(new int[]{7,8}, Calibration.firstAndLast(Calibration.digitize("kqxncc74sjttqklx3lxpffbdlthreetwooneightnb")));
    }

    @Test
    void sum() {
        final Calibration calibration = new Calibration(List.of("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"));
        assertEquals(142, calibration.sumOne());

        final Calibration calibration2 = new Calibration(Util.readStrings("/day1/sample.txt"));
        assertArrayEquals(new int[] {29, 83, 13, 24, 42, 14,76}, calibration2.sumByLine());
        assertEquals(281, calibration2.sumTwo());
    }

    @Test
    void sumOne() {
        final Calibration calibration = new Calibration(Util.readStrings("/day1/input1.txt"));
        assertEquals(54239, calibration.sumOne());
    }

    @Test
    void sumTwo() {
        final Calibration calibration = new Calibration(Util.readStrings("/day1/input1.txt"));
        calibration.log();
        assertEquals(55343, calibration.sumTwo());
    }
}
