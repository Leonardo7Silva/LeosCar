package repository;

import model.PessoaFisica;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository implements repository<Veiculo>{
    private static final List<Veiculo> veiculos = new ArrayList<>();
    @Override
    public Veiculo findOne(String placa) {
        for (Veiculo v : veiculos){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculos;
    }

    @Override
    public Veiculo create(Veiculo object) {
        veiculos.add(object);
        return veiculos.get(veiculos.size() - 1);
    }

    @Override
    public void delete(String placa) {
        for (Veiculo v : veiculos){
            if(v.getPlaca().equals(placa)){
                veiculos.remove(v);
            }
        }
    }

    @Override
    public Veiculo update(String placa, Veiculo object) {
        for (int i = 0; i<veiculos.size(); i++){
            if(veiculos.get(i).getPlaca().equals(placa)){
                veiculos.set(i, object);
                return veiculos.get(i);
            }
        }

        return null;
    }
}
