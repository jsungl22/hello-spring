package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    // jpa는 EntityManager로 모든것이 동작한다
    // 스프링부트가 자동으로 EntityManager를 생성하고 데이터베이스와 연결해준다.그래서 만들어진걸 주입받으면 된다.
    private EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id); // find(타입, 식별자)
        return Optional.ofNullable(member); // 값이 없을수도 있으므로
    }

    // findByName이나 findAll 처럼 pk 기반이 아닌 여러개의 리스트를 가지고 하는것들은 JPQL을 작성해줘야 한다.

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}
