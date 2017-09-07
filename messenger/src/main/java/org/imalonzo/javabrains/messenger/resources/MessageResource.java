package org.imalonzo.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.imalonzo.javabrains.messenger.model.Message;
import org.imalonzo.javabrains.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)	
@Produces(MediaType.APPLICATION_JSON)	
public class MessageResource {
  MessageService messageService = new MessageService();	
  
  @GET
  public List<Message> getMessages() {
    return messageService.getAllMessages();
  }
  
  @GET
  @Path("/{messageId}")
  public Message getMessage(@PathParam("messageId") long messageId) {
    return messageService.getMessage(messageId);
  }	
  
  @POST
  public Message addMessages(Message message) {
    return messageService.addMessage(message);
  }
  
  @PUT
  @Path("/{messageId}")
  public Message updateMessages(@PathParam("messageId") long messageId, Message message) {
    message.setId(messageId); 
    return messageService.updateMessage(message);
  }
  
  @DELETE 
  @Path("/{messageId}")
  public Message ssages(@PathParam("messageId") long messageId) {
    return messageService.removeMessage(messageId);
  }

}
