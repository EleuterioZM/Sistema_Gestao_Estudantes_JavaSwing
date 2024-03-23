/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Eleuterio_Mabecuane
 */
public class Avaliacao {
    private int id;
    private String descricao;
    private double peso;
    private double nota; // Adicionando a propriedade nota

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", descricao=" + descricao + ", peso=" + peso + ", nota=" + nota + '}';
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Construtor, getters e setters

    public Avaliacao(int id, String descricao, double peso, double nota) {
        this.id = id;
        this.descricao = descricao;
        this.peso = peso;
        this.nota = nota;
    }
}