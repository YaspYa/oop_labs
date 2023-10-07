package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;
public class StringCalculator {
    private String[] getAllSeparators(String numbers){
        List<String> separatorsList = new ArrayList<>();
        int newLinePos = numbers.indexOf("\n");
        String spliter = "";

       if(numbers.indexOf('[') != -1 && numbers.indexOf(']') != -1) {
           for (int i = 0; i < newLinePos; i++) {
               if (numbers.charAt(i) != '/' && numbers.charAt(i) != '[' && numbers.charAt(i) != ']') {
                   spliter += numbers.charAt(i);
                   if (numbers.charAt(i + 1) == ']') {
                       separatorsList.add(spliter);
                       spliter = "";
                   }
               }
           }
       }else {
           spliter = numbers.substring(2, newLinePos);
           separatorsList.add(spliter);
       }

        String[] res = separatorsList.toArray(new String[0]);
        Arrays.sort(res, Comparator.comparingInt(s->s.length()));
        Arrays.sort(res, Comparator.reverseOrder());

        return res;
    }

    private int canAddLetter(String numbers,  String[] spliters, int i){
        for(String sep: spliters) {
            if (numbers.length() - i >= sep.length() && numbers.substring(i, i + sep.length()).equals(sep) || numbers.charAt(i) == '\n') {
                return sep.length();
            }
        }
        return  0;
    }
     public int add(String numbers){
        String splitWord = "";
        int spliter = 0;
        String[] allSeparators = {","};
        int num = 0;
        int sum = 0;

        if(numbers.length() >= 2 && numbers.substring(0,2).equals("//")){
            allSeparators = getAllSeparators(numbers);
            int newLinePos = numbers.indexOf("\n");
            numbers = numbers.substring(newLinePos + 1);
        }

        List<Integer> intList = new ArrayList<>();
        List<Integer> negIntList = new ArrayList<>();

        for(int i = 0; i < numbers.length(); i++){
            spliter = canAddLetter(numbers, allSeparators, i);

            if(spliter == 0){
                splitWord += numbers.charAt(i);
            }

            if (spliter != 0 || i == numbers.length()-1){
                if(splitWord == ""){
                    System.out.println("The data is not correct!");
                    return -1;
                }

                if(numbers.charAt(i) != '\n' && i != numbers.length()-1)
                    i += spliter-1;

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

        for(int i = 0; i < intList.toArray().length; i++){
            sum += intList.get(i);
        }

        if(negIntList.toArray().length != 0){
            System.out.println("Negative numbers are not allowed: " + Arrays.toString(negIntList.toArray()));
        }
        return sum;
    }
}