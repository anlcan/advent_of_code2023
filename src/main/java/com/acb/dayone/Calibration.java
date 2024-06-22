package com.acb.dayone;

import java.util.Arrays;
import java.util.List;

import static com.acb.aux.Util.base10;

/**
 * Created on 21.06.24.
 */
public class Calibration {

    public List<String> input;

    public Calibration(List<String> input) {
        this.input = input;
    }

    public static int[] firstAndLast(final String line){
        assert !line.isEmpty();

        final int[] array = line.chars().filter(x -> x >= 48 && x <= 57)
                .map(x -> x - 48).toArray();

        if (array.length > 1){
            return new int[]{array[0], array[array.length - 1]};
        } else {
            return new int[] {array[0], array[0]};
        }
    }

    public static Integer lineSum(final String line){
        assert !line.isEmpty();

        final int[] array = firstAndLast(line);
        return base10(Arrays.stream(array).boxed().toList());
    }

    public int sum(){
        return input.stream().map(Calibration::lineSum).reduce(Integer::sum).orElse(0);
    }


}
