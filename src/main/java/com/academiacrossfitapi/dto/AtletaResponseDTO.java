package com.academiacrossfitapi.dto;

public class AtletaResponseDTO {

    private Long id;
    private Long planoId;
    private Long treinoId;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private java.time.LocalDateTime dataNascimento;
    private String nivel;
    private String objetivo;
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPlanoId() { return planoId; }
    public void setPlanoId(Long planoId) { this.planoId = planoId; }
    public Long getTreinoId() { return treinoId; }
    public void setTreinoId(Long treinoId) { this.treinoId = treinoId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public java.time.LocalDateTime getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(java.time.LocalDateTime dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
