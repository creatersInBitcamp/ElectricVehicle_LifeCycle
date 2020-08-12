package com.bitcamp.team_project_eco.used;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.XSlf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;


public class AdditionalDataConverter implements AttributeConverter<Img, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Img img) {
        // img -> Json문자열로 변환
        try {
            return objectMapper.writeValueAsString(img);
        } catch (JsonProcessingException e) {
//            log.error("fail to serialize as object into Json : {}", img, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Img convertToEntityAttribute(String jsonStr) {
        // Json 문자열 -> img로 변환
        try {
            return objectMapper.readValue(jsonStr, Img.class);
        } catch (IOException e) {
//            log.error("fail to deserialize as Json into Object : {}", jsonStr, e);
            throw new RuntimeException(e);
        }
    }
}
