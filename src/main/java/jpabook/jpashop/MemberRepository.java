package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId(); //저장을 하고 난 후 return 값을 id로 하여 후에 조회 가능하도록함
    }
    public Member find(Long id){
        return em.find(Member.class,id);
    }
}
