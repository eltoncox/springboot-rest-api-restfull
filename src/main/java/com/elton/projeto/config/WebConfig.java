package com.elton.projeto.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//diz ao SpringBoot que quando estiver subindo o contexto  vai encontrar configurações sobre o comportamento da aplicação
@Configuration 
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		// https://www.baeldung.com/spring-mvc-content-negotiation-json-xml
				// Via EXTENSION. http://localhost:8080/api/person/v1.xml DEPRECATED on SpringBoot 2.6
				
				// Via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml
				/*
				configurer.favorParameter(true)
					.parameterName("mediaType").ignoreAcceptHeader(true)
					.useRegisteredExtensionsOnly(false)
					.defaultContentType(MediaType.APPLICATION_JSON)
						.mediaType("json", MediaType.APPLICATION_JSON)
						.mediaType("xml", MediaType.APPLICATION_XML);
				*/
				
				// Via HEADER PARAM. http://localhost:8080/api/person/v1
				
				configurer.favorParameter(false)
				.ignoreAcceptHeader(false)
				.useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
					.mediaType("json", MediaType.APPLICATION_JSON)
					.mediaType("xml", MediaType.APPLICATION_XML);
					//.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML)					
			}
}
