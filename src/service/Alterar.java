package service;

import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;

public class Alterar {
    public Veiculo veiculo(VeiculoRepository repository, String placa, Veiculo veiculoAlterado ){
        return repository.update(placa, veiculoAlterado);
    }

    public PessoaFisica PessoaFisica(PessoaFisicaRepository repository, String CPF, PessoaFisica PessoaAlterada ){
        return repository.update(CPF, PessoaAlterada);
    }

    public PessoaJuridica PessoaJuridica(PessoaJuridicaRepository repository, String CNPJ, PessoaJuridica PessoaAlterada ){
        return repository.update(CNPJ, PessoaAlterada);
    }
}
