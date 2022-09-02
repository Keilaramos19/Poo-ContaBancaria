package entities;

import exceptions.BusinessException;

public class Conta {
	private Integer numero; 
	private String titular;
	private double saldo;
	private double retirarLimite;
	
	public Conta() {
	}

	public Conta(Integer numero, String titular, double saldo, double retirarLimite) {
		super();
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.retirarLimite = retirarLimite;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getRetirarLimite() {
		return retirarLimite;
	}

	public void setRetirarLimite(double retirarLimite) {
		this.retirarLimite = retirarLimite;
	}
	public void deposito(double quantia) {
		saldo+=quantia;
	}
	public void retirar(double quantia) {
		validatewithdraw(quantia);
		saldo-=quantia;
	}
	private void validatewithdraw(double quantia) {
		if(quantia>getRetirarLimite()) {
			throw new  BusinessException("Erro de saque: A quantia excede o limitede saque");
		}
		if(quantia>getSaldo()) {
			throw new  BusinessException("Erro de saque: Saldo insuficiente");
	    }
	}
}