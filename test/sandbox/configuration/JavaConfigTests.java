package sandbox.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Keesun Baik
 */


/**
 * TODO: ConfigurationClassPostProcessor는 InfraBean이다. PR할 것.
 */
public class JavaConfigTests {
    
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Hello hello = context.getBean(Hello.class);
        hello.sayHello();
    }
    
    public static class AppConfig2 extends HelloConfig {

        @Override
        public Hello hello() {
            Hello h = super.hello();
            h.setName("Keesun");
            return h;
        }
    }

    @Configuration
    @EnableHello(name = "Keesun")
    public static class AppConfig implements NameConfigurer {

        @Override
        public void configure(Hello hello) {
            hello.setName("Spring Spring");
        }
    }

    /** --------------- */

    @Retention(value = RetentionPolicy.RUNTIME)
    @Import(HeloIBDR.class)
    public @interface EnableHello {
        String name();
    }

    public static class HeloIBDR implements ImportBeanDefinitionRegistrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
            BeanDefinition bd = new RootBeanDefinition(Hello.class);
            bd.getPropertyValues().addPropertyValue("name", "keesun");
            registry.registerBeanDefinition("hello", bd);
        }
    }
    
    
    static class HelloSelector implements ImportSelector {

        @Override
        public String[] selectImports(AnnotationMetadata importingClassMetadata) {
            String type = (String)importingClassMetadata.getAnnotationAttributes(EnableHello.class.getName()).get("type");
            if(type.equals("english")) {
                return new String[]{HelloConfig.class.getName()};
            }
            if(type.equals("korean")) {
                return new String[]{HelloKoreanConfig.class.getName()};
            }
            throw new IllegalArgumentException();
        }
    }

    @Configuration
    public static class HelloConfig implements ImportAware{
        @Bean
        public Hello hello() {
            Hello h = new Hello();
            h.setName("Toby");
            return h;
        }
        
        @Autowired Hello hello;

        @Override
        public void setImportMetadata(AnnotationMetadata importMetadata) {
            String name = (String) importMetadata.getAnnotationAttributes(EnableHello.class.getName()).get("name");
            hello.setName(name);
        }
    }

    @Configuration
    public static class HelloKoreanConfig implements ImportAware{
        @Bean
        public Hello hello() {
            Hello h = new KoreanHello();
            h.setName("Toby");
            return h;
        }

        @Autowired Hello hello;

        @Override
        public void setImportMetadata(AnnotationMetadata importMetadata) {
            String name = (String) importMetadata.getAnnotationAttributes(EnableHello.class.getName()).get("name");
            hello.setName(name);
        }
    }
    
    interface NameConfigurer {
        void configure(Hello hello);
    }
    
    @Configuration
    public static class HelloConfig3 {
        
        @Autowired NameConfigurer configurer;

        @Bean
        public Hello hello() {
            Hello h = new Hello();
            configurer.configure(h);
            return h;
        }
        
    }
    
}
