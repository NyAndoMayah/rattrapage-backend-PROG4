package com.example.patrimoineapi.patrimoine_api.service;

import com.example.patrimoineapi.patrimoine_api.model.Patrimoine;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatrimoineService {
    private final Map<String, Patrimoine> bdPatrimoines = new HashMap<>();

    public Patrimoine patrimoineParId (String id) {
        return bdPatrimoines
                .get(id);
    }

    public Patrimoine creerOuEditerPatrimoine (String id, Patrimoine patrimoine) {
        bdPatrimoines.put(id, patrimoine);
        return patrimoine;
    }
}

