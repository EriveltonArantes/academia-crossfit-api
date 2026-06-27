package com.academiacrossfitapi.dto;

import jakarta.validation.constraints.*;

public class AtletaRequestDTO {

    @NotNull(message = "PlanoId é obrigatório")
    @Positive(message = "PlanoId deve ser um ID válido (positivo)")
    private Long planoId;
    @NotNull(message = "TreinoId é obrigatório")
    @Positive(message = "TreinoId deve ser um ID válido (positivo)")
    private Long treinoId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotNull(message = "data nascimento não pode ser nulo")
    private java.time.LocalDateTime dataNascimento;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotBlank(message = "objetivo não pode estar em branco")
    private String objetivo;

    private String observacoes;

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
