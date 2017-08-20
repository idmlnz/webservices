package org.imalonzo.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.imalonzo.javabrains.messenger.model.Message;
import org.imalonzo.javabrains.messenger.model.Profile;

public class DatabaseClass {
  private static Map<Long, Message> messages = new HashMap<>();
  private static Map<Long, Message> profiles = new HashMap<>();
  
  public static Map<Long, Message> getMessages() {
	  return messages;
  }
  public static Map<Long, Message> getProfiles() {
	  return profiles;
  }
}
