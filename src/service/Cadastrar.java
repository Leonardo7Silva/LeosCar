package service;

import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;

public class Cadastrar {
    public Veiculo cadastrarVeiculos(VeiculoRepository repository, Veiculo veiculo){
        return repository.create(veiculo);
    }

    public PessoaFisica cadastrarPessoasFisicas(PessoaFisicaRepository repository, PessoaFisica pessoa){
        return repository.create(pessoa);
    }

    public PessoaJuridica cadastrarPessoasJuridica(PessoaJuridicaRepository repository, PessoaJuridica pessoa){
        return repository.create(pessoa);
    }


}
