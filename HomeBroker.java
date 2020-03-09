import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomeBroker implements IHomeBroker {

	private Queue<Transacao> transacao;

	public HomeBroker() {
		transacao = new LinkedQueue<>();
	}

	@Override
	public void carregar(File file) throws IOException {
		// TODO Auto-generated method stub
		try (BufferedReader ler = new BufferedReader(new FileReader(file))) {

			for (String linha = ler.readLine(); linha != null; linha = ler.readLine()) {
				String[] dados = linha.split(";");
				Transacao tran = new Transacao(dados[0], Integer.parseInt(dados[1]), Double.parseDouble(dados[2]));
				if (isCompra(tran)) {
					transacao.enqueue(tran);
				} else {
					System.out.println(obterCapital(tran));
					break;
				}

			}
		}
	}

	private boolean isCompra(Transacao tran) {
		if (tran.getTipo().equalsIgnoreCase("compra")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public double obterCapital(Transacao venda) {
		// TODO Auto-generated method stub

		double retorno = 0;
		int quantVenda = venda.getQtde();

		while (quantVenda != 0) {
			Transacao aux = transacao.front();
			int quantCompra = aux.getQtde();
			if (quantCompra <= quantVenda) {
				quantVenda -= quantCompra;
				retorno += quantCompra * (venda.getPrecoUnitario() - aux.getPrecoUnitario());
				transacao.dequeue();
			} else {
				retorno += quantVenda * (venda.getPrecoUnitario() - aux.getPrecoUnitario());
				transacao.front().setQtde(quantCompra - quantVenda);
				quantVenda = 0;

			}
		}
		return retorno;
	}

	@Override
	public void salvar(File file) throws IOException {
		// TODO Auto-generated method stub

		try (BufferedWriter escrever = new BufferedWriter(new FileWriter(file))) {
			if (transacao.isEmpty()) {
				escrever.write("Sem Lotes");
			} else {
				for (int i = 0; i < transacao.numElements(); i++) {
					escrever.write(transacao.dequeue().toCommaText());
					escrever.newLine();
				}
			}

		}
	}

}
