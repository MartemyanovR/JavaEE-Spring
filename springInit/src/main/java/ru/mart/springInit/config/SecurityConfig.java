package ru.mart.springInit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ru.mart.springInit.model.Permission;
import ru.mart.springInit.model.Role;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private final UserDetailsService userDetailsService;
	
	@Autowired						  
	public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
			.authorizeRequests()
				.antMatchers("/").permitAll()
			/*	.antMatchers(HttpMethod.GET, "/store/*").hasAuthority(Permission.CLIENTS_READ.getPermission())
			  	.antMatchers(HttpMethod.POST, "/store/*").hasAuthority(Permission.CLIENTS_WRITE.getPermission())
				.antMatchers(HttpMethod.DELETE, "/store/**").hasAuthority(Permission.CLIENTS_WRITE.getPermission())  */
				.anyRequest().authenticated()
			.and()
				.formLogin()					//use own form
				.loginPage("/auth/login")
				.permitAll()
				.defaultSuccessUrl("/auth/greeting")		//forward when logout
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))	//запуск выхода из системы используя POST
				.invalidateHttpSession(true)				//делаем недействительной сессию
				.clearAuthentication(true)					//очищаем аутентификацию
				.deleteCookies("JSESSIONID")				//удаляем куки
				.logoutSuccessUrl("/auth/login")			//перенаправление
				.permitAll();
		
	}
	
	
/*    // при хранении пользователя в оперативной памяти 
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
*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
		
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}
	
	@Bean
	protected DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}
	
	
}
