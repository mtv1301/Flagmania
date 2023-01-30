package springboot.example.gameofflags.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import springboot.example.gameofflags.security.jwt.JwtConfigurer;
import springboot.example.gameofflags.security.jwt.JwtTokenProvider;

@EnableWebSecurity
@Configuration
@ComponentScan("springboot.example.gameofflags")
public class SecurityConfig {
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeHttpRequests()
                    .requestMatchers("/registration", "/login")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .headers().frameOptions().disable();
    }
}
