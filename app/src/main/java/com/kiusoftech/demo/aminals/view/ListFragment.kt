package com.kiusoftech.demo.aminals.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.kiusoftech.demo.aminals.R
import com.kiusoftech.demo.aminals.model.Animal
import com.kiusoftech.demo.aminals.viewmodel.AnimalViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    private lateinit var animalViewModel: AnimalViewModel
    private val animalListAdapter = AnimalListAdapter(arrayListOf())

    private val animalListLiveDataObserver = Observer<List<Animal>> { list ->
        list?.let {
            animalList.visibility = View.VISIBLE
            animalListAdapter.updateAnimalList(it)
        }
    }

    private val loadingLiveDataObserver = Observer<Boolean> { isLoading ->
        loadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
        if (isLoading) {
            listError.visibility = View.GONE
            animalList.visibility = View.GONE
        }
    }

    private val errorLiveDataObserver = Observer<Boolean> { isError ->
        listError.visibility = if (isError) View.VISIBLE else View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        buttonAdd.setOnClickListener {
//            val action = ListFragmentDirections.actionToDetailFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalViewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)
        animalViewModel.animals.observe(viewLifecycleOwner, animalListLiveDataObserver)
        animalViewModel.loading.observe(viewLifecycleOwner, loadingLiveDataObserver)
        animalViewModel.loadError.observe(viewLifecycleOwner, errorLiveDataObserver)
        animalViewModel.refresh()

        animalList.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = animalListAdapter
        }

        refreshLayout.setOnRefreshListener {
            animalList.visibility = View.GONE
            listError.visibility = View.GONE
            loadingView.visibility = View.GONE
            animalViewModel.hardRefresh()
            refreshLayout.isRefreshing = false
        }

    }

}
