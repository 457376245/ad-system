package com.jh.search;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;
import java.util.function.Supplier;

class AdSearchApplicationTests {

    @Test
    void contextLoads() {
    }
    String test1(Supplier<String> supplier ){
        return supplier.get();
    }
    @Test
    void test2(Function<Integer,String> function){
    }
    @Test
    void  test3(){
        String s="123";
        test2(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return null;
            }
        });
    }

}
