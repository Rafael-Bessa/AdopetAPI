package bessa.morangon.rafael.AdopetAPI.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicacaoConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();

    }
}
