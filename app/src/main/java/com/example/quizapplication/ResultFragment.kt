package com.example.quizapplication

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.activity.addCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapplication.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments?.getInt("number")
        val animationFadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.faid_in_anim)
        binding.resultNumber.startAnimation(animationFadeIn)
        if(args == 6) {
        }
        when(args) {
            6 -> {binding.image.setImageResource(R.drawable.free_icon_education_6012710)
                binding.resultTextview2.text = "You're the genius!"}
            in 0 .. 2 -> {
                binding.image.setImageResource(R.drawable.free_icon_error_1375138)
                binding.resultTextview2.text = "Try again!"
            }
            else -> {
                binding.image.setImageResource(R.drawable.free_icon_book_6915042)
                binding.resultTextview2.text = "Good job!"
            }
        }
        binding.resultNumber.text = args.toString()

        binding.startAgain.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_resultFragment_to_secondFragment)
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            Navigation.findNavController(view)
                .navigate(R.id.action_resultFragment_to_secondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}