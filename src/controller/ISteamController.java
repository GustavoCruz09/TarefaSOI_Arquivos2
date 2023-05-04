package controller;

import java.io.IOException;

public interface ISteamController {

	public void readFile(String path, String name, String mes, String ano, float media) throws IOException;
	public void writeFile(String path, String mes, String ano, String linha) throws IOException;
	
	
}
