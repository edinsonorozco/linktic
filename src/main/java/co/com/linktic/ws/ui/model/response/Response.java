package co.com.linktic.ws.ui.model.response;

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
public class Response {
	/**
	 * 
	 */
	private int code;
	private String message;
	private Object data;

	public Response(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Response() {
		//constructor vacio
	}
}
