package com.example.Mbti.controller;

import com.example.Mbti.MbtiService;
import com.example.Mbti.dto.MbtiDTO;
import com.example.Mbti.entity.MbtiEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
//@RequiredArgsConstructor
@RequestMapping("/mbti")
public class MbtiController {
    private final MbtiService mbtiService;

    public MbtiController(MbtiService mbtiService){
        this.mbtiService=mbtiService;
    }

    @PostMapping("/")
    public void save(@RequestBody MbtiDTO mbtiDTO){
        mbtiService.save(mbtiDTO);
    }

    @GetMapping("/")
    public List<MbtiDTO> giveList(){
        List<MbtiDTO> mbtiDTOList=mbtiService.getList();

        return mbtiDTOList;
    }

    @GetMapping("/{mbti}")
    public List<MbtiDTO> findByMbti(@PathVariable("mbti") String mbti){
        List<MbtiDTO> mbtiDTO=mbtiService.findByMbti(mbti);
        return mbtiDTO;

    }


}
