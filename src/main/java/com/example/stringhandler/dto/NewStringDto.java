package com.example.stringhandler.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewStringDto {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]{5,25}$")
    private String string;
}
