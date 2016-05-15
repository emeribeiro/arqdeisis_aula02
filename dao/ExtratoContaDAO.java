package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.ResultSet;

import factory.ConnectionFactory;
import to.ExtratoContaTO;

public class ExtratoContaDAO {
	
	public void incluir(ExtratoContaTO to) {
		Date minhaData = new Date(0);
		long mili = minhaData.getTime();
		java.sql.Date dataSQL = new java.sql.Date(mili);
		
		String sqlInsert = "INSERT INTO tabExtratoConta (dataExtrato,"
         		+ " debiCredi, numDocum, valorOpera, saldoDia,"
         		+ " tipoExtrato, codCliente) "
         		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert)) {
			stm.setDate(1, dataSQL);
			stm.setString(2, to.getDebiCredi());
			stm.setInt(3, to.getNumDocumendo());
			stm.setInt(4, to.getValorOperacao());
			stm.setInt(5, to.getSaldoDia());
			stm.setString(6, to.getTipoExtrato());
			stm.setInt(7, to.getCodCliente());
			stm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Date alterarData(int dias, Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DATE, dias);
		return (Date) calendar.getTime();
	}
	
	public String consultaExtrato(ExtratoContaTO to) {
		Date minhaData = new Date(0);
		long mili = minhaData.getTime();
		java.sql.Date dataSQL = new java.sql.Date(mili);
	    ResultSet rs;
	    String retorno  = "Extrato nao localizado !";
	    String conteudo = "";
	    
	    String sql = "select * from tabExtratoConta where dataExtrato <= '"+dataSQL+"' and dataExtrato >= ?"+
       		 " and codCliente = ?";
	    try(Connection conn = ConnectionFactory.obtemConexao();
	    		PreparedStatement stm = conn.prepareStatement(sql)) {
	    	stm.setDate(1, to.getDataExtrato());
	    	rs = stm.executeQuery();
	    	while(rs.next()) {
	    		conteudo += "Tipo Extrato  : " +  rs.getString("tipoExtrato")      + "\n";
	            conteudo += "Data Extrato  : " +  rs.getDate   ("dataExtrato")    + "\n";
	            conteudo += "Debito/Credito: " +  rs.getString("debiCredi") + "\n";
	            conteudo += "Nº Documento  : " +  rs.getInt("numDocum") + "\n";
	            conteudo += "Valor Operação: R$" +  rs.getInt("valorOpera")     + "\n";
	            conteudo += "Saldo do dia  : R$" +  rs.getInt("saldoDia")     + "\n\n";	
	            retorno = conteudo;
	    	}
	    	stm.execute();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return retorno;
	}
	
	public String consultarExtrato7Dias(int codCliente) {
		Date minhaData = alterarData(-7,new Date(0));
		long mili = minhaData.getTime();
		java.sql.Date dataSQL = new java.sql.Date(mili);
		ResultSet rs;
	    String retorno  = "Extrato nao localizado !";
	    String conteudo = "";
		
		String sql = "select * from tabExtratoConta where dataExtrato >= '"+ dataSQL+
       		 "' and codCliente = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, codCliente);
			rs = stm.executeQuery();
			while(rs.next()) {
				conteudo += "Tipo Extrato  : " +  rs.getString("tipoExtrato")      + "\n";
	            conteudo += "Data Extrato  : " +  rs.getDate   ("dataExtrato")    + "\n";
	            conteudo += "Debito/Credito: " +  rs.getString("debiCredi") + "\n";
	            conteudo += "Nº Documento  : " +  rs.getInt("numDocum") + "\n";
	            conteudo += "Valor Operação: R$" +  rs.getInt("valorOpera")     + "\n";
	            conteudo += "Saldo do dia  : R$" +  rs.getInt("saldoDia")     + "\n\n";		
	            retorno = conteudo;
			}
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public String consultarExtrato15Dias(ExtratoContaTO to) {
		Date minhaData = alterarData(-15,new Date(0));
		long mili = minhaData.getTime();
		java.sql.Date dataSQL = new java.sql.Date(mili);
		ResultSet rs;
	    String retorno  = "Extrato nao localizado !";
	    String conteudo = "";
	    
	    String sql = "select * from tabExtratoConta where dataExtrato >= '"+ dataSQL+
       		 "' and codCliente = ?";
	    try(Connection conn = ConnectionFactory.obtemConexao();
	    		PreparedStatement stm = conn.prepareStatement(sql)) {
	    	stm.setInt(1, to.getCodCliente());
	    	rs = stm.executeQuery();
	    	while(rs.next()) {
	    		conteudo += "Tipo Extrato  : " +  rs.getString("tipoExtrato")      + "\n";
	            conteudo += "Data Extrato  : " +  rs.getDate   ("dataExtrato")    + "\n";
	            conteudo += "Debito/Credito: " +  rs.getString("debiCredi") + "\n";
	            conteudo += "Nº Documento  : " +  rs.getInt("numDocum") + "\n";
	            conteudo += "Valor Operação: R$" +  rs.getInt("valorOpera")     + "\n";
	            conteudo += "Saldo do dia  : R$" +  rs.getInt("saldoDia")     + "\n\n";	
	            retorno = conteudo;
	    	}
	    	stm.execute();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return retorno;
	}
	
	public String consultaTransacoes(ExtratoContaTO to) {
		ResultSet rs;
	    String retorno  = "Transação nao localizado !";
	    String conteudo = "";
	    
	    String sql = "select * from tabExtratoConta where tipoExtrato = ?"+
       		 " and codCliente = ?";
	    try(Connection conn = ConnectionFactory.obtemConexao();
	    		PreparedStatement stm = conn.prepareStatement(sql)) {
	    	rs = stm.executeQuery();
	    	while(rs.next()) {
	    		conteudo += "Tipo Extrato  : " +  rs.getString("tipoExtrato")      + "\n";
	            conteudo += "Data Extrato  : " +  rs.getDate   ("dataExtrato")    + "\n";
	            conteudo += "Debito/Credito: " +  rs.getString("debiCredi") + "\n";
	            conteudo += "Nº Documento  : " +  rs.getInt("numDocum") + "\n";
	            conteudo += "Valor Operação: R$" +  rs.getInt("valorOpera")     + "\n";
	            conteudo += "Saldo do dia  : R$" +  rs.getInt("saldoDia")     + "\n\n";		
	            retorno = conteudo;
	    	}
	    	stm.execute();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return retorno;
	}
}
