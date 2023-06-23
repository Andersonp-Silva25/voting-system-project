package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Descrição da classe.
 */
public class GerenciamentoVotacao {

  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<PessoaCandidata>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<PessoaEleitora>();
  private ArrayList<String> cpfComputado = new ArrayList<String>();
  private ArrayList<String> cpfPessoaEleitora = new ArrayList<String>();
  private int totalVotos = 0;

  /**
   * Método para cadastrar a pessoa candidata caso ainda não tenha sido cadastrada.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean isNumberExist = false;

    if (this.pessoasCandidatas.size() > 0) {

      for (PessoaCandidata pessoas : pessoasCandidatas) {
        if (pessoas.getNumero() == numero) {
          isNumberExist = true;
        }
      }

      if (isNumberExist) {
        System.out.println("Número pessoa candidata já utilizado!");
      } else {
        PessoaCandidata pessoasCandidatas = new PessoaCandidata(nome, numero);
        this.pessoasCandidatas.add(pessoasCandidatas);
      }

    } else {
      this.pessoasCandidatas.add(new PessoaCandidata(nome, numero));
    }

  }

  /**
   * Método para cadastrar a pessoa eleitora caso ainda não tenha sido cadastrada.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    boolean isCpfExist = false;

    if (this.cpfPessoaEleitora.size() > 0) {
      if (this.cpfPessoaEleitora.contains(cpf)) {
        isCpfExist = true;
      }
    }

    if (!isCpfExist) {
      this.pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
      this.cpfPessoaEleitora.add(cpf);
    } else {
      System.out.println("Pessoa eleitora já cadastrada!");
    }
  }

  /**
   * Método para realizar o voto da pessoa eleitora.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean isVoted = false;

    if (this.cpfComputado.size() > 0) {
      if (this.cpfComputado.contains(cpfPessoaEleitora)) {
        isVoted = true;
      }
    }

    if (isVoted) {
      System.out.println("Pessoa eleitora já votou!");
    } else {
      for (PessoaCandidata candidato : this.pessoasCandidatas) {
        if (candidato.getNumero() == numeroPessoaCandidata) {
          candidato.receberVoto();
          this.cpfComputado.add(cpfPessoaEleitora);
          this.totalVotos += 1;
        }
      }
    }
  }

  /**
   * Método responsável por mostrar o resultado da eleição.
   */
  public void mostrarResultado() {
    if (totalVotos <= 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado.");
    } else {
      for (int x = 0; x < pessoasCandidatas.size(); x++) {
        PessoaCandidata candidato = this.pessoasCandidatas.get(x);
        System.out.println("Nome: " + candidato.getNome() + " - " + candidato.getVotos()
            + " votos ( " + this.calcularPorcentagemVotos(x) + "% )");
      }
      System.out.println("Total de votos: " + this.totalVotos);
    }
  }

  /**
   * Método responsável por calcular a porcentagem de votos por candidato.
   */
  public Double calcularPorcentagemVotos(int indice) {
    PessoaCandidata candidato = this.pessoasCandidatas.get(indice);
    double porcentagemDeVotos = ((double) candidato.getVotos() / this.totalVotos) * 100;
    return (double) Math.round(porcentagemDeVotos);
  }

}
