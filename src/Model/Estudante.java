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
  private String contacto;

    @Override
    public String toString() {
        return "Estudante{" + "nrMatricula=" + nrMatricula + ", nome=" + nome + ", apelido=" + apelido + ", endereco=" + endereco + ", contacto=" + contacto + '}';
    }

    public Estudante() {
    }

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

}