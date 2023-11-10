package com.example.stringhandler.controller;
import com.example.stringhandler.dto.NewStringDto;
import com.example.stringhandler.service.StringHandlerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/handle")
public class StringHandlerController {

    private final StringHandlerService stringHandlerService;

    @PostMapping()
    public ResponseEntity<String> handleString(@Valid @RequestBody NewStringDto string) {
        log.info("POST: /handle");
       return ResponseEntity.status(201).body(stringHandlerService.handleString(string));
    }
}
