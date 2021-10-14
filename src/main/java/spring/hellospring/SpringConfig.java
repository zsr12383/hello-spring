package spring.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import spring.hellospring.repository.*;
import spring.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private final DataSource dataSource;        //혹은 컨스트럭터아닌 여기에 바로 오토와이어드로도 가능
//    @Autowired                                    //jdbc
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;                     //jpa
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;        //spring data jpa
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository();
//        return new JpaMemberRepository(em);
//    }
}