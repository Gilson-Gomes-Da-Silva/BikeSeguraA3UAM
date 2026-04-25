package model;

// HERANÇA: Estende a classe abstrata Perigo, aproveitando os atributos de localização e descrição
public class PerigoTransito extends Perigo {
    
    public PerigoTransito(String loc, String desc) { 
        // SUPER: Repassa os dados para o construtor da classe pai
        super(loc, desc); 
        // Define a severidade específica para este tipo de perigo
        this.severidade = "ALTA"; 
    }

    /**
     * POLIMORFISMO: Implementa o método abstrato exibirAlerta.
     * Retorna uma mensagem formatada indicando trânsito intenso no local reportado.
     */
    @Override 
    public String exibirAlerta() { 
        return "[ALERTA " + severidade + "] Trânsito Intenso: " + getLocalizacao(); 
    }
}