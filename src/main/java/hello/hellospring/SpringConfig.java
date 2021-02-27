package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {

    //private DataSource dataSource;
    //private EntityManager em;
    private final MemberRepository memberRepository;


    @Autowired
    //public SpringConfig(DataSource dataSource){
    //    this.dataSource=dataSource;
    //}

    //public SpringConfig(EntityManager em){
    //    this.em=em;
    //}

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository(){
        //return new JpaMemberRepository(em);
    //}


}
