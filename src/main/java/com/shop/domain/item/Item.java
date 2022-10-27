package com.shop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity  //객체 = 테이블명
@Table(name = "item")
@Getter @Setter
public class Item {
    //PK
    @Id                         //DB 에서 값을 넣어주는 전략(ex: MySQL auto increment)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    @Column(name = "item_id")
    private Long id;            //상품 ID

    @Column(name = "item_name", length = 30)
    private String itemName;    //상품명
    private Integer price;      //가격
    private Integer quantity;   //수량
    private String content; //내용


    //JPA 는 기본 생성자가 필수이다
    public Item() {
    }

    // id를 제외한 생성자
    public Item(String itemName, Integer price, Integer quantity, String content) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.content = content;
    }
}
