package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
     public int add(String numbers){
        String splitWord = "";

        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < numbers.length(); i++){
            if( numbers.charAt(i) != ',' && numbers.charAt(i) != '\n'){
                splitWord += numbers.charAt(i);
            }

            if ((numbers.charAt(i) == ','|| numbers.charAt(i) == '\n' || i == numbers.length()-1)){
                if(splitWord == ""){
                    System.out.println("The data is not correct!");
                    return 0;
                }
                intList.add(Integer.parseInt(splitWord));
                splitWord = "";
            }
        }

        int sum = 0;
        for(int i = 0; i < intList.toArray().length; i++){
            sum += intList.get(i);
        }
        return sum;
    }
}