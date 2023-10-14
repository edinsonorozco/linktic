package co.com.linktic.ws.ui.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.linktic.ws.dto.ProductoDTO;
import co.com.linktic.ws.exception.EntityServiceException;
import co.com.linktic.ws.service.ProductoService;
import co.com.linktic.ws.ui.model.response.Response;

/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
@RequestMapping(path = "${controller.properties.base-path}") 
@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService serviceProducto;
			
	@PostMapping(value = "/createProducto")
    public Response createProducto (@Valid @RequestBody(required= true) ProductoDTO productoDTO) {
		try {
			serviceProducto.createProducto(productoDTO);
			return new Response(HttpStatus.OK.value(), "Registro Exitoso", "Guardado Exitoso");
		} catch (EntityServiceException exception) {
			return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo Guardar el registro", "Error!");
		}
	}
	
	@GetMapping(value = "/findProductoByProductoId")
	public Response findByIdCargo(@RequestParam long idProducto) {
		try {
			ProductoDTO productoFind = serviceProducto.findProductoByIdProducto(idProducto);
			return new Response(HttpStatus.OK.value(), "Busqueda Exitosa", productoFind);	
		} catch (EntityServiceException exception) {
			return new Response(HttpStatus.NO_CONTENT.value(), HttpStatus.BAD_REQUEST.name(), "No hay Datos con el parametro enviado");
		}	
	}
	
	@GetMapping(value = "/findProductoByNombreProducto")
	public Response findCArgoByNombres(@RequestParam String nombreProducto) {
		try {
			List<ProductoDTO> productoDTOFind = serviceProducto.findProductoByNombreProducto(nombreProducto);
			return new Response(HttpStatus.OK.value(), "Listado Exitoso", productoDTOFind);	
		} catch (EntityServiceException exception) {
			return new Response(HttpStatus.NO_CONTENT.value(), HttpStatus.BAD_REQUEST.name(), "No hay Datos con el parametro enviado");
		}	
	}
	
	@GetMapping(value = "/getAllProductos")
	public Response getAllCargo() {
			List<ProductoDTO> listaProducto = serviceProducto.getAll();
			ArrayList<Object> reponseAllConv = new ArrayList<>();
			if (listaProducto!=null && listaProducto.isEmpty())
			{
				return new Response(HttpStatus.NO_CONTENT.value(), HttpStatus.BAD_REQUEST.name(), reponseAllConv);
			}
			else {
				return new Response(HttpStatus.OK.value(), "Lista Total Exitosa", listaProducto);
			}		
	}
	
	@PutMapping(value = "/updateProducto")
	public Response updateCargo(@RequestParam long idProducto, @RequestParam String nombreProducto, @RequestParam String descripcionProducto, @RequestParam BigDecimal precioProducto) {
		try {
			ProductoDTO productoUpdate = serviceProducto.updateProducto(idProducto, nombreProducto, descripcionProducto,precioProducto);
			return new Response(HttpStatus.OK.value(), "Actualizacion Exitoso", productoUpdate);
		} catch (EntityServiceException exception) {
			return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo actualizar el registro", "Error en la Solicitud");
		}
	}
	
	@DeleteMapping(value = "/deleteProducto")
	public Response deleteCargo(@RequestParam long idProducto) {
		try {
			ProductoDTO productoDelete = serviceProducto.deleteProducto(idProducto);
			return new Response(HttpStatus.OK.value(), "Eliminado Exitoso",productoDelete);
		} catch (EntityServiceException exception) {
			return new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo Eliminar el registro", "Error en la Peticion");
		}
	}
}
