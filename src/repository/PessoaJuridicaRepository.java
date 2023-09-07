package repository;

import model.PessoaFisica;
import model.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepository implements repository<PessoaJuridica>{

    private static final List<PessoaJuridica> clientes = new ArrayList<>();
    @Override
    public PessoaJuridica findOne(String CNPJ) {
        for (PessoaJuridica p : clientes){
            if(p.getCNPJ().equals(CNPJ)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<PessoaJuridica> findAll() {
        return clientes;
    }

    @Override
    public PessoaJuridica create(PessoaJuridica object) {
        clientes.add(object);
        return clientes.get(clientes.size() - 1);
    }

    @Override
    public void delete(String CNPJ) {
        for (PessoaJuridica p : clientes){
            if(p.getCNPJ().equals(CNPJ)){
                clientes.remove(p);
            }
        }
    }

    @Override
    public PessoaJuridica update(String CNPJ, PessoaJuridica object) {
        for (int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getCNPJ().equals(CNPJ)){
                clientes.set(i, object);
                return clientes.get(i);
            }
        }

        return null;
    }
}
