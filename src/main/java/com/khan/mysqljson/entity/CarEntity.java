package com.khan.mysqljson.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarEntity {
    
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column(columnDefinition = "JSON")
    @Convert(converter = JsonNodeToString.class)
    private JsonNode metadata;
}
