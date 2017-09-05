package org.imalonzo.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
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
public class MessageResource {
  MessageService messageService = new MessageService();	
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)	
  public List<Message> getMessages() {
    return messageService.getAllMessages();
  }
  
  @GET
  @Path("/{messageId}")
  @Produces(MediaType.APPLICATION_JSON)	
  public Message getMessage(@PathParam("messageId") long messageId) {
    return messageService.getMessage(messageId);
  }	
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)	
  @Produces(MediaType.APPLICATION_JSON)	
  public Message addMessages(Message message) {
    return messageService.addMessage(message);
  }
  
  
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)	
  @Produces(MediaType.APPLICATION_JSON)	
  public Message updateMessages(Message message) {
    return messageService.updateMessage(message);
  }
  
  
  

}
