package com.app.auth.config;

import com.app.auth.autoconfig.MyAuthenticationProvider;
import com.app.auth.dto.AuthLoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Class SecurityConfiguration
 * @Author zhangjie
 * @Description //TODO
 * @Date 2019/3/31 17:39
 * @Version 1.0
 **/
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthLoginConfig authLoginConfig;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        AuthenticationProvider authenticationProvider = new MyAuthenticationProvider();
        return authenticationProvider;
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry=http.authorizeRequests();
        //拦截过滤配置
        for (String url:authLoginConfig.getAntMatchers()){
            expressionInterceptUrlRegistry.antMatchers(url).permitAll();
        }
        expressionInterceptUrlRegistry.anyRequest().authenticated().
                and().formLogin()
                //指定登录页的路径
                .loginPage(authLoginConfig.getLoginPage())
                //指定自定义form表单请求的路径
                .loginProcessingUrl(authLoginConfig.getFormRest())
                .failureUrl(authLoginConfig.getFailureUrl())
                .defaultSuccessUrl(authLoginConfig.getDefaultSuccessUrl())
                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                .permitAll();

        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        // 加入自定义UsernamePasswordAuthenticationFilter替代原有Filter
        http .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
        //资源目录拦截处理
        for (String url:authLoginConfig.getResources()){
            web.ignoring().antMatchers(url);
        }

    }
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {    //用户登录实现
//        return new UserDetailsService() {
//            @Autowired
//            AuthUserService authUserService;
//
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//                AuthUser user = authUserService.selectUserInfo(s);
//                if (user == null){
//                    throw new UsernameNotFoundException("Username " + s + " not found");
//                }
//
//
//                Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//                authorities.add(new SimpleGrantedAuthority("user"));
//                return user;
//            }
//        };
//
//
//    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());//.passwordEncoder(passwordEncoder())
        auth.eraseCredentials(false);

        //auth.inMemoryAuthentication().withUser("123").password(new BCryptPasswordEncoder(4).encode("123")).roles("user");
        // auth.inMemoryAuthentication().withUser("111").password(new BCryptPasswordEncoder(4).encode("111")).roles("admin");
    }

}
