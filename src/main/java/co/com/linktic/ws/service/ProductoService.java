package co.com.linktic.ws.service;

import java.math.BigDecimal;
import java.util.List;
import co.com.linktic.ws.dto.ProductoDTO;
import co.com.linktic.ws.entities.Producto;

public interface ProductoService {
	
	Producto createProducto (ProductoDTO productoDTO);
	ProductoDTO findProductoByIdProducto(long idProducto);
	List<ProductoDTO> findProductoByNombreProducto(String nombreProducto);
	List<ProductoDTO> getAll();
	ProductoDTO updateProducto(long idProducto, String nombreProducto, String descripcionProducto, BigDecimal precio);
	ProductoDTO deleteProducto(long idProducto);
}
