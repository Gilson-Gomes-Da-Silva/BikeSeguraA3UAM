package model;

// HERANÇA: 'Bebedouro' herda todas as características de 'PontoApoio'.
public class Bebedouro extends PontoApoio {
    
    public Bebedouro(int id, String nome, String endereco, String horario) { 
        // SUPER: Chama o construtor da classe pai (PontoApoio) para repassar os dados.
        super(id, nome, endereco, horario); 
    }

    /* * POLIMORFISMO:
     * O método 'exibirServicos' é definido na classe pai como abstrato.
     * Aqui, nós o sobrescrevemos (@Override) para dar o comportamento específico de um bebedouro.
     */
    @Override 
    public String exibirServicos() { 
        return "Água potável gratuita."; 
    }
}