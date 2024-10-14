package com.servermanagement;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServerManagementTool {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// A server has gone down and we want to resolve that server

		String serverResult = getInput(scanner);

		IServer server;

		serverResult = findMatch(serverResult);

		try {
			server = getServer(serverResult);

			server.notifyPerson();

			server.Resolve();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String getInput(final Scanner scanner) {

		System.out.println("1. FTP Server");
		System.out.println("2. Mail Server");
		System.out.println("3. Quantum Server");

		System.out.println("Which server do you want to resolve? ");
		String serverResult = scanner.nextLine();

		return serverResult;
	}

	public static IServer getServer(String serverType) throws Exception {

		switch (serverType) {

		case "mail":
			return new MailServer();
		case "ftp":
			return new FTPServer();
		case "quantum":
			return new QuantumServer();
		default:
			throw new Exception("Invalid server type");

		}

	}

	public static String findMatch(String serverResult) {

		Pattern pattern1 = Pattern.compile("1|ftp", Pattern.CASE_INSENSITIVE);

		Matcher matcher1 = pattern1.matcher(serverResult);
		boolean matchFound1 = matcher1.find();

		Pattern pattern2 = Pattern.compile("2|mail", Pattern.CASE_INSENSITIVE);
		Matcher matcher2 = pattern2.matcher(serverResult);
		boolean matchFound2 = matcher2.find();

		Pattern pattern3 = Pattern.compile("3|quantum", Pattern.CASE_INSENSITIVE);
		Matcher matcher3 = pattern3.matcher(serverResult);
		boolean matchFound3 = matcher3.find();

		if (matchFound1) {

			return serverResult = "ftp";
		} else if (matchFound2) {

			return serverResult = "mail";
		} else if (matchFound3) {

			return serverResult = "quantum";
		} else {
			System.out.println("Match not found :(");
			getInput(scanner);
		}

		return serverResult;

	}

}
