package co.com.linktic.ws.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
@Builder
@Setter
@Getter
@AllArgsConstructor()
public class ProductoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	private long idProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private BigDecimal precioProdcuto;
	
	public ProductoDTO() {
		
	}

}
