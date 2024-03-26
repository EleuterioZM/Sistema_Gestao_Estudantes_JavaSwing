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
    private int idEstudante;
    private int idAvaliacao;
    private double nota;

    public Realiza() {
    }

    public Realiza(int idEstudante, int idAvaliacao, double nota) {
        this.idEstudante = idEstudante;
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
    }

    public int getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

