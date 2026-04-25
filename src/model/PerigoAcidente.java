package model;

// HERANÇA: Estende a classe abstrata Perigo
public class PerigoAcidente extends Perigo {
    
    public PerigoAcidente(String localizacao, String descricao) {
        // SUPER: Passa os dados para a classe pai (Perigo)
        super(localizacao, descricao);
        // ENCAPSULAMENTO/PROTECTED: Define o valor da severidade que é protegida na classe pai
        this.severidade = "MUITO ALTA";
    }

    /**
     * POLIMORFISMO: Sobrescreve o método abstrato para exibir um alerta 
     * específico para acidentes, usando a severidade "MUITO ALTA".
     */
    @Override
    public String exibirAlerta() {
        return String.format("[ALERTA DE ACIDENTE] Severidade: %s | Local: %s", 
                             this.severidade, getLocalizacao());
    }
}