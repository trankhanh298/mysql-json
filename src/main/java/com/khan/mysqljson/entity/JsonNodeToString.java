package com.khan.mysqljson.entity;

import java.text.MessageFormat;

import javax.persistence.AttributeConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeToString implements AttributeConverter<JsonNode, String> {
    private final ObjectMapper objectMapper;

    public JsonNodeToString(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public JsonNode convertToEntityAttribute(String attribute) {
        try {
            return this.objectMapper.readValue(attribute, JsonNode.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(MessageFormat.format("Cannot convert String {0} to JsonNode",
             attribute), e);
        }
    }

    @Override
    public String convertToDatabaseColumn(JsonNode dbData) {
        try {
            return this.objectMapper.writeValueAsString(dbData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot convert JsonNode to String", e);
        }
    }
}