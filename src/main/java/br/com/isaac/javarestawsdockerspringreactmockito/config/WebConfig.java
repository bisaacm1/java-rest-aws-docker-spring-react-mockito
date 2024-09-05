package br.com.isaac.javarestawsdockerspringreactmockito.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.isaac.javarestawsdockerspringreactmockito.serialization.converter.YamlJackson2HttpMessageConverter;
import br.com.isaac.javarestawsdockerspringreactmockito.utils.Constants;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf(Constants.APPLICATION_YML);

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlJackson2HttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    // QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml

    configurer.favorParameter(true)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType(Constants.JSON, MediaType.APPLICATION_JSON)
        .mediaType(Constants.XML, MediaType.APPLICATION_XML)
        .mediaType(Constants.X_YAML, MEDIA_TYPE_APPLICATION_YML);
  }

}
