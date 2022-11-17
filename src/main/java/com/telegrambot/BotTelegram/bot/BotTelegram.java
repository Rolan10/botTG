package com.telegrambot.BotTelegram.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import controladores.Puntos;

@Service
public class BotTelegram extends TelegramLongPollingBot {

	Puntos p = new Puntos();

	@Override
	public void onUpdateReceived(Update update) {
		// Se obtiene el mensaje escrito por el usuario
		
		
		
		final String messageTextReceived = update.getMessage().getText();
		p.InitList();

		System.out.println("Escribieron en el bot " + messageTextReceived);

		// Se obtiene el id de chat del usuario
		final long chatId = update.getMessage().getChatId();

		// Se crea un objeto mensaje
		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		if(update.getMessage().getText().toLowerCase().equals("/help")) {
			message.setText("utiliza /winners para ver quien va en cabeza");
			try {
				// Se envía el mensaje
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
		//message.setText(p.Mensaje());
		if (update.getMessage().getText().toLowerCase().equals("/winners")) {
			message.setText(p.Mensaje());
			try {
				// Se envía el mensaje
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}



	}

	@Override
	public String getBotUsername() {
		return "SoleraBootcampBot";
	}

	@Override
	public String getBotToken() {
		return "5771394734:AAGjNnDFymtdlBZO3Ad_HJpI3-UrQzBfI5w";
	}
}
