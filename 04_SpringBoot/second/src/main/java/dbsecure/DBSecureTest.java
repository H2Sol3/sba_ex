package dbsecure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBSecureTest {
	public static void main(String[] args) {
		StandardPBEStringEncryptor db = new StandardPBEStringEncryptor();
		db.setPassword("1234"); // 암호화 복호화 할 때 필요한 비밀번호
		
		String driver = db.encrypt("org.mariadb.jdbc.Driver"); // 암호화할 데이터
		String url = db.encrypt("jdbc:mariadb://finalproject-rds.cvvcf3dstzvi.ap-northeast-2.rds.amazonaws.com:3306/memberdb"); // 암호화할 데이터
		String account = db.encrypt("finaladmin"); // 암호화할 데이터
		String password = db.encrypt("12345678"); // 암호화할 데이터
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(account);
		System.out.println(password);
		
		/*
		 * #aws rds (1개 board)
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://finalproject-rds.cvvcf3dstzvi.ap-northeast-2.rds.amazonaws.com:3306/memberdb
spring.datasource.username=finaladmin
spring.datasource.password=12345678
		 * 
		 * 
		ENC(kyg1Cz77uJ4nRKr6zT2CGGqmWWC29Z9qJiZ2UTwjgBA=)
ENC(uMLhCriEn0HE6WlPzNeO3cPXeGF6V3UzPV1AQ024R5uNxjEuevYIZ1yilSdhW4z9viivItUnTHDAaZOL72uCCJ3Gvg4Cy/BkTke4Jg7kGoirqhW3kTm5WQvvRS3AzdUqrWizcLvaU2g=)
ENC(z5YOrbBawKwL3Dmx8Dq6+fyGbbF/SxOu)
ENC(jSlvXUfC/4wi1e4p+83VFXN1gfpJN96r)

		*/
	}

}