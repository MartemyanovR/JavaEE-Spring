package ru.mart.springInit.model;

import java.util.Set;
import java.util.stream.*;

import org.springframework.security.core.authority.SimpleGrantedAuthority;


public enum Role {
	
	USER(Stream.of(Permission.CLIENTS_READ).collect(Collectors.toSet()))
	, ADMIN(Stream.of(Permission.CLIENTS_READ,Permission.CLIENTS_WRITE).collect(Collectors.toSet()));
	
	private final Set<Permission> permissions;
	
	
	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	/**
	 * Конвертируем наши разрешения, в класс SimpleGrantedAuthority 
	 * @return Set преобразованных permission 
	 */
	public Set<SimpleGrantedAuthority> getAuthority() {		
		return getPermissions().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission())).
				collect(Collectors.toSet());
	}

}
