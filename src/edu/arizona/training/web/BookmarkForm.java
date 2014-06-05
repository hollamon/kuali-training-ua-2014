package edu.arizona.training.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BookmarkForm extends ActionForm {
	private static final long serialVersionUID = -1639013615125083285L;

	private static final int NAME_MAX_LENGTH = 30;
	private static final int URL_MAX_LENGTH = 75;
	
	private String id;
	private String name;	
	private String url;

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors ae = new ActionErrors();
		
		// name validation
		if (StringUtils.isBlank(name)) {
			ae.add("name", new ActionMessage("field.required", "Name"));
		} else {
			if (name.length() > NAME_MAX_LENGTH) {
				ae.add("name", new ActionMessage("field.tooBig", "Name", NAME_MAX_LENGTH));
			}
		}
		
		// url validation
		if (StringUtils.isBlank(url)) {
			ae.add("url", new ActionMessage("field.required", "URL"));
		} else {
			if (url.length() > URL_MAX_LENGTH) {
				ae.add("url", new ActionMessage("field.tooBig", "URL", URL_MAX_LENGTH));
			}
			if (!url.toLowerCase().startsWith("http://") && !url.toLowerCase().startsWith("https://")) {
				ae.add("url", new ActionMessage("bookmark.url.noProtocol"));
			}
		}

		return ae;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
