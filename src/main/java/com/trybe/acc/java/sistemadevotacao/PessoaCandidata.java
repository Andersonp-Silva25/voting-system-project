package com.trybe.acc.java.sistemadevotacao;

/**
 * Descrição da classe.
 */
public class PessoaCandidata extends Pessoa {

  private int numero;

  public PessoaCandidata(String nome, int numero) {
    super(nome);
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

}
