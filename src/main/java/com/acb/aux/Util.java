package com.acb.aux;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 08.01.22.
 */
public class Util {

    public static List<Integer> readIntegers(final String line){
        return line.chars().map(Character::getNumericValue).boxed().toList();
    }

    public static List<String> readCharacters(final String line){
        return Arrays.stream(line.chars().mapToObj(c -> (char) c).toArray(Character[]::new)).map(String::valueOf).toList();
    }


    public static int base10(final List<Integer> list){
        return baseN(list, 10);
    }

    public static int baseN(final List<Integer> list, int base){
        return list.stream().reduce((a, b) -> a * base + b).orElse(0);
    }
}
