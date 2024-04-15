package br.com.dao;

import java.util.List;
import br.com.domain.Banco;

public interface BancoDao {
	
	Banco findByCodigo (Integer codigo);
	List<Banco> findAll ();
	
}