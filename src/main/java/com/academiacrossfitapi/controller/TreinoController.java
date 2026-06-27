package com.academiacrossfitapi.controller;

import com.academiacrossfitapi.dto.TreinoRequestDTO;
import com.academiacrossfitapi.dto.TreinoResponseDTO;
import com.academiacrossfitapi.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Treino", description = "Gerenciamento de treinos")
@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService service;

    @Operation(summary = "Listar todos os Treino")
    @GetMapping
    public List<TreinoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<TreinoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Treino por ID")
    @GetMapping("/{id}")
    public TreinoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Treino")
    @PostMapping
    public ResponseEntity<TreinoResponseDTO> criar(@Valid @RequestBody TreinoRequestDTO treino) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(treino));
    }

    @Operation(summary = "Atualizar Treino")
    @PutMapping("/{id}")
    public TreinoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TreinoRequestDTO treino) {
        return service.atualizar(id, treino);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Treino")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
