package com.example.patrimoineapi.patrimoine_api.controller;

import com.example.patrimoineapi.patrimoine_api.model.Patrimoine;
import com.example.patrimoineapi.patrimoine_api.service.PatrimoineService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/patrimoines")
public class PatrimoineController {
    private static PatrimoineService service;
    @GetMapping("/{id}")
    public static Patrimoine patrimoineParId (@PathVariable String id) {
        return service.patrimoineParId(id);
    }

    @GetMapping("/{id}")
    public static Patrimoine creerOuEditerPatrimoine (@PathVariable String id, @RequestBody Patrimoine patrimoine) {
        return service
                .creerOuEditerPatrimoine(id, patrimoine);
    }
}
