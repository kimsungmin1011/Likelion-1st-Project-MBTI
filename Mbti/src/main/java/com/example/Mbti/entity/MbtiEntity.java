package com.example.Mbti.entity;

import com.example.Mbti.dto.MbtiDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="mbti_table")
public class MbtiEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String mbti;
    @Column
    private String info;

    public MbtiEntity(String mbti, String info){
        this.mbti=mbti;
        this.info=info;
    }

}
