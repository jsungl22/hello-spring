package hello.hellospring.domain;

/**
 * JPA는 ORM이라는 기술 - 객체와 관계형 데이터베이스를 매핑
 * 매핑은 어노테이션을 이용 - @Entity
 * pk 매핑 - @Id, @GeneratedValue(strategy = GenerationType.IDENTITY) (db에서 id를 자동생성해주는 기능을 indentity 전략이라고 한다)
 * @Column(name = "username") - username이라는 컬럼을 매핑
 *
 *
 *
 */

import javax.persistence.*;

// JPA가 관리하는 entity
@Entity
public class Member {

    // pk 매핑
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Column(name = "username")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
