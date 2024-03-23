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
public class Disciplina {
    private int id;
    private String nome;
    private int chs; // Carga horária semanal
    private int credito; // Créditos da disciplina

    public Disciplina(int id, String nome, int chs, int credito) {
        this.id = id;
        this.nome = nome;
        this.chs = chs;
        this.credito = credito;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "id=" + id + ", nome=" + nome + ", chs=" + chs + ", credito=" + credito + '}';
    }

    // Construtor, getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getChs() {
        return chs;
    }

    public void setChs(int chs) {
        this.chs = chs;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
}

