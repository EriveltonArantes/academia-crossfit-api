package com.academiacrossfitapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "atletas")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefone;
    private java.time.LocalDateTime dataNascimento;
    @Column(nullable = false)
    private String nivel;
    @Column(nullable = false)
    private String objetivo;
    @Column(columnDefinition = "TEXT")
    private String observacoes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }
    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }
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
