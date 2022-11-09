package liga.medical.person_service.core.config.security;

import liga.medical.person_service.core.service.api.RoleService;
import liga.medical.person_service.core.service.api.UserService;
import liga.medical.person_service.core.service.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public SecurityConfig(@Lazy UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public SecurityConfig(boolean disableDefaults, UserService userService, RoleService roleService) {
        super(disableDefaults);
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                //Доступ только для не зарегистрированных пользователей
                .antMatchers("/registration").not().fullyAuthenticated()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                //Доступ для пользователей с любыми ролями
                .antMatchers(HttpMethod.GET, "/**").hasAnyAuthority(roleService.getAll().stream().map(RoleDto::getName).toArray(String[]::new))
                //Доступ для Админа
                .antMatchers(HttpMethod.POST, "/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/**").hasAuthority("ADMIN")
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/resources/**").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .httpBasic()
                .and()
                .logout()
                // логаут разрешаем всем
                .permitAll()
                // после логаута отправляем на стартовую страницу
                .logoutSuccessUrl("/")
                //выклчаем кроссдоменную секьюрность (на этапе обучения неважна)
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder((bCryptPasswordEncoder()));
    }
}
