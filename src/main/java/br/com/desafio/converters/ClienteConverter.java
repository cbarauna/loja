package br.com.desafio.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.desafio.models.Cliente;
import br.com.desafio.models.Produto;

@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			Cliente cliente = new Cliente();
			cliente.setId(Integer.valueOf(value));
			return cliente;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		if (obj instanceof Produto) {
			if (obj != null) {
				Cliente cliente = (Cliente) obj;
				System.out.println(String.valueOf(cliente.getId()));
				return cliente.getId().toString();
			}
		}
		return null;
	}
}
