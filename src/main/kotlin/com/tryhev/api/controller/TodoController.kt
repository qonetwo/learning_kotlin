package com.tryhev.api.controller

import com.tryhev.api.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {

    @GetMapping(
            name = "Get list of Todos.",
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTodos(): List<Todo> {
        return listOf(
                Todo(
                        todoId = UUID.randomUUID().toString(),
                        title = "First Todo item.",
                        message = "This is a message from first todo item.",
                        schedule = System.currentTimeMillis()
                ),
                Todo(
                        todoId = UUID.randomUUID().toString(),
                        title = "Second Todo item.",
                        message = "This is a message from second todo item.",
                        schedule = System.currentTimeMillis()
                )
        )
    }

    @PostMapping(
            name = "Add a new Todo item.",
            value = ["/add"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addTodo(
            @RequestBody todo: Todo
    ): Todo {
        todo.todoId = UUID.randomUUID().toString()
        return todo
    }

    @DeleteMapping(
            name = "Delete todo by todoId.",
            value = ["/delete/{todoId}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(
            @PathVariable(name = "todoId") todoId: String
    ): String {
        // TODO: impl delete todo method by using todo service
        println("Deleting todo item...")
        return "Success."
    }

    @PutMapping(
            name = "Update todo item.",
            value = ["/update"],
            consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(
            @RequestBody todo: Todo
    ): Todo {
        todo.title.plus(" [updated]")
        todo.message.plus(" [updated]")
        todo.schedule = System.currentTimeMillis()
        return todo
    }
}