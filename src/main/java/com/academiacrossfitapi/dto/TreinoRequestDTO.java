package com.academiacrossfitapi.dto;

import jakarta.validation.constraints.*;

public class TreinoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "coach não pode estar em branco")
    private String coach;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotBlank(message = "exercicios não pode estar em branco")
    private String exercicios;
    @NotNull(message = "duracao não pode ser nulo")
    private Integer duracao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getCoach() { return coach; }
    public void setCoach(String coach) { this.coach = coach; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getExercicios() { return exercicios; }
    public void setExercicios(String exercicios) { this.exercicios = exercicios; }
    public Integer getDuracao() { return duracao; }
    public void setDuracao(Integer duracao) { this.duracao = duracao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
