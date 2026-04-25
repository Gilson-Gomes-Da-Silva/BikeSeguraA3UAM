package model;

public class PerigoObra extends Perigo {
    // CONSTRUTOR: Uso de nomes de variáveis curtos (loc, desc), mas repassando para o super
    public PerigoObra(String loc, String desc) { 
        super(loc, desc); 
        this.severidade = "MÉDIA"; 
    }

    /**
     * POLIMORFISMO: Implementação da obrigatoriedade do método exibirAlerta.
     * Uso do método getLocalizacao() que foi definido na classe pai (Herança).
     */
    @Override 
    public String exibirAlerta() { 
        return "[ALERTA " + severidade + "] Obras na pista: " + getLocalizacao(); 
    }
}