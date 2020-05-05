package com.tryhev.api.controller

import com.tryhev.api.data.Note
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
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
            name = "Get note by noteId.",
            value = ["/{noteId}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNode(
            @PathVariable(name = "noteId") noteId: String
    ): String {
        return "The note Id is: ".plus(noteId)
    }

    @PutMapping(
            name = "Add note.",
            value = ["/add"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addNote(
        note: Note
    ): Note {
        note.noteId = UUID.randomUUID().toString()
        return note
    }

    @DeleteMapping(
            name = "Delete note by noteId",
            value = ["/delete/{noteId}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]

    )
    fun deleteNote(
            @PathVariable(name = "noteId") noteId: String
    ): String {
        // TODO: impl deleting note by noteID
        return "Success."
    }

    @PutMapping(
            name = "Update note.",
            value = ["/update"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(
            @RequestBody note: Note
    ): Note {
        note.title.plus(" [updated]")
        note.message.plus(" [updated]")
        return note
    }
}