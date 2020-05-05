package com.tryhev.api.data

data class Note (
    var noteId: String = "",
    var title: String,
    var message: String,
    var location: String = ""
)
