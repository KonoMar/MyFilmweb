package pl.konopka.myfilmweb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/movies/addMovie").authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .loginProcessingUrl("/users/customLoginPage")
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .rememberMe();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailService();
    }
}
