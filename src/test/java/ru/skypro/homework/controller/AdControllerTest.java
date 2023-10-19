package ru.skypro.homework.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
//import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

class AdControllerTest {

//    @Container
//    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13")
//            .withUsername("postgres")
//            .withPassword("postgres");
//
//    @DynamicPropertySource
//    static void postgresProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }

    @Autowired
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @DisplayName("Получение всех объявлений")
    @Test
    @WithMockUser(roles = "USER")

    void shouldGetAllAds_Ok() throws Exception {
        mockMvc.perform(get("/ads"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count", is(1)));/*
                // Проверяем, что тело ответа — массив
                .andExpect(jsonPath("$").isArray())
                // Проверяем, что массив пуст
                .andExpect(jsonPath("$").isEmpty());*/
    }




    @Test
    void addAd() {
    }

    @Test
    void getAdInfo() {
    }

    @Test
    void updateAd() {
    }

    @Test
    void deleteAd() {
    }

    @Test
    void getUserAds() {
    }

    @Test
    void updateImage() {
    }
}