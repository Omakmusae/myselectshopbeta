package com.sparta.myselectshopbeta.entity;
import com.sparta.myselectshopbeta.naver.dto.ItemDto;
import com.sparta.myselectshopbeta.dto.ProductMypriceRequestDto;
import com.sparta.myselectshopbeta.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor
public class Product extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID가 자동으로 생성 및 증가합니다.
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    @Column(nullable = false)
    private Long userId;//아직은 userId에 객체 대신 숫자

    public Product(ProductRequestDto requestDto, Long userId) {
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
        this.userId = userId;
    }

    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }

    public void updateByItemDto(ItemDto itemDto) { //스케줄러 기능을 위해 추가
        this.lprice = itemDto.getLprice();
    }

}