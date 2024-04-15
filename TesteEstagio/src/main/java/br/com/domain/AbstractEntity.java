package br.com.domain;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@MappedSuperclass 
@SuppressWarnings("serial")
public abstract class AbstractEntity<Codigo extends Serializable> implements Serializable {
	
	@Id 
	private Codigo codigo; 
	
	public Codigo getCodigo() {
		return codigo;
	}

	public void setCodigo(Codigo codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "codigo = " + codigo;
	}
}