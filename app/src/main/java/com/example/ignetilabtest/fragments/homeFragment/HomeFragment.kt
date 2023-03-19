package com.example.ignetilabtest.fragments.homeFragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ignetilabtest.R
import com.example.ignetilabtest.database.TodoRecord
import com.example.ignetilabtest.databinding.FragmentHomeBinding
import com.example.ignetilabtest.models.TodoViewModel


class HomeFragment : Fragment() {
    var todoRecord: TodoRecord? = null
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnSave.setOnClickListener {
            saveTodo()
        }

        val view = binding.root
        return view
    }


    private fun saveTodo() {
        if (validateFields()) {
            val id = if (todoRecord != null) todoRecord?.id else null
            val todoViewModel = TodoViewModel(requireContext().applicationContext)
            val todo = TodoRecord(
                id = id,
                title = binding.etTodoTitle.text.toString(),
                content = binding.etTodoContent.text.toString(),
                status = false
            )
            todoViewModel.saveTodo(todo)

            binding.etTodoTitle.text.clear()
            binding.etTodoContent.text.clear()
            Toast.makeText(context, "Added in todo list", Toast.LENGTH_SHORT).show()

            hideKeyboard()
        }
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun validateFields(): Boolean {
        if (binding.etTodoTitle.text.isEmpty()) {
            binding.tilTodoTitle.error = getString(R.string.pleaseEnterTitle)
            binding.etTodoTitle.requestFocus()
            return false
        }
        if (binding.etTodoContent.text.isEmpty()) {
            binding.tilTodoContent.error = getString(R.string.pleaseEnterContent)
            binding.etTodoContent.requestFocus()
            return false
        }
        return true
    }

}