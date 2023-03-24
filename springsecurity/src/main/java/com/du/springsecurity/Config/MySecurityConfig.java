package com.du.springsecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());

    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
                tokenRepositoryImpl.setCreateTableOnStartup(true);//自动创建表
        return tokenRepositoryImpl;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403.html");
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html").permitAll();
        http.formLogin()  //自定义自己编写的登录页面
                .loginPage("/login.html")//登陆页面的地址
                .loginProcessingUrl("/user/login")//登陆页面的请求地址
                .defaultSuccessUrl("/hello").permitAll()
                //登陆成功后跳转的页面
                .and()
                .authorizeRequests()//配置权限 哪些地址需要认证，哪些不需要
                .antMatchers("/","/hello","/user/login").permitAll()//设置哪些路径可以直接访问 不需要认证
//                .antMatchers("/hello").hasAuthority("admins")
//                .antMatchers("/hello").hasRole("dx")//当前登陆用户只有具有admins这个权限才可以访问这个路径
                .anyRequest().authenticated()
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)//以s为单位 设置有效时长
                .userDetailsService(userDetailsService)
                .and().csrf().disable();//关闭csrf防护

    }
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
}