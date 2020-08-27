package ru.skillbranch.skillmessenger.extensions

import ru.skillbranch.skillmessenger.models.User
import ru.skillbranch.skillmessenger.models.UserView
import ru.skillbranch.skillmessenger.utils.Utils

fun User.toUserView(): UserView {
    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status =
        if (lastVisit == null) "Еще ни разу не был" else if (isOnline) "Online" else "Последний раз был ${lastVisit?.format()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickName = nickName,
        initials = initials,
        status = status
    )
}