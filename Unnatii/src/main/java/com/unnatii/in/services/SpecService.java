package com.unnatii.in.services;

import java.util.List;

import com.unnatii.in.model.ReplyQuote;
import com.unnatii.in.model.SpecSheet;;

public interface SpecService {
	
	public void addSpec(SpecSheet specsheet);
	public List<SpecSheet> listSpecSheet();
	public void removeSpec(Integer id);
	public List<SpecSheet> listSpecificSpecSheet(Integer specId);
	public void addReplyQuote(ReplyQuote replyquote);
}
