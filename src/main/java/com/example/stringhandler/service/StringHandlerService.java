package com.example.stringhandler.service;
import com.example.stringhandler.dto.NewStringDto;
import org.springframework.stereotype.Service;

@Service
public interface StringHandlerService {

    String handleString(NewStringDto string);
}
