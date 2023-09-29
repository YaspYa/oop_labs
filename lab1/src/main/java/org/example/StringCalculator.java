package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
     public int add(String numbers){
        String splitWord = "";
        char splier = ',';
        int num = 0;

        if(numbers.length() >= 2 && numbers.substring(0,2).equals("//")){
            splier = numbers.charAt(2);
            numbers = numbers.substring(4);
        }

        List<Integer> intList = new ArrayList<>();
        List<Integer> negIntList = new ArrayList<>();
        for(int i = 0; i < numbers.length(); i++){
            if( numbers.charAt(i) != splier && numbers.charAt(i) != '\n'){
                splitWord += numbers.charAt(i);
            }

            if ((numbers.charAt(i) == splier|| numbers.charAt(i) == '\n' || i == numbers.length()-1)){
                if(splitWord == ""){
                    System.out.println("The data is not correct!");
                    return 0;
                }
                num = Integer.parseInt(splitWord);
                if(num<=1000) {
                    if (num >= 0) {
                        intList.add(num);
                    } else {
                        negIntList.add(num);
                    }
                }

                splitWord = "";
            }
        }

        int sum = 0;
        for(int i = 0; i < intList.toArray().length; i++){
            sum += intList.get(i);
        }

        if(negIntList.toArray().length != 0){
            System.out.println("Negative numbers are not allowed: " + Arrays.toString(negIntList.toArray()));
        }
        return sum;
    }
}