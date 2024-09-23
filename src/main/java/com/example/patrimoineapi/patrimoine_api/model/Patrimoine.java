package com.example.patrimoineapi.patrimoine_api.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patrimoine {
    private String id;
    private String possesseur;
    private LocalDateTime derniereModification;
}
