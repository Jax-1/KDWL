package com.app.auth.config;

import com.app.auth.dto.AuthLoginConfig;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
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
                .failureUrl("/login?error")
                .defaultSuccessUrl("/success")
                //必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
                //这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
                .permitAll();

        //默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
        http .csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        super.configure(web);
        //资源目录拦截处理
//        for (String url:authLoginConfig.getResources()){
//            web.ignoring().antMatchers(url);
//        }

    }
}
