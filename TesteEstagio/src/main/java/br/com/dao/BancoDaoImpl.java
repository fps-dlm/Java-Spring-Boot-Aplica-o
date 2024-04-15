package br.com.dao;

import org.springframework.stereotype.Repository;
import br.com.domain.Banco;

@Repository
public class BancoDaoImpl extends AbstractDao<Banco, Integer> implements BancoDao {

}