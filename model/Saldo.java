package model;

import dao.SaldoDAO;
import to.SaldoTO;

public class Saldo {
	// atributos da classe
	private int codSaldo;
	private int saldo;
	private int codCliente;
	
	public Saldo() {}
	
	//construtor padrão
	public Saldo(int codSaldo, int saldo, int codCliente) {
		this.codSaldo 	= codSaldo;
		this.saldo	  	= saldo;
		this.codCliente = codCliente;
	}
	
	// set's
	public void setCodSaldo(int codSaldo) 		{this.codSaldo 	 = codSaldo;}
	public void setSaldo(int saldo)				{this.saldo	   	 = saldo;}
	public void setCodCliente(int codCliente)	{this.codCliente = codCliente;}
	
	//get's
	public int getCodSaldo()					{return codSaldo;}
	public int getSaldo()						{return saldo;}
	public int getCodClietne()					{return codCliente;}
	
	public void criar() {
		SaldoDAO dao = new SaldoDAO();
		SaldoTO  to	 = new SaldoTO();
		to.setSaldo(saldo);
		to.setCodCliente(codCliente);
		dao.incluir(to);
	}
	
	public void carregar() {
		SaldoDAO dao = new SaldoDAO();
		SaldoTO  to  = new SaldoTO();
		to.setCodCliente(codCliente);
		System.out.println(dao.voltarSaldo(to));
	}
	
	public int saldo() {
		SaldoDAO dao = new SaldoDAO();
		SaldoTO  to  = new SaldoTO();
		to.setCodCliente(codCliente);
		return dao.voltarSaldo(to);
	}
	
	public void saque(int saque) {
		SaldoDAO dao = new SaldoDAO();
		int valor = 0;
		valor = saldo() - saque;
		dao.alterar(valor, codCliente);
	}

}
