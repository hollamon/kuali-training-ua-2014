package edu.arizona.training.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;

import edu.arizona.training.bo.Bookmark;

public class BookmarksActionBase extends Action {

	protected static final String KEYNAME = "bookmarks";
	
	protected void saveBookmarks(List<Bookmark> bookmarks, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute(KEYNAME, bookmarks);
	}
	
	protected List<Bookmark> getBookmarks(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if ( session.getAttribute(KEYNAME) == null ) {
			List<Bookmark> bookmarks = new ArrayList<Bookmark>();
			bookmarks.add(new Bookmark(1, "Google","http://www.google.com"));
			bookmarks.add(new Bookmark(2, "Arizona","http://www.arizona.edu"));
			session.setAttribute(KEYNAME, bookmarks);
		}
		return (List<Bookmark>) session.getAttribute(KEYNAME);
	}
	
	protected Bookmark findBookmarkById(int id, List<Bookmark> bookmarks) {
		for (Bookmark bookmark : bookmarks) {
			if (id == bookmark.getId()) {
				return bookmark;
			}
		}
		return null;
	}
	
}
