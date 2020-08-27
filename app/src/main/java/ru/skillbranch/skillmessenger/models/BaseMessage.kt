package ru.skillbranch.skillmessenger.models

import java.util.*

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {
    abstract fun formatMessage(): String

    companion object AbstractFactory {
        var lastId = -1

        fun makeMessage(
            from: User?,
            chat: Chat,
            date: Date = Date(),
            type: String?,
            payload: Any?
        ): BaseMessage {
            lastId++
            return when (type) {
                "image" -> ImageMessage(
                    "$lastId",
                    from,
                    chat,
                    date = date,
                    image = payload as String
                )
                "text" -> TextMessage("$lastId", from, chat, date = date, text = payload as String)
                else -> throw UnsupportedOperationException("Unsupported message type")
            }
        }
    }
}
