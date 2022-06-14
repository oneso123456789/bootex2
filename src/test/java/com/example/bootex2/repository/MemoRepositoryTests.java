package com.example.bootex2.repository;

import com.example.bootex2.entity.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    Memorepository memorepository;

    @Test
    public void testClass() {
        System.out.println("============================");
        System.out.println(memorepository.getClass().getName());

    }

    @Test
    public void testInsertDummies() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("Sample..." + i).build();
            memorepository.save(memo);
        });

    }

    @Test
    public void testSelect() {

        // DB에 존재하는 mno
        Long mno = 99L;

        Optional<Memo> result = memorepository.findById(mno);

        System.out.println("===================================");

        if (result.isPresent()) {
            Memo memo = result.get();

            System.out.println(memo);
        }
    }

    @Transactional
    @Test
    public void testSelect2() {

        Long mno = 99L;

        Memo memo = memorepository.getReferenceById(mno);

        System.out.println("===================================");

        System.out.println(memo);
    }

    @Test
    public void testUpdate() {

        Memo memo = Memo.builder().mno(99L).memoText("업데이트 테스트한 내용 100번은 삭제함").build();

        System.out.println(memorepository.save(memo));
    }

    @Test
    public void testDelete() {
        Long mno = 100L;

        memorepository.deleteById(mno);
    }
}
