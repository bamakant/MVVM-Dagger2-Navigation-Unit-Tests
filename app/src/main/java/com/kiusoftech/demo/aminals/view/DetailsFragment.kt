package com.kiusoftech.demo.aminals.view

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.kiusoftech.demo.aminals.R
import com.kiusoftech.demo.aminals.databinding.FragmentDetailsBinding
import com.kiusoftech.demo.aminals.model.Animal
import com.kiusoftech.demo.aminals.util.getProgressDrawable
import com.kiusoftech.demo.aminals.util.loadImage

class DetailsFragment : Fragment() {

    var animal: Animal? = null

    private lateinit var dataBinding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        return dataBinding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        buttonList.setOnClickListener {
//            val action = DetailsFragmentDirections.actionToListFragment();
//            Navigation.findNavController(it).navigate(action)
//        }
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            animal = DetailsFragmentArgs.fromBundle(it).animal
        }

        animal?.imageUrl?.let {
            setupBackgroudColor(it)
        }

        dataBinding.animal = animal
    }


    private fun setupBackgroudColor(url: String) {
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    Palette.from(resource)
                        .generate() { palette ->
                            val intColor = palette?.lightMutedSwatch?.rgb ?: 0
//                            dataBinding.detailsLayout.setBackgroundColor(intColor)
                            dataBinding.bgColor = intColor
                        }
                }

                override fun onLoadCleared(placeholder: Drawable?) {

                }

            })
    }

}
