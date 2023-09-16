package service;

import model.Aluguel;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.AluguelRepository;

public class Alugar {

    public Aluguel pessoaFisica(PessoaFisica pessoa, Veiculo veiculo, AluguelRepository repository){
        if(veiculo.getStatus().equals("ALUGADO")){
            return null;
        }
        veiculo.setStatus("ALUGADO");
        Aluguel newAluguel = new Aluguel(pessoa,veiculo);
        return repository.create(newAluguel);
    }

    public Aluguel pessoaJuridica(PessoaJuridica pessoa, Veiculo veiculo, AluguelRepository repository){
        if(veiculo.getStatus().equals("ALUGADO")){
            return null;
        }
        veiculo.setStatus("ALUGADO");
        Aluguel newAluguel = new Aluguel(pessoa,veiculo);
        return repository.create(newAluguel);
    }
}
