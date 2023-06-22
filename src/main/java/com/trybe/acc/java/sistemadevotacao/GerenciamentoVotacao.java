package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Descrição da classe.
 */
public class GerenciamentoVotacao {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private int totalVotos = 0;

  public void cadastrarPessoaCandidata(String nome, int numero) {

  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {

  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

  }

  /**
   * Método responsável por mostrar o resultado da eleição.
   */
  public void mostrarResultado() {
    if (totalVotos <= 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
  }

  public Double calcularPorcentagemVotos(int indice) {
    return null;
  }
}
