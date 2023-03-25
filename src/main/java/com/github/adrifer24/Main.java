package com.github.adrifer24;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String token = ""; // El token
        DiscordApi api = new DiscordApiBuilder().setToken(token).setAllIntents().login().join();

        System.out.println("Puedes invitar el bot a tu servidor con el enlace: " + api.createBotInvite());

        api.addMessageCreateListener(event -> {
            if (event.isServerMessage()) {

                if (event.getMessageContent().contains("!decir")) {
                    String repetir = event.getMessageContent().substring(7);
                    event.getChannel().sendMessage(repetir);
                    event.getMessage().delete();
                }

                else if (event.getMessageContent().contains("!salchicha")) {
                    int numero_aleatorio = (int) (Math.random() * 30 + 1);
                    //File file = new File("D:\\perros\\"+numero_aleatorio+".jpg");
                    File file = new File("/var/imgs/"+numero_aleatorio+".jpg");
                    event.getChannel().sendMessage(file);
                }
            }
        });
    }
}
