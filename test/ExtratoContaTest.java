package test;

import model.ExtratoConta;

public class ExtratoContaTest {
	public static void main(String args[]) {
		ExtratoConta extrato = new ExtratoConta();
		extrato.setDebiCredi("Debito");
		extrato.setNumDocumendo(78);
		extrato.setValorOperacao(200);
		extrato.setSaldoDia(500);
		extrato.setCodCliente(1020);
		extrato.criar();
		extrato.carregar();
	}

}
