package com.example.stringhandler;
import com.example.stringhandler.dto.NewStringDto;
import com.example.stringhandler.service.StringHandlerService;
import com.example.stringhandler.service.StringHandlerServiceImpl;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@JsonTest
public class StringHandlerServiceTests {

    private final Gson gson = new Gson();

    private StringHandlerService stringHandlerService;

    @BeforeEach
    void makeService()  {
        stringHandlerService = new StringHandlerServiceImpl(gson);
    }

    private final NewStringDto firstTestString = new NewStringDto("HelloThereHowAreYou");
    private final NewStringDto secondTestString = new NewStringDto("BuffalobuffaloBuffalo");
    private final NewStringDto thirdTestString = new NewStringDto("grass");

    @Test
    void handleFirstStringTest() {
        String result = stringHandlerService.handleString(firstTestString);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("r", 2);
        hashMap.put("e", 4);
        hashMap.put("o", 3);
        hashMap.put("H", 2);
        hashMap.put("l", 2);
        hashMap.put("u", 1);
        hashMap.put("A", 1);
        hashMap.put("w", 1);
        hashMap.put("h", 1);
        hashMap.put("T", 1);
        hashMap.put("Y", 1);
        Map<String, Integer> newMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        String json = gson.toJson(newMap);
        assertEquals(json, result, "Test not pass!");
    }


    @Test
    void handleSecondStringTest() {
        String result = stringHandlerService.handleString(secondTestString);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 3);
        hashMap.put("B", 2);
        hashMap.put("l", 3);
        hashMap.put("u", 3);
        hashMap.put("f", 6);
        hashMap.put("b", 1);
        hashMap.put("o", 3);
        Map<String, Integer> newMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        String json = gson.toJson(newMap);
        assertEquals(json, result, "Test not pass!");
    }

    @Test
    void handleWithFiveLettersString() {
        String result = stringHandlerService.handleString(thirdTestString);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 1);
        hashMap.put("s", 2);
        hashMap.put("g", 1);
        hashMap.put("r", 1);
        Map<String, Integer> newMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        String json = gson.toJson(newMap);
        assertEquals(json, result, "Test not pass!");
    }
}

