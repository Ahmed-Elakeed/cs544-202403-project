package edu.miu.cs.cs544.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public class JsonParser {
    public static <T> T parseJsonToObject(String json, Class<T> clazz) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, clazz);
    }

    public static <T> List<T> parseJsonToList(String json, Class<T> clazz) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<List<T>>() {});
    }

    /**
     * How to use:
     * Suppose
     * String singleJson = "{\"id\":1,\"name\":\"session for newwwwww\",\"description\":\"session for event desc\",\"startDateTime\":\"2024-03-18T05:35:04.000+00:00\",\"endDateTime\":\"2024-03-18T05:34:57.000+00:00\"}";
     * String jsonArray = "[{\"id\":1,\"name\":\"session for newwwwww\",\"description\":\"session for event desc\",\"startDateTime\":\"2024-03-18T05:35:04.000+00:00\",\"endDateTime\":\"2024-03-18T05:34:57.000+00:00\"},{\"id\":2,\"name\":\"session 2\",\"description\":\"session for event desc\",\"startDateTime\":\"2024-03-18T05:35:04.000+00:00\",\"endDateTime\":\"2024-03-18T05:34:57.000+00:00\"}]";
     *    // Parsing single object
     *     Session session = parseJsonToObject(singleJson, Session.class);
     *     // Parsing list of objects
     *     List<Session> sessions = parseJsonToList(jsonArray, Session.class);
     */

}

