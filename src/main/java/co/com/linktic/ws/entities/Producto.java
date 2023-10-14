package co.com.linktic.ws.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
*
* 
* @version 1.0.0
* @author Edinson Orozco González
* 
* */
@Getter
@Setter
@Data
@Entity
@Table(name= "producto", schema = "public")
public class Producto {

	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_producto")
    @SequenceGenerator(name = "seq_producto", sequenceName = "seq_producto", initialValue = 1, allocationSize = 1)	
	@Column(name = "id_producto")
	private long idProducto;	
	@NotEmpty(message = "El nombre no puede estar vacio o ser nulo")
	@Column(name="nombre_producto", unique=true)
	private String nombreProducto;
	@NotEmpty(message = "El estado no puede estar vacio o ser nulo")
	@Column(name="descripcion_producto")
	private String DescripcionProducto;	
	@Column(name="precio_producto")
	private BigDecimal precioProdcuto;
	
}
