package com.ipads.bookadmin.utility;

public class ValidateUtils {
    public static boolean validateEmpty(String data){
        if(data == null||"".equals(data)){
            return false;
        }
        return true;
    }
}
