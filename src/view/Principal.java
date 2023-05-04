package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ISteamController;
import controller.SteamController;

public class Principal {

	public static void main(String[] args) {
		
		ISteamController arqCont = new SteamController();
		String path = "C:\\Tutu";
		String name = "SteamCharts.csv";
		
		String mes = JOptionPane.showInputDialog("Digte o mes");
		String ano = /*Integer.parseInt(*/JOptionPane.showInputDialog("Digite o ano");
		float media = Float.parseFloat(JOptionPane.showInputDialog("Digite a media de jogadores ativos"));
		
		try {
			arqCont.readFile(path, name, mes, ano, media);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
