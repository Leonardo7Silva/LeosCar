package service;

import model.Aluguel;
import model.Veiculo;
import repository.AluguelRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Devolver {

    public Aluguel devolucao(Aluguel aluguel, String tipoPessoa) {
        aluguel.setDataEntrega(LocalDateTime.now());
        LocalDateTime dataInicial = aluguel.getDataInicio();
        LocalDateTime dataEntrega = aluguel.getDataEntrega();
        long horasDecorridas = dataInicial.until(dataEntrega, ChronoUnit.HOURS);
        long diarias = horasDecorridas / 24;
        if (horasDecorridas % 24 != 0) {
            diarias++;
        }
        if (aluguel.getVeiculo().getTipo().equals("PEQUENO")) {
            double total = diarias * 100;
            if(tipoPessoa.equalsIgnoreCase("física")){
                total = descontoFisica(diarias, total);
            }
            if(tipoPessoa.equalsIgnoreCase("jurídica")){
                total = descontoJuridica(diarias,total);
            }
            aluguel.setValorTotal(String.valueOf(total));
        }
        if (aluguel.getVeiculo().getTipo().equals("MÉDIO")) {
            double total = diarias * 150;
            if(tipoPessoa.equalsIgnoreCase("física")){
                total = descontoFisica(diarias, total);
            }
            if(tipoPessoa.equalsIgnoreCase("jurídica")){
                total = descontoJuridica(diarias,total);
            }
            aluguel.setValorTotal(String.valueOf(total));
        }
        if (aluguel.getVeiculo().getTipo().equals("SUV")) {
            double total = diarias * 200;
            if(tipoPessoa.equalsIgnoreCase("física")){
                total = descontoFisica(diarias, total);
            }
            if(tipoPessoa.equalsIgnoreCase("jurídica")){
                total = descontoJuridica(diarias,total);
            }
            aluguel.setValorTotal(String.valueOf(total));
        }
        aluguel.setStatus("CONCLUÍDO");
        aluguel.getVeiculo().setStatus("DISPONÍVEL");

        return aluguel;
    }
    private double descontoFisica(long diarias, double total){
        if(diarias > 5){
            return total*0.95;
        }
        return total;
    }

    private double descontoJuridica(long diarias, double total){
        if(diarias > 3){
            return total*0.90;
        }
        return total;
    }
}
