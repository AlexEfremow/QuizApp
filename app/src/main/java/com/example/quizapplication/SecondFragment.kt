package com.example.quizapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.quizapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionsInfo()
        val animationFadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.faid_in_anim)
        viewAnimations(animationFadeIn)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }
        binding.sendButton.setOnClickListener {
            val number = getAnswersByUser()
            val args = Bundle()
//            Log.d("OLD_ARGS", args.toString())
            args.putInt("number", number)
//            Log.d("NUMBER", number.toString())
//            Log.d("NEW_ARGS", args.toString())
            Navigation.findNavController(view)
                .navigate(R.id.action_secondFragment_to_resultFragment, args)
//            Log.d("VIEW", view.toString())
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onBackPressed() {
        findNavController().popBackStack()
    }

    private fun getAnswersByUser(): Int {
        var correctAnswersCount = 0

        if (binding.firstQuestion.answer3.isChecked) correctAnswersCount++
        if (binding.secondQuestion.answer1.isChecked) correctAnswersCount++
        if (binding.thirdQuestion.answer2.isChecked) correctAnswersCount++
        if (binding.fourthQuestion.answer3.isChecked) correctAnswersCount++
        if (binding.fifthQuestion.answer2.isChecked) correctAnswersCount++
        if (binding.sixthQuestion.answer1.isChecked) correctAnswersCount++

        return correctAnswersCount
    }
    private fun viewAnimations(anim: Animation) {
        binding.firstQuestion.textView2.startAnimation(anim)
        binding.secondQuestion.textView2.startAnimation(anim)
        binding.thirdQuestion.textView2.startAnimation(anim)
        binding.fourthQuestion.textView2.startAnimation(anim)
        binding.fifthQuestion.textView2.startAnimation(anim)
        binding.sixthQuestion.textView2.startAnimation(anim)
        binding.sendButton.startAnimation(anim)
        binding.backButton.startAnimation(anim)
    }

    private fun questionsInfo() {

        binding.firstQuestion.textView2.text = getString(R.string.first_question_text)
        binding.firstQuestion.answer1.text = getString(R.string.first_question_answer_1)
        binding.firstQuestion.answer2.text = getString(R.string.first_question_answer_2)
        binding.firstQuestion.answer3.text =
            getString(R.string.first_question_answer_3) // правильный

        binding.secondQuestion.textView2.text = getString(R.string.second_question_text)
        binding.secondQuestion.answer1.text =
            getString(R.string.second_question_answer_1) // правильный
        binding.secondQuestion.answer2.text = getString(R.string.second_question_answer_2)
        binding.secondQuestion.answer3.text = getString(R.string.second_question_answer_3)

        binding.thirdQuestion.textView2.text = getString(R.string.third_question_text)
        binding.thirdQuestion.answer1.text = getString(R.string.third_question_answer_1)
        binding.thirdQuestion.answer2.text =
            getString(R.string.third_question_answer_2) // правильный
        binding.thirdQuestion.answer3.text = getString(R.string.third_question_answer_3)

        binding.fourthQuestion.textView2.text = getString(R.string.fourth_question_text)
        binding.fourthQuestion.answer1.text = getString(R.string.fourth_question_answer_1)
        binding.fourthQuestion.answer2.text = getString(R.string.fourth_question_answer_2)
        binding.fourthQuestion.answer3.text =
            getString(R.string.fourth_question_answer_3) // правильный

        binding.fifthQuestion.textView2.text = getString(R.string.fifth_question_text)
        binding.fifthQuestion.answer1.text = getString(R.string.fifth_question_answer_1)
        binding.fifthQuestion.answer2.text =
            getString(R.string.fifth_question_answer_2) // правильный
        binding.fifthQuestion.answer3.text = getString(R.string.fifth_question_answer_3)

        binding.sixthQuestion.textView2.text = getString(R.string.sixth_question_text)
        binding.sixthQuestion.answer1.text =
            getString(R.string.sixth_question_answer_1) // правильный
        binding.sixthQuestion.answer2.text = getString(R.string.sixth_question_answer_2)
        binding.sixthQuestion.answer3.text = getString(R.string.sixth_question_answer_3)
    }
}