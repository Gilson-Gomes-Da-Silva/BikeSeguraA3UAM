package model;

public class PerigoIluminacao extends Perigo {
    
    public PerigoIluminacao(String localizacao, String descricao) {
        super(localizacao, descricao);
        this.severidade = "MÉDIA";
    }

    /**
     * POLIMORFISMO: Além de exibir o local, este alerta fornece uma 
     * recomendação de segurança, demonstrando como cada classe filha 
     * pode ter uma lógica de exibição única.
     */
    @Override
    public String exibirAlerta() {
        return String.format("[ALERTA DE ILUMINAÇÃO] Trecho escuro em: %s. Recomendado uso de lanternas.", 
                             getLocalizacao());
    }
}