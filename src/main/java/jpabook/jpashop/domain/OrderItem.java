package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne //orderItem이 다 관계
    @JoinColumn(name = "order_id")
    private Order order;

    private int oderPrice; //주문 당시 가격
    private int count; //주문 당시 수량


}
