package ru.skillbranch.skillmessenger.models

class UserView(
    id: String,
    fullName: String,
    nickName: String,
    avatar: String? = null,
    status: String? = "offline",
    initials: String?
)