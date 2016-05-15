package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.SaldoTO;
import factory.ConnectionFactory;

public class SaldoDAO {
	
	public void incluir(SaldoTO to) {
		boolean sucesso = false;
		String sqlInsert = "INSERT INTO tabSaldo ( saldo, codCliente) VALUES (?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getSaldo());
			stm.setInt(2, to.getCodCliente());
			stm.execute();
			sucesso = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String consultaPorCodigo(SaldoTO to) {
		ResultSet rs;
		String retorno = "Saldo não localizado!";
		String conteudo = "";
		String sqlConsult = "SELECT saldo FROM tabSaldo WHERE codCliente = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlConsult);) {
			stm.setInt(1, to.getCodCliente());
			rs = stm.executeQuery();
			if(rs.next()) {
				to.setSaldo(rs.getInt("saldo"));
				conteudo += "R$ " + rs.getInt("saldo");
				retorno = conteudo;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public int voltarSaldo(SaldoTO to) {
		ResultSet rs;
		int retorno  = 0;
	    int conteudo = 0;
		String sql = "SELECT saldo FROM tabSaldo WHERE codCliente = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, to.getCodCliente());
			rs = stm.executeQuery();
			if(rs.next()) {
				to.setSaldo(rs.getInt("saldo"));
				conteudo += rs.getInt("saldo");
				retorno = conteudo;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public boolean alterar2(SaldoTO to) {
		boolean sucesso = false;
		String sqlChange = "UPDATE tabSaldo SET saldo = ? WHERE codCliente = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlChange);) {
			stm.setInt(1, to.getSaldo());
			stm.setInt(2, to.getCodCliente());
			stm.execute();
			sucesso = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public boolean alterar(int saldo, int codCliente) {
		boolean sucesso = false;
		String sqlChange = "UPDATE tabSaldo SET saldo = ? WHERE codCliente = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlChange);) {
			SaldoTO to = new SaldoTO();
			stm.setInt(1, to.getSaldo());
			stm.setInt(2, to.getCodCliente());
			stm.execute();
			sucesso = true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
}
