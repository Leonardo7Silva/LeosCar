package repository;

import model.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepository implements repository<PessoaFisica>{

    private static final List<PessoaFisica> clientes = new ArrayList<>();

    @Override
    public PessoaFisica findOne(String CPF) {
        for (PessoaFisica p : clientes){
            if(p.getCPF().equals(CPF)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PessoaFisica> findAll() {
        return clientes;
    }

    @Override
    public PessoaFisica create(PessoaFisica object) {
        clientes.add(object);
        return clientes.get(clientes.size() - 1);
    }

    @Override
    public void delete(String CPF) {
        for (PessoaFisica p : clientes){
            if(p.getCPF().equals(CPF)){
                clientes.remove(p);
            }
        }
    }

    @Override
    public PessoaFisica update(String CPF, PessoaFisica object) {

        for (int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getCPF().equals(CPF)){
                clientes.set(i, object);
                return clientes.get(i);
            }
        }

        return null;
    }

}
