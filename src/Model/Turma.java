package Model;

public class Turma {
    private int id;
    private String descricao;

    // Construtor vazio
    public Turma() {
    }

    // Construtor com todos os campos
    public Turma(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    // Métodos getters e setters para todos os campos
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

    // Método toString para facilitar a visualização dos objetos Turma
    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
