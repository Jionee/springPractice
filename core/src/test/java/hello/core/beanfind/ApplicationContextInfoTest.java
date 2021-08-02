package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        //option+command+V : 앞에 변수 자동 생성
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter+tab : 리스트가 있을 때 for문을 자동으로 생성해준다
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "/ objcct = " + bean);
        }
    }
    @Test
    @DisplayName("어플리케이션 빈 출력하기")
    void findApplicationBean(){
        //option+command+V : 앞에 변수 자동 생성
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //iter+tab : 리스트가 있을 때 for문을 자동으로 생성해준다
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION : 직접 등록한 어플리케이션 빈 //어플레케이션 실행에만 필요한 애들만 출력
            //ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "/ objcct = " + bean);
            }
        }
    }

}
