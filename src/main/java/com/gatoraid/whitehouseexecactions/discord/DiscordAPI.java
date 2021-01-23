package com.gatoraid.whitehouseexecactions.discord;

import com.google.common.collect.MapDifference;
import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.Channel;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.object.entity.channel.TextChannel;
import discord4j.core.spec.MessageCreateSpec;
import reactor.core.publisher.Mono;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class DiscordAPI {

    final DiscordClient client = DiscordClient.create("Nzk3NTQzOTc2MTE4NTE3Nzcw.X_oAtQ.MPsfo_F9kjzphWUzVyIbusRH01w");
    final GatewayDiscordClient gateway = client.login().block();


    public void sendUpdate(Object text, Object link){

        assert gateway != null;
        final MessageChannel channel = (MessageChannel) gateway.getChannelById(Snowflake.of("797543479445684297")).block();
        String channelUpdate = "--------------------------------------------------------\n" + text + "\n" + link + "--------------------------------------------------------\n";
        channel.createMessage((String) channelUpdate).block();

    }

//    public void sendUpdateTest(HashMap<String, String> allArticles){
//
//        assert gateway != null;
//        final MessageChannel channel = (MessageChannel) gateway.getChannelById(Snowflake.of("797543479445684297")).block();
//        allArticles.forEach((text, link) -> {
//            channel.createMessage(text).block();
//            channel.createMessage(link).block();
//        });
//
//
//    }


}
