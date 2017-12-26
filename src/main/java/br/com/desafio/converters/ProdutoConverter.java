package br.com.desafio.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.desafio.models.Produto;

@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			Produto produto = new Produto();
			produto.setId(Integer.valueOf(value));
			return produto;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object obj) {
		if (obj instanceof Produto) {
			if (obj != null) {
				Produto produto = (Produto) obj;
				return produto.getId().toString();
			}
		}
		return null;
	}
}
