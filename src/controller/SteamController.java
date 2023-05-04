package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SteamController implements ISteamController {

	public SteamController() {
		super();
	}

	@Override
	public void readFile(String path, String name, String mes, String ano, float media) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			FileInputStream abreFluxoArq = new FileInputStream(arq);
			InputStreamReader leitorFluxo = new InputStreamReader(abreFluxoArq);
			BufferedReader buffer = new BufferedReader(leitorFluxo);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(",");
				float med = Float.parseFloat(vetLinha[3]);
				if ((vetLinha[1]).contains(ano) && (vetLinha[2]).contains(mes) && med >= media) {
					System.out.println("Nome: " + vetLinha[0] + "|| Média: " + vetLinha[3]);
					writeFile(path, mes, ano, linha);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitorFluxo.close();
			abreFluxoArq.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}

	@Override
	public void writeFile(String path, String mes, String ano, String linha) throws IOException {
		String[] vetLinha = linha.split(",");
		String nam = vetLinha[0];
		String med = vetLinha[3];
		File dir = new File(path);
		File arq = new File(path, "nome.csv");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraLinha(nam, med);
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório Inválido");
		}
	}

	private String geraLinha(String nam, String med) {
		StringBuffer buffer = new StringBuffer();
		String linha = nam + ";" + med;
		buffer.append(linha + "\r\n");
		return buffer.toString();
	}

}
