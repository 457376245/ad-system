package com.jh.common;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdCommonApplicationTests {

    @Test
    void contextLoads() {
        ArrayList<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();

        System.out.println(list.getClass().getName());
        System.out.println(list2.getClass());
    }

}
