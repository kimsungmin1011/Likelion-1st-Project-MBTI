package com.example.Mbti;

import com.example.Mbti.dto.MbtiDTO;
import com.example.Mbti.entity.MbtiEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class MbtiService {
    private final MbtiRepository mbtiRepository;

    public MbtiService(MbtiRepository mbtiRepository){
        this.mbtiRepository=mbtiRepository;
    }

    public void save(MbtiDTO mbtiDTO){
        mbtiRepository.save(new MbtiEntity(mbtiDTO.getMbti(), mbtiDTO.getInfo()));
    }

    public List<MbtiDTO> getList(){
        return mbtiRepository.findAll().stream()
                .map(mbti ->new MbtiDTO(mbti.getId(), mbti.getMbti(), mbti.getInfo()))
                .collect(Collectors.toList());
    }

    /*@Transactional
    public MbtiDTO findByMbti(String mbti){
        Optional<MbtiEntity> optionalMbtiEntity=mbtiRepository.findByMbti(mbti);
        if(optionalMbtiEntity.isEmpty()){
            return null;
        } else {
            MbtiEntity mbtiEntity=optionalMbtiEntity.get();
            MbtiDTO mbtiDTO = MbtiDTO.toMbtiDTO(mbtiEntity);
            return mbtiDTO;
        }
    }*/
    @Transactional
    public List<MbtiDTO> findByMbti(String mbti){
        List<MbtiEntity> optionalMbtiEntity=mbtiRepository.findByMbti(mbti);
        if(optionalMbtiEntity.isEmpty()){
            return null;
        } else {
            List<MbtiDTO> mbtiEntity=mbtiRepository.findByMbti(mbti).stream()
                    .map(mbti2 ->new MbtiDTO(mbti2.getId(), mbti2.getMbti(), mbti2.getInfo()))
                    .collect(Collectors.toList());

            Collections.shuffle(mbtiEntity);

            //MbtiDTO mbtiDTO = MbtiDTO.toMbtiDTO(mbtiEntity);
            return mbtiEntity;
        }
    }
    
}
