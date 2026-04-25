package model;

/**
 * CLASSE ABSTRATA: Define a estrutura comum para todos os pontos de apoio.
 * Por ser abstrata, impede a criação de um "PontoApoio" genérico, 
 * exigindo que seja um tipo específico (ex: Oficina).
 */
public abstract class PontoApoio {
    // ENCAPSULAMENTO: Atributos privados para garantir a integridade dos dados
    private int id;
    private String nome;
    private String endereco;
    private String horario;

    public PontoApoio(int id, String nome, String endereco, String horario) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.horario = horario;
    }

    /**
     * MÉTODO ABSTRATO: Obriga todas as classes filhas a descreverem 
     * quais serviços oferecem, garantindo o polimorfismo.
     */
    public abstract String exibirServicos();

    // GETTERS: Métodos públicos para acesso seguro aos atributos privados
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }

    /**
     * SOBRESCRITA (toString): Personaliza como o objeto é transformado em texto.
     * Facilita a exibição dos dados básicos em listas no console.
     */
    @Override
    public String toString() {
        return String.format("[%d] %s em %s (%s)", id, nome, endereco, horario);
    }
}