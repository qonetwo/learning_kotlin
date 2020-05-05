package com.tryhev.api.controller

import com.tryhev.api.data.Note
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @GetMapping(
            name = "Get all notes.",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNodes(): List<Note> {
        return listOf(
                Note(
                        noteId = UUID.randomUUID().toString(),
                        title = "First note",
                        message = "The message from the first note"
                ),
                Note(
                        noteId = UUID.randomUUID().toString(),
                        title = "Second note",
                        message = "The message from the second note"
                )
        )
    }

    @GetMapping(
            name = "Get current note.",
            value = ["/{noteId}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNode(@PathVariable noteId: String): String {
        return "The note Id is: ".plus(noteId)
    }
}