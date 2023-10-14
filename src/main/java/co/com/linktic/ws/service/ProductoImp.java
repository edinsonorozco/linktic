package co.com.linktic.ws.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.linktic.ws.dto.ProductoDTO;
import co.com.linktic.ws.entities.Producto;
import co.com.linktic.ws.repository.ProductoRepository;
/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
@Service
public class ProductoImp implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	private Logger log = Logger.getLogger("Log Cargo");
	
	public Producto createProducto (ProductoDTO productoDTO) {
		log.log(Level.INFO, "Inicio Guardado cargo");
		Producto producto = new Producto();		
		producto.setNombreProducto(productoDTO.getNombreProducto());
		producto.setDescripcionProducto(productoDTO.getDescripcionProducto());
		producto.setPrecioProdcuto(productoDTO.getPrecioProdcuto());
		productoRepository.save(producto);
		log.log(Level.INFO, "Termina el metodo");		
		return producto;
	}
	
	public ProductoDTO findProductoByIdProducto(long idProducto) {		
		log.log(Level.INFO, "Inicio busqueda de producto");
		Producto productoFind = productoRepository.findByIdProducto(idProducto);	
		ProductoDTO productoDto = ProductoDTO.builder()
					.idProducto(productoFind.getIdProducto())
					.nombreProducto(productoFind.getNombreProducto())
					.descripcionProducto(productoFind.getDescripcionProducto())
					.precioProdcuto(productoFind.getPrecioProdcuto())
					.build();
			log.log(Level.INFO, "Termina el metodo");
		return productoDto;
	}	
	
	public List<ProductoDTO> findProductoByNombreProducto(String nombreProducto) {
		log.log(Level.INFO, "Inicio busqueda de productos");
		List<ProductoDTO> productoArray = new ArrayList<>();
		List<Producto> listaProductos = productoRepository.findByNombreProducto(nombreProducto);
		
		for (Producto productoEach: listaProductos) {
			ProductoDTO productoDto = ProductoDTO.builder()
				.idProducto(productoEach.getIdProducto())
				.nombreProducto(productoEach.getNombreProducto())
				.descripcionProducto(productoEach.getDescripcionProducto())
				.precioProdcuto(productoEach.getPrecioProdcuto())
				.build();
			productoArray.add(productoDto);
		}
		log.log(Level.INFO, "Termina Metodo");
		return productoArray;
	}
	
	public List<ProductoDTO> getAll() {
		log.log(Level.INFO, "Inicio listado de productos");
		List<ProductoDTO> productoArray = new ArrayList<>();
		List<Producto> listaProductos = productoRepository.findAll();
		
		for (Producto productoEach: listaProductos) {			
			ProductoDTO productoDto = ProductoDTO.builder()
					.idProducto(productoEach.getIdProducto())
					.nombreProducto(productoEach.getNombreProducto())
					.descripcionProducto(productoEach.getDescripcionProducto())
					.precioProdcuto(productoEach.getPrecioProdcuto())
					.build();
			productoArray.add(productoDto);
		}
		log.log(Level.INFO, "Termina el metodo");
		return productoArray;
	}

	public ProductoDTO updateProducto(long idProducto, String nombreProducto, String descripcionProducto, BigDecimal precio) {

		log.log(Level.INFO, "Inicio Actualizacion de producto");		
		Producto productoUpdate = productoRepository.findByIdProducto(idProducto);
		productoUpdate.setNombreProducto(nombreProducto);
		productoUpdate.setDescripcionProducto(descripcionProducto);
		productoUpdate.setPrecioProdcuto(precio);
		ProductoDTO productoDto = ProductoDTO.builder()
				.idProducto(productoUpdate.getIdProducto())
				.nombreProducto(productoUpdate.getNombreProducto())
				.descripcionProducto(productoUpdate.getDescripcionProducto())
				.precioProdcuto(productoUpdate.getPrecioProdcuto())
				.build();
		productoRepository.save(productoUpdate);
		log.log(Level.INFO, "Finaliza");

		return productoDto;
	}
	
	public ProductoDTO deleteProducto(long idProducto) {

		log.log(Level.INFO, "Inicio Borrado de producto");
		Producto productoDelete = productoRepository.findByIdProducto(idProducto);
		ProductoDTO cargoDto = ProductoDTO.builder()
				.idProducto(productoDelete.getIdProducto())
				.nombreProducto(productoDelete.getNombreProducto())
				.descripcionProducto(productoDelete.getDescripcionProducto())
				.precioProdcuto(productoDelete.getPrecioProdcuto())
				.build();

		productoRepository.delete(productoDelete);

		log.log(Level.INFO, "Finalizacion del metodo");

		return cargoDto;
	}
}
