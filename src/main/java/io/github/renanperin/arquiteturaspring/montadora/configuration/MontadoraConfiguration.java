package io.github.renanperin.arquiteturaspring.montadora.configuration;

import io.github.renanperin.arquiteturaspring.montadora.Motor;
import io.github.renanperin.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(4);
        motor.setModelo("TH-10");
        motor.setLitragem(1.0);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Primary
    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(410);
        motor.setCilindros(8);
        motor.setModelo("HX-2");
        motor.setLitragem(1.6);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
