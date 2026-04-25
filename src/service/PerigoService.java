package service;
import model.Perigo;
import java.util.ArrayList;
import java.util.List;

public class PerigoService {
    // POLIMORFISMO: Esta lista pode guardar PerigoTransito, PerigoObra, etc.
    private List<Perigo> listaPerigos = new ArrayList<>();

    // O método recebe o tipo pai (Perigo), aceitando qualquer classe filha
    public void cadastrarPerigo(Perigo p) { 
        listaPerigos.add(p); 
    }

    public List<Perigo> getListaPerigos() { return listaPerigos; }
}