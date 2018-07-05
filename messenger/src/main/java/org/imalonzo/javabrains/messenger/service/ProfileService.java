package org.imalonzo.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.imalonzo.javabrains.messenger.database.DatabaseClass;
import org.imalonzo.javabrains.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("joe", new Profile(1,"joe", "John", "Smith"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	/*
	public long getSize() {
		return messages.size();
	}
	*/
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		
		Set<String> key = profiles.keySet();
		
		//for(String k : key) {
		//	System.out.println(profiles.get(k));
		//}
		
		//System.out.println(profiles);

		return profile;
	}
	
	public Profile updateProfile(String profileName, Profile profile) {
		System.out.println("profileName:" + profileName);
		System.out.println("profile:" + profile);
		if (! profiles.containsKey(profileName)) {
			return null;
		}
		profiles.put(profileName, profile);
		System.out.println("Profile update: " + profile.getProfileName() + ": " + profile);
		
		System.out.println(profiles);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Set<String> keys = profiles.keySet();
		for (String key : keys) {
			sb.append(profiles.get(key));
		}
		return sb.toString();
	}
}
