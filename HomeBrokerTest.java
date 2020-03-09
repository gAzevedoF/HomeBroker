import java.io.File;
import java.io.IOException;

public class HomeBrokerTest {
	public static void main(String[] args) {

		IHomeBroker home = new HomeBroker();

		try {
			home.carregar(new File("c://temp/Simulado.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			home.salvar(new File("c://temp/SimuladoSalvo.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
