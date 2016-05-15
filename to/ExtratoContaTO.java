package to;

import java.sql.Date;

public class ExtratoContaTO {

	// atributos
	private int 	codExtratoConta;
	private Date 	dataExtrato;
	private String 	debiCredi;
	private int 	numDocumendo;
	private int 	valorOperacao;
	private int 	saldoDia;
	private String 	tipoExtrato;
	private int 	codCliente;
		
	// set's
	public void setCodExtratoConta(int codExtratoConta) 	{this.codExtratoConta = codExtratoConta;}
	
	public void setDataExtrato(Date dataExtrato) 			{this.dataExtrato = dataExtrato;}
	
	public void setDebiCredi(String debiCredi) 				{this.debiCredi = debiCredi;}
	
	public void setNumDocumendo(int numDocumendo) 			{this.numDocumendo = numDocumendo;}
	
	public void setValorOperacao(int valorOperacao) 		{this.valorOperacao = valorOperacao;}
	
	public void setSaldoDia(int saldoDia) 					{this.saldoDia = saldoDia;}
	
	public void setTipoExtrato(String tipoExtrato) 			{this.tipoExtrato = tipoExtrato;}
	
	public void setCodCliente(int codCliente) 				{this.codCliente = codCliente;}
	
	// get's
	public int getCodExtratoConta() 						{return codExtratoConta;}
	
	public Date getDataExtrato() 							{return dataExtrato;}
	
	public String getDebiCredi() 							{return debiCredi;}
	
	public int getNumDocumendo() 							{return numDocumendo;}
	
	public int getValorOperacao()							{return valorOperacao;}
	
	public int getSaldoDia() 								{return saldoDia;}
	
	public String getTipoExtrato() 							{return tipoExtrato;}
	
	public int getCodCliente() 								{return codCliente;}
}
