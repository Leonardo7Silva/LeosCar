import model.PessoaFisica;
import model.PessoaJuridica;
import model.Veiculo;
import repository.AluguelRepository;
import repository.PessoaFisicaRepository;
import repository.PessoaJuridicaRepository;
import repository.VeiculoRepository;
import service.*;


import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        VeiculoRepository catalogoDeVeiculos = new VeiculoRepository();
        PessoaFisicaRepository clientesFisicos = new PessoaFisicaRepository();
        PessoaJuridicaRepository clientesJuridicos = new PessoaJuridicaRepository();
        AluguelRepository listaAlugueis = new AluguelRepository();
        Scanner sc = new Scanner(System.in);
        Cadastrar cadastrar = new Cadastrar();
        Listar listar = new Listar();
        Alterar alterar = new Alterar();
        Alugar alugar = new Alugar();
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
                    String placa = sc.next().toUpperCase();
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
                    break;

                case 2:
                    System.out.println("Cadastrar cliente físico:");
                    System.out.println("digite seu nome:");
                    String nome = sc.next();
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
                    break;

                case 3:
                    System.out.println("Cadastrar cliente jurídico:");
                    System.out.println("digite seu nome fantasia:");
                    String nomeFantasia = sc.next();
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
                    break;

                case 4:
                    System.out.println("Buscar veículos:");
                    System.out.println("digite o modelo do Veículo desejado:");
                    String busca = sc.next();
                    System.out.println(listar.allVeiculosWithName(catalogoDeVeiculos, busca));
                    controle = desejaContinuar();
                    break;

                case 5:
                    System.out.println("Alterar veículos:");
                    System.out.println("digite a placa do veículo que deseja alterar");
                    String placa1 = sc.next();
                    if(listar.oneVeiculo(catalogoDeVeiculos, placa1) == null){
                        System.out.println("Não é possível completar essa ação pôr:" + "Veículo inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println("digite o modelo da alteração:");
                    String modelo1 = sc.next();
                    System.out.println("digite a placa da alteração:");
                    String placa2 = sc.next().toUpperCase();
                    System.out.println("digite o tipo da alteração:");
                    String tipo1 = sc.next().toUpperCase();
                    Veiculo veiculoAlterado = new Veiculo(modelo1, placa2, tipo1);
                    System.out.println(alterar.veiculo(catalogoDeVeiculos, placa1, veiculoAlterado));
                    controle = desejaContinuar();
                    break;

                case 6:
                    System.out.println("Alterar cliente físico:");
                    System.out.println("digite o cpf do cliente que deseja alterar");
                    String cpf1 = sc.next();
                    if(listar.onePessoasFisicas(clientesFisicos, cpf1) == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Cliente inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println("digite o nome da alteração:");
                    String nome1 = sc.next();
                    System.out.println("digite o cpf da alteração:");
                    String cpf2 = sc.next().toUpperCase();
                    PessoaFisica pessoaAlterada = new PessoaFisica(nome1, cpf2);
                    System.out.println(alterar.PessoaFisica(clientesFisicos,cpf1,pessoaAlterada));
                    controle = desejaContinuar();
                    break;

                case 7:
                    System.out.println("Alterar cliente jurídico:");
                    System.out.println("digite o CNPJ do cliente que deseja alterar");
                    String cnpj1 = sc.next();
                    if(listar.onePessoasJuridicas(clientesJuridicos, cnpj1) == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Cliente inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println("digite o nome fantasia da alteração:");
                    String nomeFantasia1 = sc.next();
                    System.out.println("digite o CNPJ da alteração:");
                    String cnpj2 = sc.next().toUpperCase();
                    PessoaJuridica pessoaJuridicaAlterada = new PessoaJuridica(nomeFantasia1, cnpj2);
                    System.out.println(alterar.PessoaJuridica(clientesJuridicos, cnpj1, pessoaJuridicaAlterada));
                    controle = desejaContinuar();
                    break;

                case 8:
                    System.out.println("Alugar um veículo para pessoa Física:");
                    System.out.println("Digite o CPF do CLiente");
                    String cpf3 = sc.next();
                    PessoaFisica pessoaFisica1= listar.onePessoasFisicas(clientesFisicos,cpf3);
                    if( pessoaFisica1 == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Cliente inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println("Digite a placa do carro");
                    String placa3 = sc.next();
                    Veiculo veiculo1= listar.oneVeiculo(catalogoDeVeiculos, placa3);
                    if( veiculo1 == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Carro inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    if( veiculo1.getStatus().equalsIgnoreCase("ALUGADO")){
                        System.out.println("Não é possível completar essa ação pôr: " + "Carro alugado!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println(alugar.pessoaFisica(pessoaFisica1,veiculo1, listaAlugueis));
                    controle = desejaContinuar();
                    break;

                case 9:
                    System.out.println("Alugar um veículo para pessoa Jurídica:");
                    System.out.println("Digite o CNPJ do CLiente");
                    String CNPJ3 = sc.next();
                    PessoaJuridica pessoaJuridica1= listar.onePessoasJuridicas(clientesJuridicos,CNPJ3);
                    if( pessoaJuridica1 == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Cliente inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println("Digite a placa do carro");
                    String placa4 = sc.next();
                    Veiculo veiculo2= listar.oneVeiculo(catalogoDeVeiculos, placa4);
                    if( veiculo2 == null){
                        System.out.println("Não é possível completar essa ação pôr: " + "Carro inexistente!");
                        controle = desejaContinuar();
                        break;
                    }
                    if( veiculo2.getStatus().equalsIgnoreCase("ALUGADO")){
                        System.out.println("Não é possível completar essa ação pôr: " + "Carro alugado!");
                        controle = desejaContinuar();
                        break;
                    }
                    System.out.println(alugar.pessoaJuridica(pessoaJuridica1,veiculo2, listaAlugueis));
                    controle = desejaContinuar();
                    break;
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
            return menu.execute();
        }
        else return 0;
    }
}