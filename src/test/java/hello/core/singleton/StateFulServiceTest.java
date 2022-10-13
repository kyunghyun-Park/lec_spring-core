package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        //ThreadA : A사용자 10,000원 주문
        stateFulService1.order("userA", 10000);
        //ThreadB : B사용자 20,000원 주문
        stateFulService1.order("userB", 20000);

        /* AFTER */
       /* int userA = stateFulService1.order2("userA", 10000);
        int userB = stateFulService1.order2("userB", 20000);
        System.out.println("userA = " + userA);*/

        //ThreadA : A사용자 주문 금액 조회
        int price = stateFulService1.getPrice();
        //10,000이 아니라 20,000출력
        System.out.println("price = " + price);

        assertThat(stateFulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}