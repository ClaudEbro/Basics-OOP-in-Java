package net.ebrottie.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTranformationUtils {

    public static String toJson(Object o){
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(o);
            return json;
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }
}
