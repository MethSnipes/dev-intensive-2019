package ru.skillbranch.skillmessenger.models

import ru.skillbranch.skillmessenger.utils.Utils
import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) :
            this(id, firstName, lastName, null)

    constructor(id: String) : this(id, "default", "name")

    companion object Factory {
        var lastId = -1

        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, secondName) = Utils.parseFullName(fullName)

            return User(lastId.toString(), firstName, secondName)
        }
    }
}