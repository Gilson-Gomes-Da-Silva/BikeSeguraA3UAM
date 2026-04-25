package service;

// Importação da classe abstrata PontoApoio e das coleções do Java
import model.PontoApoio;
import java.util.ArrayList;
import java.util.List;

public class PontoApoioService {
    
    /* * LISTA POLIMÓRFICA:
     * Definimos uma lista do tipo 'PontoApoio' (a classe pai). 
     * Graças ao polimorfismo, esta única lista pode armazenar objetos de 
     * qualquer classe filha (Bicicletario, Oficina, BombaAr ou Bebedouro).
     */
    private List<PontoApoio> listaPontos = new ArrayList<>();

    /**
     * MÉTODO DE CADASTRO:
     * Recebe um objeto do tipo PontoApoio. 
     * Na prática, o Main enviará uma 'Oficina' ou um 'Bebedouro', 
     * e o Java aceita normalmente devido à herança.
     */
    public void cadastrarPonto(PontoApoio p) { 
        listaPontos.add(p); 
    }

    /**
     * MÉTODO GETTER:
     * Retorna a lista completa de pontos para que a camada de visão (Main) 
     * possa exibir as informações ao usuário.
     */
    public List<PontoApoio> getListaPontos() { 
        return listaPontos; 
    }
}