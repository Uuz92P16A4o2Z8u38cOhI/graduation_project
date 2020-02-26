package cuit.hyl.graduation.security_oauth.config;

import cuit.hyl.graduation.security_oauth.config.service.UserDetailServiceImpl;
import cuit.hyl.graduation.security_oauth.config.loginHandler.LoginAccessDeniedHandler;
import cuit.hyl.graduation.security_oauth.config.loginHandler.LoginAuthenticationFailureHandler;
import cuit.hyl.graduation.security_oauth.config.loginHandler.LoginAuthenticationSuccessHandler;
import cuit.hyl.graduation.security_oauth.config.loginHandler.LoginLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private LoginAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private LoginAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private LoginAccessDeniedHandler accessDeniedHandler;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()

                .and()
                .authorizeRequests()
                // swagger start
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()

                .anyRequest()
                .authenticated()// 其他 url 需要身份认证

                .and()
                .formLogin()  // 开启登录
                .loginProcessingUrl("/user/login")
                .successHandler(authenticationSuccessHandler) // 登录成功
                .failureHandler(authenticationFailureHandler) // 登录失败
                .permitAll()

                .and()
                .logout()
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll()

                .and().rememberMe()
                .rememberMeParameter("remember")
                .rememberMeCookieName("remember")

                .and().cors().and().csrf().disable();

        http.headers().frameOptions().disable();
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler); // 无权访问
    }

    /**
     * 密码模式支持  认证管理器
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
