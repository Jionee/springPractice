package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @Embedded //내장 타입 사용
    private Address address;

    @OneToMany(mappedBy = "member") //회원과 주문은 1대다관계 //나는 연관관계 거울이에요~!  //Order테이블에 있는 member 필드에 의해 매핑된거야.
    //읽기전용이 됨. 여기다가ㅏ 세팅해도 세팅안됨, ORDER의 member에 세팅해야 함
    // mappedBy : 양방향 관계에서 관계의 주인을 설정해 주는 것, order테이블에 있는 member필드에 의해 매핑된거야 = 주인이 아니야
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }
}
