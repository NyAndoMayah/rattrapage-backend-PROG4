package com.example.patrimoineapi.patrimoine_api.controller;

import com.example.patrimoineapi.patrimoine_api.model.Patrimoine;
import com.example.patrimoineapi.patrimoine_api.service.PatrimoineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrimoines")
@AllArgsConstructor
public class PatrimoineController {
    private final PatrimoineService service;

    @GetMapping("/{id}")
    public ResponseEntity<Patrimoine> patrimoineParId(@PathVariable String id) {
        Patrimoine patrimoine = service.patrimoineParId(id);
        if (patrimoine == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(patrimoine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patrimoine> creerOuEditerPatrimoine(@PathVariable String id, @RequestBody Patrimoine patrimoine) {
        if (patrimoine.getPossesseur() == null || patrimoine.getPossesseur().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Patrimoine updatedPatrimoine = service.creerOuEditerPatrimoine(id, patrimoine);
        return ResponseEntity.ok(updatedPatrimoine);
    }
}
