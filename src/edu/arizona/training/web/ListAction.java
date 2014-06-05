package edu.arizona.training.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ListAction extends BookmarksActionBase {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// we do this here just so a new set can be instantiated if hitting this for the first time
		getBookmarks(request, response);
		
		return mapping.findForward("list");
	}

}
