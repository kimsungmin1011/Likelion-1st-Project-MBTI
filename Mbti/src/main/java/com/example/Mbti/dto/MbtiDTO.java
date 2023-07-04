package com.example.Mbti.dto;

import com.example.Mbti.entity.MbtiEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MbtiDTO {
    private Long id;
    private String mbti;
    private String info;

    public MbtiDTO(String mbti, String info){
        //this.id=id;
        this.mbti=mbti;
        this.info=info;
    }

    public static MbtiDTO toMbtiDTO(MbtiEntity mbtiEntity) {
        MbtiDTO mbtiDTO = new MbtiDTO();
        mbtiDTO.setMbti(mbtiEntity.getMbti());
        mbtiDTO.setInfo(mbtiEntity.getInfo());

        return mbtiDTO;
    }
}
