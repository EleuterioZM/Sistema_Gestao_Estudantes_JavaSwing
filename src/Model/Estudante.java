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
public class Estudante {
    private int nrMatricula;
    private String nome;
    private String apelido;
    private String endereco;

    public Estudante(int nrMatricula, String nome, String apelido, String endereco, String contacto, Turma turma, Curso curso) {
        this.nrMatricula = nrMatricula;
        this.nome = nome;
        this.apelido = apelido;
        this.endereco = endereco;
        this.contacto = contacto;
        this.turma = turma;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudante{" + "nrMatricula=" + nrMatricula + ", nome=" + nome + ", apelido=" + apelido + ", endereco=" + endereco + ", contacto=" + contacto + ", turma=" + turma + ", curso=" + curso + '}';
    }
    private String contacto;
    private Turma turma;
    private Curso curso;

    // Construtor, getters e setters

    public int getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(int nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
