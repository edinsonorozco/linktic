package co.com.linktic.ws.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import co.com.linktic.ws.entities.Producto;

/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	Producto findByIdProducto (long idCargo);
	
	List<Producto> findByNombreProducto(String nombreProducto);
}
