package br.com.isaac.javarestawsdockerspringreactmockito.shared.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.isaac.javarestawsdockerspringreactmockito.shared.serializers.converter.YamlJackson2HttpMessageConverter;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf(Constants.APPLICATION_YML);

  @Bean
  public String[] allowedOrigins() {
    return new String[] {
        Constants.ORIGIN_LOCALHOST_3000,
        Constants.ORIGIN_LOCALHOST_8080,
        Constants.ORIGIN_ISAAC
    };
  }

  @Override
  public void extendMessageConverters(@NonNull List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlJackson2HttpMessageConverter());
  }

  @Override
  public void configureContentNegotiation(@NonNull ContentNegotiationConfigurer configurer) {
    configurer.favorParameter(true)
        .ignoreAcceptHeader(false)
        .useRegisteredExtensionsOnly(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType(Constants.JSON, MediaType.APPLICATION_JSON)
        .mediaType(Constants.XML, MediaType.APPLICATION_XML)
        .mediaType(Constants.X_YAML, MEDIA_TYPE_APPLICATION_YML);
  }

  @Override
  public void addCorsMappings(@NonNull CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("*")
        .allowedOrigins(allowedOrigins())
        .allowCredentials(true);
  }
}
