package to;

public class SaldoTO {
	// atributos da classe
	private int codSaldo;
	private int saldo;
	private int codCliente;
	
	// set's
	public void setCodSaldo(int codSaldo)		{this.codSaldo 	 = codSaldo;}
	public void setSaldo(int saldo)				{this.saldo		 = saldo;}
	public void setCodCliente(int codCliente)	{this.codCliente = codCliente;}
	
	// get's
	public int getCodSaldo()					{return codSaldo;}
	public int getSaldo()						{return saldo;}
	public int getCodCliente()					{return codCliente;}
}
