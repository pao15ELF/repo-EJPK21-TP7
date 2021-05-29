package ar.edu.unju.fi.tp4.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tp4.models.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Long>{

	public List<Producto> findByCompra(Long id);
}
