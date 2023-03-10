package com.example.restservice.constants;

public class ErrorMessages {

    private ErrorMessages(){
    }
    
    public final static String DATABASE_EXCEPTION = "There is a problem in the Server, Please call the Administrator";

    public final static String NO_LIBRARY_FOUND_ID="No Library Found with id=%d";
    public final static String NO_LIBRARY_FOUND_NAME_ZIPCODE="No Library Found with name= %s and zip_code=%s";
    public final static String LIBRARY_EXIST_NAME_ZIPCODE="Library Exists with the name= %s and zip_code=%s";

}
