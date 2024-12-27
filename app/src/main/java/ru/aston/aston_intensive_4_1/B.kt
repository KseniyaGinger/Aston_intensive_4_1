package ru.aston.aston_intensive_4_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class B : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_b, container, false)

        val nextButton = view.findViewById<Button>(R.id.b_fragment_button_next)
        nextButton.setOnClickListener {
            val bundle = Bundle().apply {
                putString("message", "hello fragment C")
            }
            findNavController().navigate(R.id.action_b_to_c, bundle)
        }


        val backButton = view.findViewById<Button>(R.id.b_fragment_button_back)
        backButton.setOnClickListener {
            val navController = view.findNavController()
            navController.navigate(R.id.action_b_to_a)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            B().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

