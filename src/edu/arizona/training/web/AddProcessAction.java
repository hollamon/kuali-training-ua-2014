package edu.arizona.training.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.arizona.training.bo.Bookmark;
import edu.arizona.training.bo.BookmarkSequenceManager;

public class AddProcessAction extends BookmarksActionBase {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkForm bForm = (BookmarkForm) form;
		
		List<Bookmark> bookmarks = getBookmarks(request, response);
		
		Bookmark newBookmark = new Bookmark();
		newBookmark.setId(BookmarkSequenceManager.getNewBookmarkId(bookmarks));
		newBookmark.setName(bForm.getName());
		newBookmark.setUrl(bForm.getUrl());
		
		bookmarks.add(newBookmark);
		saveBookmarks(bookmarks, request, response);
		
		return mapping.findForward("list");
	}

}
