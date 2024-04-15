package br.com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.dao.BancoDao;
import br.com.domain.Banco;

@Service @Transactional(readOnly = true)
public class BancoServiceImpl implements BancoService {
	
	@Autowired
	private BancoDao dao;
	
	@Override
	public Banco buscarPorCodigo(Integer codigo) {
		return dao.findByCodigo(codigo);
	}

	@Override
	public List<Banco> buscarTodos() {
		return dao.findAll();
	}
}