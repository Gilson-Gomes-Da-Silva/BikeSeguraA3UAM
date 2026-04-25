package model;

/**
 * CLASSE ABSTRATA: Não podemos criar um objeto "Perigo" diretamente.
 * Ela serve apenas como um molde para tipos específicos de perigos.
 * Isso garante que todos os perigos do sistema tenham localização e descrição.
 */
public abstract class Perigo {
    // ENCAPSULAMENTO: Atributos privados para segurança dos dados
    private String localizacao;
    private String descricao;
    
    // PROTECTED: Permite que as classes filhas (PerigoTransito, etc) acessem diretamente este atributo
    protected String severidade;

    public Perigo(String localizacao, String descricao) {
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

    /**
     * MÉTODO ABSTRATO: Não possui corpo aqui. 
     * Ele obriga todas as classes filhas a implementarem o método 'exibirAlerta()'.
     * É um contrato de comportamento.
     */
    public abstract String exibirAlerta();

    // MÉTODOS GETTERS: Fornecem acesso controlado aos dados para as outras camadas (Service/Main)
    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}