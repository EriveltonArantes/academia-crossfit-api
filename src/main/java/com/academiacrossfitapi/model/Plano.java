package com.academiacrossfitapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "planos")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treinos_id")
    private Treino treinos;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String duracao;
    private java.math.BigDecimal preco;
    @Column(nullable = false)
    private String beneficios;
    private Boolean ativo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Treino getTreinos() { return treinos; }
    public void setTreinos(Treino treinos) { this.treinos = treinos; }
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
