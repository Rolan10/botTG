package com.telegrambot.BotTelegram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.api.objects.Update;

import com.telegrambot.BotTelegram.bot.BotTelegram;

@SpringBootApplication
public class BotTelegramApplication {

	public static void main(String[] args) {
//		BotTelegram n = new BotTelegram();
		//n.onUpdateReceived(new Update());
		SpringApplication.run(BotTelegramApplication.class, args);
	}

}
