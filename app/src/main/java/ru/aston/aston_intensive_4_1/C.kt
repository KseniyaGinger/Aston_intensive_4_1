package ru.aston.aston_intensive_4_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class C : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_c, container, false)

        val message = arguments?.getString("message") ?: "Default Message"
        view.findViewById<TextView>(R.id.text).text = message

        view.findViewById<TextView>(R.id.text).text = message

        val nextButton = view.findViewById<Button>(R.id.c_fragment_button_next)
        nextButton.setOnClickListener {
            val navController = view.findNavController()
            navController.navigate(R.id.action_c_to_d)
        }

        val backButton = view.findViewById<Button>(R.id.c_fragment_button_back)
        backButton.setOnClickListener {
            val navController = view.findNavController()
            navController.navigate(R.id.action_c_to_a)
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            C().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}