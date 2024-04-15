package br.com.service;

import java.util.List;
import br.com.domain.Banco;

public interface BancoService {
	
	Banco buscarPorCodigo (Integer codigo);
	List<Banco> buscarTodos ();
	
}