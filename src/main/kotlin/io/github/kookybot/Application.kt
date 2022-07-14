package io.github.kookybot

import java.io.File
import io.github.kookybot.client.Client
import io.github.kookybot.events.channel.ChannelMessageEvent

suspend fun main() {
    // Read the KOOK bot token / 读取 KOOK bot token
    val token = File("data/token.txt").readLines().first()
    // Create a new KOOK bot client / 创建一个新的 KOOK bot 客户端
    val client = Client(token) {
        // Register default Brigadier commands / 注册默认 Brigadier 命令
        withDefaultCommands()
    }
    // Start the KOOK bot client / 启动 KOOK bot 客户端
    val self = client.start()
    // Add a listener for channel messages / 添加一个监听器以侦听频道消息
    client.eventManager.addListener<ChannelMessageEvent> {
        // Message is "hello" / 消息是 "hello"
        if (content == "hello") {
            // Send "Hello, world!" to the channel / 发送 "Hello, world!" 到频道
            channel.sendMessage("Hello, world!")
        }
    }
}
