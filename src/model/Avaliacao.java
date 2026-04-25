package model;

public class Avaliacao {
    // ENCAPSULAMENTO: Atributos privados para proteger os dados. 
    // Ninguém fora desta classe pode alterar a nota diretamente.
    private int nota;
    private String comentario;

    // CONSTRUTOR: Método que inicializa o objeto com os valores recebidos do Service.
    public Avaliacao(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    // MÉTODOS GETTERS: Permitem a leitura dos dados de forma controlada.
    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
}