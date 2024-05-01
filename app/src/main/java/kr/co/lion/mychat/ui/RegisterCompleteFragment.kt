package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.mychat.MainActivity
import kr.co.lion.mychat.databinding.FragmentRegisterCompleteBinding
import kr.co.lion.mychat.utils.FragmentName

class RegisterCompleteFragment : Fragment() {

    lateinit var binding: FragmentRegisterCompleteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRegisterCompleteBinding.inflate(inflater)

        settingButton()

        return binding.root
    }

    private fun settingButton(){
        with(binding){
            buttonStart.setOnClickListener {
                (activity as MainActivity).replaceFragment(FragmentName.MAIN_FRAGMENT, false, true, null)
            }
        }
    }

}