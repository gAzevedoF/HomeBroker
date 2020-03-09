import java.io.File;
import java.io.IOException;

public interface IHomeBroker {

	public void carregar(File file) throws IOException;
	
	public double obterCapital (Transacao venda);
	
	public void salvar(File file) throws IOException;
}
