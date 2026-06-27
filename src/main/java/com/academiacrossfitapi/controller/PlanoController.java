package com.academiacrossfitapi.controller;

import com.academiacrossfitapi.dto.PlanoRequestDTO;
import com.academiacrossfitapi.dto.PlanoResponseDTO;
import com.academiacrossfitapi.service.PlanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Plano", description = "Gerenciamento de planos")
@RestController
@RequestMapping("/api/planos")
public class PlanoController {

    @Autowired
    private PlanoService service;

    @Operation(summary = "Listar todos os Plano")
    @GetMapping
    public List<PlanoResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long treinosId) {
        List<PlanoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (treinosId != null) {
            resultado = resultado.stream().filter(item -> treinosId.equals(item.getTreinosId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Plano por ID")
    @GetMapping("/{id}")
    public PlanoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Plano")
    @PostMapping
    public ResponseEntity<PlanoResponseDTO> criar(@Valid @RequestBody PlanoRequestDTO plano) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(plano));
    }

    @Operation(summary = "Atualizar Plano")
    @PutMapping("/{id}")
    public PlanoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PlanoRequestDTO plano) {
        return service.atualizar(id, plano);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Plano")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
