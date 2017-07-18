package com.technical;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.technical.controller.AlarmController;

@SpringBootApplication
public class TechnicalProofApplication {

	private static AlarmController controller = new AlarmController();

	public static void main(String[] args) {
		SpringApplication.run(TechnicalProofApplication.class, args);

		System.out.println("*****Process started*****");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sTexto = "";
		try {
			do {
				// We read from the text entry
				sTexto = br.readLine();

				// We split the string to get the command to execute and the alarm to apply it
				String[] words = sTexto.split(" ");
				if (words.length >= 2) {
					Long time = controller.executeAlarm(words[0], words[1]);
					if (time > 0) {
						System.out.println("ALARM " + words[1] + " " + time);
					}
				}
			} while (!sTexto.equals("TURN OFF"));

		} catch (IOException e) {
			System.out.println("An error has occurred");
		}

		System.out.println("*****Ended process*****");
	}
}
