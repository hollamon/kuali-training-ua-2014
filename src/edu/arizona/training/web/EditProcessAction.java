package edu.arizona.training.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.arizona.training.bo.Bookmark;

public class EditProcessAction extends BookmarksActionBase {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkForm bForm = (BookmarkForm) form;
		int bookmarkIdToEdit = Integer.parseInt(bForm.getId());
		
		List<Bookmark> bookmarks = getBookmarks(request, response);
		Bookmark bookmarkToEdit = findBookmarkById(bookmarkIdToEdit, bookmarks);
		
		bookmarkToEdit.setName(bForm.getName());
		bookmarkToEdit.setUrl(bForm.getUrl());
		saveBookmarks(bookmarks, request, response);
		
		return mapping.findForward("list");
	}

}
