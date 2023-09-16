package service;

import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;

import java.util.List;

public class Listar {
    public List<Veiculo> allVeiculos(VeiculoRepository repository){
        return repository.findAll();
    }

    public List<Veiculo> allVeiculosWithName(VeiculoRepository repository, String name){
        return repository.findManyByName(name);
    }

    public Veiculo oneVeiculo(VeiculoRepository repository, String placa){
        return repository.findOne(placa);
    }

    public List<PessoaFisica> allPessoasFisicas(PessoaFisicaRepository repository){
        return repository.findAll();
    }

    public PessoaFisica onePessoasFisicas(PessoaFisicaRepository repository, String CPF){
        return repository.findOne(CPF);
    }

    public List<PessoaJuridica> allPessoasJuridicas(PessoaJuridicaRepository repository){
        return repository.findAll();
    }
    public PessoaJuridica onePessoasJuridicas(PessoaJuridicaRepository repository, String CNPJ){
        return repository.findOne(CNPJ);
    }

}
