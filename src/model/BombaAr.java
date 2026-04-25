package model;

// HERANÇA: Estende a classe base PontoApoio
public class BombaAr extends PontoApoio {
    public BombaAr(int id, String nome, String endereco, String horario) { 
        super(id, nome, endereco, horario); 
    }

    // POLIMORFISMO: Implementação específica para Bomba de Ar
    @Override 
    public String exibirServicos() { 
        return "Calibragem de pneus gratuita."; 
    }
}

/* A classe Oficina segue a mesma lógica, mas com uma mensagem de serviço 
   voltada para reparos mecânicos. */