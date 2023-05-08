package com.thies.photogallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.thies.photogallery.api.FlickrApi
import com.thies.photogallery.databinding.FragementPhotoGalleryBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.create

private const val TAG = "PhotoGalleryFragment"

class PhotoGalleryFragment : Fragment() {
    private var _binding: FragementPhotoGalleryBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragementPhotoGalleryBinding.inflate(inflater, container, false)
        binding.photoGrid.layoutManager = GridLayoutManager(context, 3)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // launch a coroutine using the viewLifecycleOwner.lifecycleScope property
        viewLifecycleOwner.lifecycleScope.launch {
            try{
                val response = PhotoRepository().fetchPhotos()
                Log.d(TAG, "Response received: $response")
            } catch(ex: Exception) {
                android.util.Log.d(TAG, "Failed to fetch gallery items", ex)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





