package com.montec.apirest.blog.two.app.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.montec.apirest.blog.two.app.dao.IUsuarioDao;
import com.montec.apirest.blog.two.app.entities.Rol;
import com.montec.apirest.blog.two.app.entities.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		if(usuario==null) {
			throw new UsernameNotFoundException("No exite ese usuario, no se encontro");
		}
		return new User(usuario.getUsername(),usuario.getPassword(),mapearRoles(usuario.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapearRoles(List<Rol> roles){
		return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}
}
