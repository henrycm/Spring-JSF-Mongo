package com.mongo.seguridad.vista.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.mongo.seguridad.modelo.Permission;

@FacesConverter("permissionConverter")
public class PermissionConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component,
			String value) {
		@SuppressWarnings("unchecked")
		List<Permission> perms = (List<Permission>) facesContext
				.getApplication().evaluateExpressionGet(facesContext,
						"#{userMB.permissions}", List.class);

		for (Permission p : perms) {
			if (p.getId().equals(value)) {
				return p;
			}
		}

		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent component,
			Object object) {
		return object.toString();
	}
}
