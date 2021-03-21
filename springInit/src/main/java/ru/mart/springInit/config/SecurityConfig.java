package ru.mart.springInit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ru.mart.springInit.model.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
			  /*.antMatchers(HttpMethod.GET, "/store/*").hasAuthority(Permission.CLIENTS_READ.getPermission())
				.antMatchers(HttpMethod.POST, "/store/*").hasAuthority(Permission.CLIENTS_WRITE.getPermission())
				.antMatchers(HttpMethod.DELETE, "/store/**").hasAuthority(Permission.CLIENTS_WRITE.getPermission())  */
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/auth/login")
				.permitAll()
				.defaultSuccessUrl("/auth/greeting")
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/auth/login")
				.permitAll();
		
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
				User.builder()
					.username("admin")
					.password(passwordEncoder().encode("admin"))  //кодируем пароль с помощью BCryptPasswordEncoder
					.authorities(Role.ADMIN.getAuthority()).
					build(),
				User.builder()
					.username("user")
					.password(passwordEncoder().encode("user"))
					.authorities(Role.USER.getAuthority())
					.build()
				);
				
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
	
	
	
}
