package edu.arizona.training.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.arizona.training.bo.Bookmark;

public class DeleteAction extends BookmarksActionBase {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int bookmarkIdToDelete = Integer.parseInt(request.getParameter("id"));
		
		List<Bookmark> bookmarks = getBookmarks(request, response);
		Bookmark bookmarkToDelete = findBookmarkById(bookmarkIdToDelete, bookmarks);
		request.setAttribute("bookmarkToDelete", bookmarkToDelete);

		return mapping.findForward("delete");
	}

}
