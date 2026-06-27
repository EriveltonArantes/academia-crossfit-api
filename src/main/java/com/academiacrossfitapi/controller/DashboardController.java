package com.academiacrossfitapi.controller;

import com.academiacrossfitapi.model.Atleta;
import com.academiacrossfitapi.model.Plano;
import com.academiacrossfitapi.model.Matricula;
import com.academiacrossfitapi.model.Treino;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.academiacrossfitapi.repository.AtletaRepository atletaRepository;

    @Autowired
    private com.academiacrossfitapi.repository.PlanoRepository planoRepository;

    @Autowired
    private com.academiacrossfitapi.repository.MatriculaRepository matriculaRepository;

    @Autowired
    private com.academiacrossfitapi.repository.TreinoRepository treinoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalAtleta", atletaRepository.count());
        resumo.put("totalPlano", planoRepository.count());
        resumo.put("somaPrecoPlano", planoRepository.findAll().stream().map(e -> e.getPreco()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("totalMatricula", matriculaRepository.count());
        resumo.put("somaValorMatricula", matriculaRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoMatricula", matriculaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalTreino", treinoRepository.count());
        resumo.put("somaDuracaoTreino", treinoRepository.findAll().stream().filter(e -> e.getDuracao() != null).mapToInt(e -> e.getDuracao()).sum());
        resumo.put("graficoTreino", treinoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
