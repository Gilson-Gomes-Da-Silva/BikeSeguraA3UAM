package model;

public class Bicicletario extends PontoApoio {
    // ATRIBUTO ESPECÍFICO: Apenas bicicletários possuem controle de capacidade.
    private int capacidade;

    public Bicicletario(int id, String nome, String endereco, String horario, int capacidade) {
        // Inicializa os atributos da classe pai (PontoApoio)
        super(id, nome, endereco, horario);
        // Inicializa o atributo próprio desta classe
        this.capacidade = capacidade;
    }

    /* * POLIMORFISMO COM DADOS DINÂMICOS:
     * Note que aqui o comportamento do método é diferente: 
     * ele usa o atributo 'capacidade' exclusivo desta classe na mensagem.
     */
    @Override 
    public String exibirServicos() { 
        return "Vagas disponíveis: " + capacidade; 
    }
}