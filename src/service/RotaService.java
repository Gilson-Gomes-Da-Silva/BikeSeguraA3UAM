package service;
import model.Rota;
import java.util.ArrayList;
import java.util.List;

public class RotaService {
    // Armazenamento em memória das rotas cadastradas
    private List<Rota> listaRotas = new ArrayList<>();

    public void cadastrarRota(Rota r) { 
        listaRotas.add(r); 
    }

    /**
     * MÉTODO DE BUSCA E FILTRAGEM:
     * Percorre a lista de rotas comparando as Strings de partida e destino.
     * Usa 'equalsIgnoreCase' para ignorar letras maiúsculas/minúsculas na busca.
     */
    public List<Rota> buscarRota(String partida, String destino) {
        List<Rota> encontradas = new ArrayList<>();
        
        for (Rota r : listaRotas) {
            // Lógica de comparação: Se o início e o fim coincidirem, adiciona à lista de resultados
            if (r.getPontoInicio().equalsIgnoreCase(partida) && r.getPontoFim().equalsIgnoreCase(destino)) {
                encontradas.add(r);
            }
        }
        return encontradas; // Retorna uma lista (pode ser vazia ou com várias opções)
    }

    public List<Rota> getListaRotas() { return listaRotas; }
}