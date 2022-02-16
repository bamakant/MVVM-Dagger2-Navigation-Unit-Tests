package com.kiusoftech.demo.aminals.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.kiusoftech.demo.aminals.R
import com.kiusoftech.demo.aminals.databinding.ItemAnimalBinding
import com.kiusoftech.demo.aminals.model.Animal
import com.kiusoftech.demo.aminals.util.getProgressDrawable
import com.kiusoftech.demo.aminals.util.loadImage
import kotlinx.android.synthetic.main.item_animal.view.*

class AnimalListAdapter(private val animalList: ArrayList<Animal>) :
    RecyclerView.Adapter<AnimalListAdapter.AnimalViewHolder>(), AnimalClickListener {


    fun updateAnimalList(newAnimalList: List<Animal>) {
        animalList.clear()
        animalList.addAll(newAnimalList)
        notifyItemInserted(newAnimalList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemAnimalBinding>(
            inflater,
            R.layout.item_animal,
            parent,
            false
        )
        return AnimalViewHolder(view);
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.view.animal = animalList[position]

//        holder.view.animalLayout.setOnClickListener {
//            val action = ListFragmentDirections.actionToDetailFragment(animalList[position])
//            Navigation.findNavController(holder.view).navigate(action)
//        }

        holder.view.listener = this
    }

    override fun getItemCount() = animalList.size


    class AnimalViewHolder(var view: ItemAnimalBinding) : RecyclerView.ViewHolder(view.root)

    override fun onClick(v: View) {
        for (animal in animalList) {
            if (v.tag == animal.name) {
                val action = ListFragmentDirections.actionToDetailFragment(animal)
                Navigation.findNavController(v).navigate(action)
            }
        }
    }
}
