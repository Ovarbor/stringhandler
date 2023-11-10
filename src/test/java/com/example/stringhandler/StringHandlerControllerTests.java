package com.example.stringhandler;

import com.example.stringhandler.dto.NewStringDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class StringHandlerControllerTests {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper mapper;

        private final NewStringDto firstTestString = new NewStringDto("HelloThereHowAreYou");
        private final NewStringDto secondTestString = new NewStringDto("AntZAnnTj");
        private final NewStringDto stringWithLessThenFiveLetters = new NewStringDto("Hell");
        private final NewStringDto stringWithMoreThenTwentyFiveLetters = new NewStringDto("HellasdsadasdxqqwesxxswsxwaS");

        @Test
        void handleFirstStringTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(firstTestString))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.e").value(4))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.l").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.H").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.o").value(3))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.r").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.w").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.h").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.T").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.Y").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.A").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.u").value(1));
        }

        @Test
        void handleSecondStringTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(secondTestString))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.A").value(2))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.n").value(3))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.t").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.Z").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.T").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.j").value(1));
        }

        @Test
        void handleStringWithLessThanFiveLettersTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(stringWithLessThenFiveLetters))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }

        @Test
        void handleStringWithMoreThanTwentyFiveLettersTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(stringWithMoreThenTwentyFiveLetters))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }


        @Test
        void handleStringWithSymbolsTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString("@Heeloow"))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }


        @Test
        void handleStringWithSpaceTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(new NewStringDto("He lloww")))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }

        @Test
        void handleStringWithCyrillicLettersTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(new NewStringDto("HellowЛ")))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }

        @Test
        void handleStringWithDigitsTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(new NewStringDto("Hellow1")))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }

        @Test
        void handleEmptyStringTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(new NewStringDto("")))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }


        @Test
        void handleNullStringTest() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders
                                .post("/handle")
                                .content(mapper.writeValueAsString(new NewStringDto(null)))
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isBadRequest());
        }
}
