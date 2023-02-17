package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    //@Rollback(value = false)
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("jung");
        member.setAddress(new Address("seoul", "dong-il", "05008"));

        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberService.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("jung");

        Member member2 = new Member();
        member2.setName("jung");

        //when
        memberService.join(member1);
        memberService.join(member2);

//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            return;
//        }

        //then
        Assertions.fail("예외가 발생해야 한다.");
    }
}