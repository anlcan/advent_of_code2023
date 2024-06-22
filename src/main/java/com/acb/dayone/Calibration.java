package com.acb.dayone;

import java.util.Arrays;
import java.util.List;

import static com.acb.aux.Util.base10;

/**
 * Created on 21.06.24.
 */
public record Calibration(List<String> input) {

    public static final List<String> DIGITS = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");


    public static String digitize(final String line) {

        String input = line;
        if (input.isEmpty()) return line;
        for (int j = 0; j < DIGITS.size(); j++) {
            if (input.startsWith(DIGITS.get(j))) {
                // twoXXX -> 2XX is wrong
                // twoXXX -> 2woXX is correct

               /// input = input.replaceFirst(DIGITS.get(j), String.valueOf(j + 1));
                return String.valueOf(j + 1) + digitize(input.substring(1));
            }
        }

        return input.charAt(0) + digitize(input.substring(1));
    }

    public static int[] firstAndLast(final String line) {
        assert !line.isEmpty();

        final int[] array = line.chars().filter(x -> x >= 48 && x <= 57)
                .map(x -> x - 48).toArray();

        if (array.length > 1) {
            return new int[] {array[0], array[array.length - 1]};
        } else {
            return new int[] {array[0], array[0]};
        }
    }

    public static Integer lineSum(final String line) {
        assert !line.isEmpty();
        final int[] array = firstAndLast(line);
        return base10(Arrays.stream(array).boxed().toList());
    }

    public int[] sumByLine(){
        return input.stream().map(Calibration::digitize).map(Calibration::lineSum).mapToInt(Integer::intValue).toArray();
    }
    public int sumOne() {
        return input.stream().map(Calibration::lineSum).reduce(Integer::sum).orElse(0);
    }


    public int sumTwo() {
        return input.stream().map(Calibration::digitize).map(Calibration::lineSum).reduce(Integer::sum).orElse(0);
    }

    public void log(){
        input.stream().peek(x-> System.out.printf("%-40s%-40s%-40s\n", x, digitize(x), lineSum(digitize(x)))).toArray();
    }


}
