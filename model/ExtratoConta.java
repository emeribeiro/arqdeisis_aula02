package model;

import java.sql.Date;

import to.ExtratoContaTO;
import dao.ExtratoContaDAO;

public class ExtratoConta {
	
	// atributos
	private int 	codExtratoConta;
	private Date 	dataExtrato;
	private String 	debiCredi;
	private int 	numDocumendo;
	private int 	valorOperacao;
	private int 	saldoDia;
	private String 	tipoExtrato;
	private int 	codCliente;
	
	// construtor básico
	public ExtratoConta() {
		codExtratoConta = 0;
	}
	
	// construtor padrão
	public ExtratoConta(int codExtratoConta, String debiCredi, int numDocumento,
							int valorOperacao, int saldoDia, String tipoExtrato,
								int codCliente) {
		this.codExtratoConta = codExtratoConta;
		this.debiCredi		 = debiCredi;
		this.numDocumendo	 = numDocumento;
		this.valorOperacao	 = valorOperacao;
		this.saldoDia		 = saldoDia;
		this.tipoExtrato	 = tipoExtrato;
		this.codCliente		 = codCliente;
	}
	
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
	
	public void criar() {
		ExtratoContaDAO dao = new ExtratoContaDAO();
		ExtratoContaTO  to  = new ExtratoContaTO();
		to.setDebiCredi(debiCredi);
		to.setNumDocumendo(numDocumendo);
		to.setValorOperacao(valorOperacao);
		to.setSaldoDia(saldoDia);
		to.setCodCliente(codCliente);
		dao.incluir(to);
	}
	
	public void carregar() {
		ExtratoContaDAO dao = new ExtratoContaDAO();
		ExtratoContaTO  to  = new ExtratoContaTO();
		System.out.println(dao.consultarExtrato7Dias(to.getCodCliente()));
	}
}
