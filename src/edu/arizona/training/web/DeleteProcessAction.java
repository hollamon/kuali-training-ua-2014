package edu.arizona.training.web;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import edu.arizona.training.bo.Bookmark;

public class DeleteProcessAction extends BookmarksActionBase {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BookmarkForm bForm = (BookmarkForm) form;
		int bookmarkIdToDelete = Integer.parseInt(bForm.getId());
		
		List<Bookmark> bookmarks = getBookmarks(request, response);
		for (Iterator<Bookmark> iterator = bookmarks.iterator(); iterator.hasNext();) {
			Bookmark bookmark = iterator.next();
			if (bookmark.getId() == bookmarkIdToDelete) {
				iterator.remove();
				break;
			}
		}
		saveBookmarks(bookmarks, request, response);
		
		return mapping.findForward("list");
	}

}
