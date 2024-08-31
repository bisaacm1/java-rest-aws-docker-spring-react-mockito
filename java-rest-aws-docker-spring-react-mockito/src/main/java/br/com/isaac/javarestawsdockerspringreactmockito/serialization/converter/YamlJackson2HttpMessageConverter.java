package br.com.isaac.javarestawsdockerspringreactmockito.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import br.com.isaac.javarestawsdockerspringreactmockito.utils.Constants;

public class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {

  public YamlJackson2HttpMessageConverter() {
    super(new YAMLMapper()
        .setSerializationInclusion(
            JsonInclude.Include.NON_NULL),
        MediaType.parseMediaType(Constants.APPLICATION_YML));
  }

}
