package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable //jpa의 내장타입, 어디엔가 내장이 될 수 있다.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address(){ //JPA스펙 상 protected로 만들자
    }

    public Address(String city, String street, String zipcode) { //값타입 생성자에서만 변경 가능하게 하기
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
