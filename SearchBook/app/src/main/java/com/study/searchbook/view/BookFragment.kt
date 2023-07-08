package com.study.searchbook.view

import android.view.Menu
import android.view.MenuInflater
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.study.searchbook.R
import com.study.searchbook.base.BaseFragment
import com.study.searchbook.databinding.FragmentBookBinding


class BookFragment : BaseFragment<FragmentBookBinding>(R.layout.fragment_book) {
    private val client_id = "JByY3rxLsDenflIN8gfB"
    private val client_secret = "R6RRNnD1Um"
    private val bookViewModel: BookViewModel by activityViewModels()
    override fun init() {
        setHasOptionsMenu(true)
        binding.btn.setOnClickListener {
            bookViewModel.getBooks(client_id, client_secret, "안드로이드")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }



}