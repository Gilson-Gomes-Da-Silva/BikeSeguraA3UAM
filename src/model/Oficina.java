package model;

/**
 * HERANÇA: A classe Oficina estende PontoApoio.
 * Isso significa que ela ganha automaticamente os atributos id, nome, endereco e horario,
 * sem precisarmos reescrevê-los aqui.
 */
public class Oficina extends PontoApoio {
    
    public Oficina(int id, String nome, String endereco, String horario) { 
        // SUPER: Repassa os dados recebidos para o construtor da classe pai (PontoApoio).
        // Isso garante que a base do objeto seja montada corretamente.
        super(id, nome, endereco, horario); 
    }

    /**
     * POLIMORFISMO (Sobrescrita de Método):
     * O método exibirServicos foi declarado como abstrato em PontoApoio.
     * Aqui na Oficina, nós implementamos a lógica específica para este tipo de ponto.
     * Quando o sistema listar os pontos, se o objeto for uma Oficina, este texto será exibido.
     */
    @Override 
    public String exibirServicos() { 
        return "Reparos mecânicos e ajustes gerais."; 
    }
}