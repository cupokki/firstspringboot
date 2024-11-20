package com.example.customermanagement.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.customermanagement.domain.Member;

/**
 *  
 */
public class MemoryMemberRepositoryTest { // 외부에서 꺼내 쓰지 않으므로 굳이 퍼블릭x
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring"); // 컨트롤 엔터와 컨트롤 쉬프트 엔터의 발견
        
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member, result);
        // Assertions.assertEquals(member, result);
        //
    }
    
}   
