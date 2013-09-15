package com.unnatii.in.dao;

import java.util.List;

import com.unnatii.in.model.SpecSheet;
import com.unnatii.in.model.ReplyQuote;
public interface SpecDAO {
	
	public void addSpec(SpecSheet specsheet);
	public List<SpecSheet> listSpecSheet();
	public void removeSpec(Integer id);
	public List<SpecSheet> listSpecificSpecSheet(Integer specId);
	public void addReplyQuote(ReplyQuote replyquote);
}
