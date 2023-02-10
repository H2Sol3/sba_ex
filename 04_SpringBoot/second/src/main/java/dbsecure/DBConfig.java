package dbsecure;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration					// 나는 설정클래스입니다.
@EnableEncryptableProperties	// 현재 정보를 application.properties에서 사용할 수 있도록 한다.
public class DBConfig {
	
	@Bean("jasyptEncryptor") // 라이브러리에 해당하는 빈을 만든다. 메소드 리턴 객체를 주입한다.
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호화 해제 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        
        encryptor.setConfig(config);
        System.out.println("===DBConfig 출력===");
        System.out.println(System.getenv("DB_PASSWORD"));
        System.out.println(encryptor.decrypt("kyg1Cz77uJ4nRKr6zT2CGGqmWWC29Z9qJiZ2UTwjgBA="));
        System.out.println(encryptor.decrypt("uMLhCriEn0HE6WlPzNeO3cPXeGF6V3UzPV1AQ024R5uNxjEuevYIZ1yilSdhW4z9viivItUnTHDAaZOL72uCCJ3Gvg4Cy/BkTke4Jg7kGoirqhW3kTm5WQvvRS3AzdUqrWizcLvaU2g="));
        System.out.println(encryptor.decrypt("z5YOrbBawKwL3Dmx8Dq6+fyGbbF/SxOu"));
        System.out.println(encryptor.decrypt("jSlvXUfC/4wi1e4p+83VFXN1gfpJN96r"));

        return encryptor;
	}
}