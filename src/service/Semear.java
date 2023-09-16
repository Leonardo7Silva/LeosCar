package service;

import model.Aluguel;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.AluguelRepository;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;

import java.time.LocalDateTime;

public class Semear {
    public void semearVeiculos(VeiculoRepository repository){
        Veiculo veiculo1 = new Veiculo("GOL", "ABC1234", "PEQUENO");
        Veiculo veiculo2 = new Veiculo("UNO", "AAA2222", "PEQUENO");
        Veiculo veiculo3 = new Veiculo("SOUL", "BBB3333", "MÉDIO");
        Veiculo veiculo4 = new Veiculo("RENEGADE", "DDD4444", "MÉDIO");
        Veiculo veiculo5 = new Veiculo("PULSE", "EEE5555", "SUV");
        Veiculo veiculo6 = new Veiculo("KICKS", "FFF6666", "SUV");

        repository.create(veiculo1);
        repository.create(veiculo2);
        repository.create(veiculo3);
        repository.create(veiculo4);
        repository.create(veiculo5);
        repository.create(veiculo6);
    }

    public void semearPessoasFisicas(PessoaFisicaRepository repository){
        PessoaFisica Pessoa1 = new PessoaFisica("Leonardo", "12345678900");
        PessoaFisica Pessoa2 = new PessoaFisica("Bianca", "00000000000");
        PessoaFisica Pessoa3 = new PessoaFisica("Adriana", "11111111111");
        PessoaFisica Pessoa4 = new PessoaFisica("Stephany", "22222222222");
        PessoaFisica Pessoa5 = new PessoaFisica("Lene", "33333333333");
        PessoaFisica Pessoa6 = new PessoaFisica("Wilton", "44444444444");

        repository.create(Pessoa1);
        repository.create(Pessoa2);
        repository.create(Pessoa3);
        repository.create(Pessoa4);
        repository.create(Pessoa5);
        repository.create(Pessoa6);
    }

    public void semearPessoasJuridicas(PessoaJuridicaRepository repository){
        PessoaJuridica Pessoa1 = new PessoaJuridica("LLLLLLL", "12345678900");
        PessoaJuridica Pessoa2 = new PessoaJuridica("BBBBBBBB", "00000000000");
        PessoaJuridica Pessoa3 = new PessoaJuridica("AAAAAAAA", "11111111111");
        PessoaJuridica Pessoa4 = new PessoaJuridica("SSSSSSSS", "22222222222");
        PessoaJuridica Pessoa5 = new PessoaJuridica("EEEEEEEEE", "33333333333");
        PessoaJuridica Pessoa6 = new PessoaJuridica("WWWWWWWW", "44444444444");

        repository.create(Pessoa1);
        repository.create(Pessoa2);
        repository.create(Pessoa3);
        repository.create(Pessoa4);
        repository.create(Pessoa5);
        repository.create(Pessoa6);
    }

    public void semearAlugueis(AluguelRepository aluguelRepository, PessoaFisicaRepository pessoaFisicaRepository, PessoaJuridicaRepository pessoaJuridicaRepository, VeiculoRepository veiculoRepository){
        Alugar alugar = new Alugar();
        PessoaFisica pessoaFisica = pessoaFisicaRepository.findOne("11111111111");
        PessoaJuridica pessoaJuridica = pessoaJuridicaRepository.findOne("11111111111");
        Veiculo veiculo1 = veiculoRepository.findOne("AAA2222");
        Veiculo veiculo2 = veiculoRepository.findOne("FFF6666");


        Aluguel aluguel1 = alugar.pessoaFisica(pessoaFisica,veiculo1,aluguelRepository);
        Aluguel aluguel2 = alugar.pessoaJuridica(pessoaJuridica, veiculo2, aluguelRepository);

        aluguel1.setDataInicio(LocalDateTime.of(2023,9,10,12,10));
        aluguel2.setDataInicio(LocalDateTime.of(2023,8,15,20,30));

    }
}
