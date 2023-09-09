package repository;

import model.Aluguel;
import model.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class AluguelRepository implements repository<Aluguel>{

    private static final List<Aluguel> alugueis = new ArrayList<>();
    @Override
    public Aluguel findOne(String id) {
        for(Aluguel a : alugueis){
            if(a.getId().equals(id)){
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Aluguel> findAll() {
        return alugueis;
    }

    @Override
    public Aluguel create(Aluguel object) {
        if(alreadyExist(object)){
            return null;
        }
        if(alugueis.size() ==0){
            object.setId("1");
            alugueis.add(object);
            return alugueis.get(0);
        }
        String newId = findNewId();
        object.setId(newId);
        alugueis.add(object);

        return alugueis.get(alugueis.size()-1);
    }
    @Override
    public void delete(String id) {
        for(Aluguel a : alugueis){
            if(a.getId().equals(id)){
                alugueis.remove(a);
            }
        }
    }

    @Override
    public Aluguel update(String id, Aluguel object) {
        for (int i = 0; i<alugueis.size(); i++){
            if(alugueis.get(i).getId().equals(id)){
                alugueis.set(i, object);
                return alugueis.get(i);
            }
        }
        return null;
    }

    private Boolean alreadyExist(Aluguel object) {
        for (Aluguel a : alugueis) {
            if (a.getId().equals(object.getId())) {
                return true;
            }
        }
        return false;
    }

    private String findNewId(){
        String lastId = alugueis.get(alugueis.size() - 1).getId();
        int newId = Integer.parseInt(lastId)+1;
        return Integer.toString(newId);
    }
}
