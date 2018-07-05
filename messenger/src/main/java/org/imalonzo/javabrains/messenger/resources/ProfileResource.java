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

import org.imalonzo.javabrains.messenger.model.Profile;
import org.imalonzo.javabrains.messenger.service.ProfileService;
import org.imalonzo.javabrains.messenger.service.ProfileService;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)	
@Produces(MediaType.APPLICATION_JSON)	
public class ProfileResource {
  ProfileService profileService = new ProfileService();	
  
  @GET
  public List<Profile> getProfiles() {
    return profileService.getAllProfiles();
  }
  
  @GET
  @Path("/{profileName}")
  public Profile getProfile(@PathParam("profileName") String profileName) {
    return profileService.getProfile(profileName);
  }	
  
  @POST
  public Profile addProfile(Profile profile) {
    return profileService.addProfile(profile);
  }
  
  @PUT
  @Path("/{profileName}")
  public Profile updateProfiles(@PathParam("profileName") String profileName, Profile profile) {
    return profileService.updateProfile(profileName, profile);
  }
  
  @DELETE 
  @Path("/{profileName}")
  public Profile removeProfile(@PathParam("profileName") String profileName) {
    return profileService.removeProfile(profileName);
  }

}