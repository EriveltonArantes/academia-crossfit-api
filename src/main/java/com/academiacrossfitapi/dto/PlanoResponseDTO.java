package com.academiacrossfitapi.dto;

public class PlanoResponseDTO {

    private Long id;
    private Long treinosId;
    private String nome;
    private String tipo;
    private String duracao;
    private java.math.BigDecimal preco;
    private String beneficios;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
