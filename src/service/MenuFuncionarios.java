package service;

import java.util.Scanner;

public class MenuFuncionarios {
    public int execute(){
        System.out.println("Digite o número da ação que deseja executar:");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar um veículo");
        System.out.println("2 - Cadastrar uma Pessoa física");
        System.out.println("3 - Cadastrar uma Pessoa juridica");
        System.out.println("4 - Buscar veículos");
        System.out.println("5 - Alterar um Veículo");
        System.out.println("6 - Alterar uma Pessoa Física");
        System.out.println("7 - Alterar uma Pessoa Jurídica");
        System.out.println("8 - Alugar um veículo para pessoa Física");
        System.out.println("9 - Alugar um veículo para pessoa Juridica");
        System.out.println("10 - Devolução de um veículo de uma pessoa Física");
        System.out.println("11 - Devolução de um veículo de uma pessoa Juridica");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

