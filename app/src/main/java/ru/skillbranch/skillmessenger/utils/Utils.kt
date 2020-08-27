package ru.skillbranch.skillmessenger.utils

object Utils {

    fun parseFullName(fullname: String?): Pair<String?, String?> {

        if (fullname == null) {
            return "null" to "null"
        }

        val parts = fullname.trim().split(" ")
        val firstname = parts.getOrNull(0)
        val secondname = parts.getOrNull(1)

        if (firstname == null) {
            return "null" to secondname
        }

        if (secondname == null) {
            return firstname to "null"
        }

        return firstname to secondname
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return ""
        //TODO("implement")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        if (firstName != null && lastName == null) {
            return if (firstName.trim().isNotEmpty()) firstName[0].toString() else null
        }

        if (firstName == null && lastName != null) {
            return if (lastName.trim().isNotEmpty()) lastName[0].toString() else null
        }

        if (firstName != null && lastName != null) {
            var initials = ""
            if (lastName.trim().isNotEmpty()) {
                initials += lastName[0].toString()
            }
            if (firstName.trim().isNotEmpty()) {
                initials += firstName[0].toString()
            }
            return if (initials.isEmpty()) null else initials
        }

        return null
    }
}