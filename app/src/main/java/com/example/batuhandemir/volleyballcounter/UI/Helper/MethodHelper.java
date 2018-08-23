package com.example.batuhandemir.volleyballcounter.UI.Helper;

public class MethodHelper {

    public static String addThreeDots(String string, int lenght){
        if(string != null){
            if (string.length() >= lenght) {
                string = string.substring(0, lenght)+ "...";
            } else {
                string = string;
            }
        }else{
            string = "...";
        }

        return string;
    }
}
