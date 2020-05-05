package com.tryhev.api.data

class Todo (
        var todoId: String = "",
        var title: String,
        var message: String,
        var schedule: Long,
        var location: String = ""
)