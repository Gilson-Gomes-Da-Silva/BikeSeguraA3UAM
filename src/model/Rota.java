package model;
import java.util.ArrayList;
import java.util.List;

public class Rota {
    // Atributos privados que definem as características da rota
    private int id;
    private String nome;
    private String tipo;
    private double extensao; 
    private String pontoInicio;
    private String pontoFim;
    private int nivelDificuldade;
    
    // ASSOCIAÇÃO: Uma Rota possui uma lista de Avaliações (Relacionamento 1:N)
    private List<Avaliacao> listaAvaliacao;

    public Rota(int id, String nome, String tipo, double extensao, String pontoInicio, String pontoFim, int nivelDificuldade) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.extensao = extensao;
        this.pontoInicio = pontoInicio;
        this.pontoFim = pontoFim;
        this.nivelDificuldade = nivelDificuldade;
        this.listaAvaliacao = new ArrayList<>(); // Inicialização da lista de objetos associados
    }

    /**
     * LÓGICA DE NEGÓCIO: Calcula o nível de segurança da rota.
     * Cruza o 'tipo' da via com o 'nível de dificuldade' para gerar um score.
     * Demonstra como o objeto processa seus próprios dados internos.
     */
    public double calcularNivelSeguranca() {
        double base = 0;
        if (tipo.equalsIgnoreCase("Ciclovia")) base = 5.0;
        else if (tipo.equalsIgnoreCase("Ciclofaixa")) base = 4.0;
        else base = 2.5;

        // Penaliza a segurança levemente conforme a dificuldade técnica aumenta
        return base - (nivelDificuldade * 0.1);
    }

    /**
     * MÉTODO DE ASSOCIAÇÃO: Adiciona um objeto Avaliacao à lista desta Rota.
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.listaAvaliacao.add(avaliacao);
    }

    // GETTERS: Essenciais para que o Service consiga buscar e filtrar rotas
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getExtensao() { return extensao; }
    public String getPontoInicio() { return pontoInicio; }
    public String getPontoFim() { return pontoFim; }
    public int getNivelDificuldade() { return nivelDificuldade; }

    @Override
    public String toString() {
        // Exibição formatada para o usuário, incluindo a quilometragem e o trecho
        return String.format("ID: %d | %s (%.2f km) | Dificuldade: %d | Trecho: %s até %s", 
                             id, nome, extensao, nivelDificuldade, pontoInicio, pontoFim);
    }
}