package aplicaEscala.util;

import java.util.Base64;

public class CriptografiaUtil {
	public static String criptografa(String senha) {
		return new String(Base64.getEncoder().encode(senha.getBytes()));

	}

	public static String descriptografa(String senha) {
		return new String(Base64.getDecoder().decode(senha));

	}

}
