package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AoplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
//            System.out.println("name = "+beanDefinitionName+"object = " + bean);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 스프링 내부에서 추가한게 아니라 내가 직접 넣은 코드 혹은 라이브러리
                            System.out.println("name = "+beanDefinitionName+"object = " + bean);
            }
        }
    }
}
