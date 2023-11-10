package com.example.stringhandler.service;
import com.example.stringhandler.dto.NewStringDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StringHandlerServiceImpl implements StringHandlerService {

    private final Gson gson;
    @Override
    public String handleString(NewStringDto string) {
        int count = 0;
        List<String> stringList = new ArrayList<>(List.of(string.getString().split("")));
        HashMap<String, Integer> hashMap = new HashMap<>();
        stringList.forEach(str -> hashMap.put(str, hashMap.getOrDefault(str, count) + 1));
        Map<String, Integer> newMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
        return gson.toJson(newMap);
    }
}
