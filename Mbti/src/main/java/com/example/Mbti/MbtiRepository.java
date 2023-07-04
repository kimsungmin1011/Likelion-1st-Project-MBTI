package com.example.Mbti;

import com.example.Mbti.entity.MbtiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MbtiRepository extends JpaRepository<MbtiEntity, Long>{
    List<MbtiEntity> findByMbti(String mbti);
}
