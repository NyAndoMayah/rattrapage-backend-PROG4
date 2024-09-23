package com.example.patrimoineapi.patrimoine_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Patrimoine {
    private String id;
    private String possesseur;
    private LocalDateTime derniereModification;
}
