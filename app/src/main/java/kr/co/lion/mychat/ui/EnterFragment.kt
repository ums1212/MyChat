package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.mychat.MainActivity
import kr.co.lion.mychat.databinding.FragmentEnterBinding
import kr.co.lion.mychat.utils.FragmentName

class EnterFragment : Fragment() {

    lateinit var binding: FragmentEnterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEnterBinding.inflate(inflater)

        settingButton()

        return binding.root
    }

    private fun settingButton(){
        with(binding){
            // 로그인 버튼
            buttonLogin.setOnClickListener {
                (activity as MainActivity).replaceFragment(FragmentName.LOGIN_FRAGMENT, true, true, null)
            }

            // 회원가입 버튼
            buttonRegister.setOnClickListener {
                (activity as MainActivity).replaceFragment(FragmentName.REGISTER_FRAGMENT, true, true, null)
            }
        }
    }

}