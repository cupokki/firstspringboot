package com.example.customermanagement.repository;
import java.util.List;

// import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.customermanagement.domain.Member;

/**
 *  테스트는 순서에 의존하면 안된다. 
 *  중복된 데이터를 쓰면 초기화 필요
 *  TTD 
 *  테스트를 먼저 만들고 구현체를 만든다.
 */
public class MemoryMemberRepositoryTest { // 외부에서 꺼내 쓰지 않으므로 굳이 퍼블릭x
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring"); // 컨트롤 엔터와 컨트롤 쉬프트 엔터의 발견
        
        repository.save(member);
        Member result = repository.findById(member.getId()).get();


        // Assertions.assertEquals(member, result); // junit
        Assertions.assertThat(member).isEqualTo(result); // 현업에서 주로 쓰임
        
        // Assertions.assertThat(member).isEqualTo(null); // 현업에서 주로 쓰임
        
    }
    @Test
    public void findByName() { 
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        var result1 = repository.findByName("spring2").get();
        // var result2 = repository.findByName("spring2").get();
        Assertions.assertThat(result1).isEqualTo(member2);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        
        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
    
}   
