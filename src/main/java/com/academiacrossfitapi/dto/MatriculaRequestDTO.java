package com.academiacrossfitapi.dto;

import jakarta.validation.constraints.*;

public class MatriculaRequestDTO {

    @NotNull(message = "AtletaId é obrigatório")
    @Positive(message = "AtletaId deve ser um ID válido (positivo)")
    private Long atletaId;
    @NotNull(message = "PlanoId é obrigatório")
    @Positive(message = "PlanoId deve ser um ID válido (positivo)")
    private Long planoId;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @FutureOrPresent(message = "data fim não pode ser retroativo")
    @NotNull(message = "data fim não pode ser nulo")
    private java.time.LocalDateTime dataFim;
    @DecimalMin(value = "0.0", message = "valor não pode ser negativo")
    @NotNull(message = "valor não pode ser nulo")
    private java.math.BigDecimal valor;
    @NotBlank(message = "forma pagamento não pode estar em branco")
    private String formaPagamento;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public Long getAtletaId() { return atletaId; }
    public void setAtletaId(Long atletaId) { this.atletaId = atletaId; }
    public Long getPlanoId() { return planoId; }
    public void setPlanoId(Long planoId) { this.planoId = planoId; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(java.time.LocalDateTime dataFim) { this.dataFim = dataFim; }
    public java.math.BigDecimal getValor() { return valor; }
    public void setValor(java.math.BigDecimal valor) { this.valor = valor; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
