package test;

import model.Saldo;

public class SaldoTest {
	public static void main(String args[]) {
		Saldo saldo = new Saldo();
		saldo.setCodCliente(1234);
		saldo.setSaldo(500);
		saldo.criar();
		System.out.println("seu saldo é: " + saldo.saldo());
		saldo.saque(50);
		System.out.println("seu novo saldo agora é: " + saldo.saldo());
	}

}
