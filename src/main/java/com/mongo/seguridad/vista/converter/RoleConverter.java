package com.mongo.seguridad.vista.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mongo.seguridad.modelo.Role;

@FacesConverter("roleConverter")
public class RoleConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) facesContext.getApplication()
				.evaluateExpressionGet(facesContext, "#{userMB.roles}",
						List.class);

		for (Role role : roles) {
			if (role.getId().equals(value)) {
				return role;
			}
		}

		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		return object.toString();
	}
}
