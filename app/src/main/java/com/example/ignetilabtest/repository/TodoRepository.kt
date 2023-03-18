package com.example.ignetilabtest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.ignetilabtest.database.AppDatabase
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.database.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TodoRepository (application: Application) {

    private val todoDao: UserDao
    private val allTodos: LiveData<List<TodoRecord>>

    init {
        val database = AppDatabase.getInstance(application.applicationContext)
        todoDao = database!!.userDao()
        allTodos = todoDao.getAllTodoList()
    }

    fun saveTodo(todo: TodoRecord) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.saveTodo(todo)
        }
    }

    fun updateTodo(todo: TodoRecord) = runBlocking {
        this.launch(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }


    fun deleteTodo(todo: TodoRecord) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                todoDao.deleteTodo(todo)
            }
        }
    }

    fun getAllTodoList(): LiveData<List<TodoRecord>> {
        return allTodos
    }
}