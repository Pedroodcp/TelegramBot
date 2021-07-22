package br.com.pedrodcp.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class TelegramBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        if (command.equals("/ajuda")) {
            message.setText("Olá, " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName() + "! \nVocê receberá ajuda em alguns minutos...");
            System.out.println("O usuário " + update.getMessage().getFrom().getUserName() + " executou o comando /ajuda!");
        } else {
            if (command.equals("/help")) {
                message.setText("Olá, " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName() + "! \nVocê receberá ajuda em alguns minutos...");
                System.out.println("O usuário " + update.getMessage().getFrom().getUserName() + " executou o comando /help!");
            } else {
                message.setText("Ops! Não consegui reconhecer este comando! :( \n\nVeja os meus comandos logo abaixo:\n\n/help\n/ajuda");
                System.out.println("O usuário " + update.getMessage().getFrom().getUserName() + " executou um comando desconhecido.");
            }
        }
        message.setChatId(update.getMessage().getChatId());
        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "testetelegram123bot";
    }

    @Override
    public String getBotToken() {
        return "1939372055:AAEidIZD1J_ReqNZ--I3Gb7tMAy-ooCqeJA";
    }
}
