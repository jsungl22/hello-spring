package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private DataSource dataSource;
    private EntityManager em;
//
    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    // SpringDataJpa가 등록한 구현체를 찾아 주입받을 수 있다
//    private final MemberRepository memberRepository;

//    @Autowired
//    public SpringConfig(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//
//    }

    @Bean
    public MemberRepository memberRepository() {
//         구현 클래스만 변경
//
//         메모리에 저장
//         return new MemoryMemberRepository();
//
//         JdbcTemplate 이용
//         return new JdbcTemplateMemberRepository(dataSource);

         // JPA 이용
         return new JpaMemberRepository(em);

    }
}
