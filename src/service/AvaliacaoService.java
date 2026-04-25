package service;

import model.Avaliacao;
import model.Rota;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoService {
    // ATRIBUTO: Lista global para armazenar todas as avaliações feitas no sistema
    private List<Avaliacao> todasAvaliacoes;

    public AvaliacaoService() {
        // CONSTRUTOR: Inicializa a lista como um ArrayList (Coleção dinâmica)
        this.todasAvaliacoes = new ArrayList<>();
    }

    /**
     * MÉTODO DE ASSOCIAÇÃO: Este método é crucial. 
     * Ele cria a avaliação, adiciona na lista geral do sistema e TAMBÉM 
     * vincula essa avaliação a uma Rota específica através do método da classe Rota.
     */
    public void adicionarAvaliacao(Rota rota, int nota, String comentario) {
        Avaliacao novaAvaliacao = new Avaliacao(nota, comentario);
        rota.adicionarAvaliacao(novaAvaliacao); // Relacionamento entre objetos
        this.todasAvaliacoes.add(novaAvaliacao);
    }

    public List<Avaliacao> getTodasAvaliacoes() {
        return todasAvaliacoes;
    }

    // MÉTODO DE PROCESSAMENTO: Calcula a média aritmética das notas de todos os usuários
    public double calcularMediaGeral() {
        if (todasAvaliacoes.isEmpty()) return 0.0;
        
        double soma = 0;
        // Laço de repetição para somar todas as notas cadastradas
        for (Avaliacao a : todasAvaliacoes) {
            soma += a.getNota(); // Acesso via método Getter (Encapsulamento)
        }
        return soma / todasAvaliacoes.size();
    }
}