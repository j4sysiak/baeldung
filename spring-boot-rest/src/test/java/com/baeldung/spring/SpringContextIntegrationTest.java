package com.baeldung.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {WebConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class SpringContextIntegrationTest implements WebMvcConfigurer {

    @Test
    public void contextLoads(){
        // When
    }
}