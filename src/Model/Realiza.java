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
public class Realiza {
    private Estudante estudante;
    private Avaliacao avaliacao;
    private double nota;

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    @Override
    public String toString() {
        return "Realiza{" + "estudante=" + estudante + ", avaliacao=" + avaliacao + ", nota=" + nota + '}';
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Construtor, getters e setters

    public Realiza(Estudante estudante, Avaliacao avaliacao, double nota) {
        this.estudante = estudante;
        this.avaliacao = avaliacao;
        this.nota = nota;
    }
}