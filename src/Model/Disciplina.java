package Model;

public class Disciplina {
    private int id;
    private String nome;
    private int chs; // Carga horária semanal
    private int credito; // Créditos da disciplina

    // Construtor padrão
    public Disciplina() {
    }

    // Construtor com todos os atributos
    public Disciplina(int id, String nome, int chs, int credito) {
        this.id = id;
        this.nome = nome;
        this.chs = chs;
        this.credito = credito;
    }

    // Getters e Setters

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

    // Método toString para representação em String da disciplina
    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", chs=" + chs +
                ", credito=" + credito +
                '}';
    }
}
