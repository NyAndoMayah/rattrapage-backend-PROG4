package com.example.patrimoineapi.patrimoine_api.controller;

import com.example.patrimoineapi.patrimoine_api.model.Patrimoine;
import com.example.patrimoineapi.patrimoine_api.service.PatrimoineService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrimoines")
@AllArgsConstructor
public class PatrimoineController {
    private final PatrimoineService service;
    @GetMapping("/{id}")
    public Patrimoine patrimoineParId(@PathVariable String id) {
        return service.patrimoineParId(id);
    }

    @PutMapping("/{id}")
    public Patrimoine creerOuEditerPatrimoine(@PathVariable String id, @RequestBody Patrimoine patrimoine) {
        return service.creerOuEditerPatrimoine(id, patrimoine);
    }
}
