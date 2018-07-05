package org.imalonzo.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;

import org.imalonzo.javabrains.messenger.database.DatabaseClass;
import org.imalonzo.javabrains.messenger.model.Message;

public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Message1", "John Smith"));
		messages.put(2L, new Message(2, "Message2", "Jose Ortega"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getMessagesForYear(int year) {
	  List<Message> messagesForYear = new ArrayList<>();
	  Calendar cal = Calendar.getInstance();
	  for (Message message : messages.values()) {
	     cal.setTime(message.getCreated());
	     if (cal.get(Calendar.YEAR) == year) {
	    	 messagesForYear.add(message);
	     }
	  }
	  return messagesForYear;
	}
	 
	public List<Message> getMessagesPaginated(int start, int size) {
      List<Message>	list = new ArrayList<>(messages.values());
      if (start + size > list.size()) {
    	  return new ArrayList<>();
      }
      
      return list.subList(start, start+size);
	}	

	public Message getMessage(long id) {
		return messages.get(id);
	}

	public long getSize() {
		return messages.size();
	}
	
	public Message addMessage(Message message) {
		message.setId(new Long(messages.size() + 1));
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
