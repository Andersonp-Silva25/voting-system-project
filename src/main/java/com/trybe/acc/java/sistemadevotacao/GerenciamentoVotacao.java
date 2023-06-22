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

  /**
   * Método para cadastrar a pessoa candidata caso ainda não tenha sido cadastrada.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {

    boolean isNumberExist = false;

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

  }

  /**
   * Método para cadastrar a pessoa eleitora caso ainda não tenha sido cadastrada.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {

    boolean isCpfExist = false;

    for (PessoaEleitora pessoas : pessoasEleitoras) {
      if (pessoas.getCpf() == cpf) {
        isCpfExist = true;
      }
    }

    if (isCpfExist) {
      System.out.println("Pessoa eleitora já cadastrada!");
    } else {
      PessoaEleitora pessoasEleitoras = new PessoaEleitora(nome, cpf);
      this.pessoasEleitoras.add(pessoasEleitoras);
    }
  }

  /**
   * Método para realizar o voto da pessoa eleitora.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {

    boolean isVoted = false;

    for (PessoaEleitora pessoas : pessoasEleitoras) {
      if (this.cpfComputado.contains(pessoas.getCpf())) {
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
    }
  }

  public Double calcularPorcentagemVotos(int indice) {
    return null;
  }

}
