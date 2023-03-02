package jpabook.jpashop.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryOldTest {

    @Autowired
    MemberRepositoryOld memberRepositoryOld;

    @Test
    @Transactional //Test 종료 후 DB Rollback
    @Rollback(false)
    public void testMember() throws Exception {
        //given


        //when


        //then

    }
}