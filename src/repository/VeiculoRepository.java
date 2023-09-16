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

    public List<Veiculo> findManyByName(String name) {
        List<Veiculo> newlist = new ArrayList<>();
        for (Veiculo v : veiculos){
            if(v.getModelo().contains(name)){
                newlist.add(v);
            }
        }
        return newlist;
    }

    @Override
    public List<Veiculo> findAll() {
        return veiculos;
    }

    @Override
    public Veiculo create(Veiculo object) {
        if(alreadyExist(object)){
            return null;
        }
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

    private Boolean alreadyExist(Veiculo object){
        for (Veiculo v : veiculos){
            if(v.getPlaca().equals(object.getPlaca())){
                return true;
            }
        }
        return false;
    }
}
