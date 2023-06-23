package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

/**
 * Descrição da classe.
 */
public class Principal {

  /**
   * Método principal da classe.
   */
  public static void main(String[] args) {

    int checarOpcao = 1;
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");

    while (checarOpcao == 1) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata:");
        String nome = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        gerenciamento.cadastrarPessoaCandidata(nome, numero);
      } else {
        checarOpcao = opcao;
      }
    }

    System.out.println("----------- Cadastre as pessoas eleitoras -----------");
    checarOpcao = 1;

    while (checarOpcao == 1) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora:");
        String nome = scanner.next();
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        gerenciamento.cadastrarPessoaEleitora(nome, cpf);
      } else {
        checarOpcao = opcao;
      }
    }

    System.out.println("----------- Votação iniciada! -----------");
    checarOpcao = 1;

    while (checarOpcao == 1) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      int opcao = scanner.nextInt();

      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scanner.next();
        System.out.println("Entre com o número da pessoa candidata:");
        int numero = scanner.nextInt();
        gerenciamento.votar(cpf, numero);
      } else if (opcao == 2) {
        opcao = 1;
        gerenciamento.mostrarResultado();
      } else {
        checarOpcao = opcao;
        gerenciamento.mostrarResultado();
      }
    }

    scanner.close();
  }

}
