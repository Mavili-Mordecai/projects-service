package com.locus_narrative.projects_service.infrastructure.config;

import com.locus_narrative.projects_service.presentation.interceptors.RequestValidator;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public Validator getValidator() {
        return new RequestValidator();
    }
}
