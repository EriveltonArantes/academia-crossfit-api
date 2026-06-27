package com.academiacrossfitapi.dto;

import jakarta.validation.constraints.*;

public class PlanoRequestDTO {

    @NotNull(message = "TreinosId é obrigatório")
    @Positive(message = "TreinosId deve ser um ID válido (positivo)")
    private Long treinosId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "duracao não pode estar em branco")
    private String duracao;
    @DecimalMin(value = "0.0", message = "preco não pode ser negativo")
    @NotNull(message = "preco não pode ser nulo")
    private java.math.BigDecimal preco;
    @NotBlank(message = "beneficios não pode estar em branco")
    private String beneficios;
    @NotNull(message = "ativo não pode ser nulo")
    private Boolean ativo;

    public Long getTreinosId() { return treinosId; }
    public void setTreinosId(Long treinosId) { this.treinosId = treinosId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
    public java.math.BigDecimal getPreco() { return preco; }
    public void setPreco(java.math.BigDecimal preco) { this.preco = preco; }
    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
