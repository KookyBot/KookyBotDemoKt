package io.github.kookybot.listener

import io.github.kookybot.client.Client
import io.github.kookybot.events.EventHandler
import io.github.kookybot.events.Listener
import io.github.kookybot.events.channel.ChannelMessageEvent
import io.github.kookybot.events.direct.DirectMessageEvent
import java.io.File

// Listener class / 监听器类
/*
 * Usually, one listener class represents one type of jobs (e.g. admin, easy access tool, channel manage events, etc.)
 * 通常，一个监听器类代表一种工作（例如管理操作，简单工具，频道管理事件等等）
 */
class AListener: Listener {
    /*
     * You can add multiple event handlers in a single listener class, so the same job can be done in multiple ways.
     * For example, you can use the same function from different sources (e.g. channel, direct message, etc.)
     * 可以添加在一个监听器类中多个事件处理器，以便多种方式完成同一任务
     * 例如，你可以从不同地方（频道、私聊等）使用同一个功能
     */

    @EventHandler
    // Event handler for channel messages / 频道消息事件处理器
    fun onChannelMessage(event: ChannelMessageEvent) {
        // Implement your logic here / 在此处实现你的逻辑
    }

    @EventHandler
    // Event handler for direct messages / 私聊消息事件处理器
    fun onDirectMessage(event: DirectMessageEvent) {
        // Implement your logic here / 在此处实现你的逻辑
    }
}

// You can add multiple listeners class for different type of jobs
// 你可以添加多个监听器类，用于不同的工作
class BListener: Listener {
    // Other event handlers / 其他事件处理器
}

suspend fun main() {
    // Read the KOOK bot token / 读取 KOOK bot token
    val token = File("data/token.txt").readLines().first()
    // Create a new KOOK bot client / 创建一个新的 KOOK bot 客户端
    val client = Client(token)
    // Start the KOOK bot client / 启动 KOOK bot 客户端
    val self = client.start()
    // Add Listener Class to client / 将 Listener 类添加到客户端
    client.eventManager.addClassListener(AListener())
    client.eventManager.addClassListener(BListener())
}
