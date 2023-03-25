package com.github.adrifer24;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.MessageBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String token = "MTA0OTczNzg0MjUzODA1MzY4NA.GbtyxF.gI5oDGQs6cZJfuLkFQUPgJtC2xLsy9LrzzlZxo";
        DiscordApi api = new DiscordApiBuilder().setToken(token).setAllIntents().login().join();

        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

        api.addMessageCreateListener(event -> {
            if (event.isServerMessage()) {
                if (event.getServer().toString().contains("patata ;")) {
                    if (event.getMessageContent().contains("!decir")) {
                        String repetir = event.getMessageContent().substring(7);
                        event.getChannel().sendMessage(repetir);
                        event.getMessage().delete();
                    }
                }

                else {
                    if (event.getMessageContent().contains("!decir")) {
                        String repetir = event.getMessageContent().substring(7);
                        event.getChannel().sendMessage(repetir);
                        event.getMessage().delete();;
                    }
                    else if (event.getMessageContent().contains("!salchicha")) {
                        File file = new File("hola.txt");
                        event.getChannel().sendMessage(file);
                    }
                }

            }
        });
    }
}
