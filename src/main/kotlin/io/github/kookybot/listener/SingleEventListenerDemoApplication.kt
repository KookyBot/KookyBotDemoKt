package io.github.kookybot.listener

import io.github.kookybot.client.Client
import io.github.kookybot.events.channel.ChannelMessageEvent
import io.github.kookybot.events.direct.DirectMessageEvent
import java.io.File

suspend fun main() {
    // Read the KOOK bot token / 读取 KOOK bot token
    val token = File("data/token.txt").readLines().first()
    // Create a new KOOK bot client / 创建一个新的 KOOK bot 客户端
    val client = Client(token)
    // Start the KOOK bot client / 启动 KOOK bot 客户端
    val self = client.start()
    // A single event listener for reacting to channel messages / 用于回应群消息的单方法监听器
    client.eventManager.addListener<ChannelMessageEvent> {
        // Message is "hello" / 消息是 "hello"
        if (content == "hello") {
            // Send "Hello, world!" to the channel / 发送 "Hello, world!" 到频道
            channel.sendMessage("Hello, world!")
        }
    }
    // A single event listener for reacting to direct messages / 用于回应私聊消息的单方法监听器
    client.eventManager.addListener<DirectMessageEvent> {
        if (content == "hello") {
            // Reply "Hello, world!" to the direct message / 回复 "Hello, world!" 到私聊
            sender.sendMessage("Hello, world!", content)
        }
    }
}
