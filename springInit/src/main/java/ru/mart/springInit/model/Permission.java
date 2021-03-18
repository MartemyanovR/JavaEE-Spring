package ru.mart.springInit.model;

public enum Permission {
	
	CLIENTS_READ("Client:read"),
	CLIENTS_WRITE("Client:write");

	private final String permission;
	
	private Permission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
}
