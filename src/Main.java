import model.Aluguel;
import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.AluguelRepository;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;
import service.*;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        VeiculoRepository catalogoDeVeiculos = new VeiculoRepository();
        PessoaFisicaRepository clientesFisicos = new PessoaFisicaRepository();
        PessoaJuridicaRepository clientesJuridicos = new PessoaJuridicaRepository();
        Scanner sc = new Scanner(System.in);
        Cadastrar cadastrar = new Cadastrar();
        Listar listar = new Listar();
        MenuFuncionarios menu = new MenuFuncionarios();

        System.out.println("Bem-vindo ao sistema Leo's Cars");
        System.out.println();
        int controle = menu.execute();
        System.out.println(controle);
        do {
            switch (controle) {
                case 0:
                    break;
                case 1:
                    System.out.println("Cadastrar veículo:");
                    System.out.println("digite o modelo do veículo:");
                    String modelo = sc.next();
                    System.out.println("digite a placa:");
                    String placa = sc.next();
                    System.out.println("digite o tipo:");
                    String tipo = sc.next().toUpperCase();
                    if (listar.oneVeiculo(catalogoDeVeiculos, placa) != null) {
                        System.out.println("Não é possível completar essa ação pôr:" + "Veículo existente!");
                        controle = desejaContinuar();
                        break;
                    }
                    Veiculo newVeiculo = new Veiculo(modelo, placa, tipo);
                    System.out.println(cadastrar.cadastrarVeiculos(catalogoDeVeiculos, newVeiculo).toString());
                    controle = desejaContinuar();

                case 2:
                    System.out.println("Cadastrar cliente físico:");
                    System.out.println("digite seu nome:");
                    String nome = sc.nextLine();
                    System.out.println("digite seu CPF:");
                    String cpf = sc.next();
                    if (listar.onePessoasFisicas(clientesFisicos, cpf) != null) {
                        System.out.println("Não é possível completar essa ação pôr:" + "Cliente existente!");
                        controle = desejaContinuar();
                        break;
                    }
                    PessoaFisica newCliente = new PessoaFisica(nome, cpf);
                    System.out.println(cadastrar.cadastrarPessoasFisicas(clientesFisicos, newCliente).toString());
                    controle = desejaContinuar();

                case 3:
                    System.out.println("Cadastrar cliente jurídico:");
                    System.out.println("digite seu nome fantasia:");
                    String nomeFantasia = sc.nextLine();
                    System.out.println("digite seu CNPJ:");
                    String cnpj = sc.next();
                    if (listar.onePessoasJuridicas(clientesJuridicos, cnpj) != null) {
                        System.out.println("Não é possível completar essa ação pôr:" + "Cliente existente!");
                        controle = desejaContinuar();
                        break;
                    }
                    PessoaJuridica newClienteJuridico = new PessoaJuridica(nomeFantasia, cnpj);
                    System.out.println(cadastrar.cadastrarPessoasJuridica(clientesJuridicos, newClienteJuridico).toString());
                    controle = desejaContinuar();
            }
        }while (controle != 0);

        System.out.println("Volte Sempre!");

    }
    private static int desejaContinuar(){
        Scanner scanner = new Scanner(System.in);
        MenuFuncionarios menu = new MenuFuncionarios();

        System.out.println("Ação finalizada!");
        System.out.println();
        System.out.println("Deseja executar outra ação? S/N");
        String resposta = scanner.next();
        if(resposta.equalsIgnoreCase("S")){
            int controle = menu.execute();
            return controle;
        }
        else return 0;
    }
}