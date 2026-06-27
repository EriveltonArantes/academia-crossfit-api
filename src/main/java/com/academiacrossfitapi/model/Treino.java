package com.academiacrossfitapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "treinos")
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String coach;
    private java.time.LocalDateTime data;
    @Column(nullable = false)
    private String nivel;
    @Column(nullable = false)
    private String exercicios;
    private Integer duracao;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
