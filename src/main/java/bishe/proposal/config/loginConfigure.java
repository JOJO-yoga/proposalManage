package bishe.proposal.config;

import bishe.proposal.service.loginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class loginConfigure extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        // 如果token表不存在，使用下面语句可以初始化该表；若存在，请注释掉这条语句，否则会报错。
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Autowired
    private loginServiceImpl userDetailsService;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.csrf().disable().
                formLogin().
                loginPage("/index").//登录页面url
                loginProcessingUrl("/login").permitAll().
                usernameParameter("Id").
                passwordParameter("password").
                defaultSuccessUrl("/testlogin/success").permitAll().
                and().
                logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/index").
                and().
                authorizeRequests().
                antMatchers("/index","/user/Register","/register/addRegisters").permitAll().
                antMatchers("/user/userManage","/user/Classification","/manager/infoManage").hasRole("ADMIN").
                antMatchers("/user/Product","/user/upload","/user/personalPage","/user/information","/user/feedback","/uploadProposal","/downloadProposal","/listProposals","/deleteProposal","/listFeedbacks","/downloadFeedback").hasRole("USER").
                antMatchers("/auditor/managePage","auditor/listProposals","auditor/downloadProposal","/auditor/deleteProposal","/auditor/personal","/auditor/informationAuditor","/auditor/completeProposal","/auditor/rejectProposal","/feedback/upload","/uploadFeedback").hasRole("AUDITOR")
                .anyRequest().authenticated().//所有请求都需要认证
                and().
                rememberMe().
                userDetailsService(userDetailsService).
                tokenRepository(persistentTokenRepository()).
                tokenValiditySeconds(3600).
                rememberMeCookieName("userNow")

        ;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/static/fonts/**")
                .antMatchers("/static/css/**")
                .antMatchers("/static/images/**");
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder())
        ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

