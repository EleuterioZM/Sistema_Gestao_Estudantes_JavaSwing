package Model;

public class Avaliacao {
    private int id;
    private String descricao;
    private double peso;

    public Avaliacao() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
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

    public Avaliacao(int id, String descricao, double peso) {
        this.id = id;
        this.descricao = descricao;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Avaliacao{" + "id=" + id + ", descricao=" + descricao + ", peso=" + peso + '}';
    }

}
