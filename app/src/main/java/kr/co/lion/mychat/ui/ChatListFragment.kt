package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.mychat.R
import kr.co.lion.mychat.databinding.FragmentChatListBinding

class ChatListFragment : Fragment() {

    lateinit var binding: FragmentChatListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentChatListBinding.inflate(inflater)

        settingToolbar()

        return binding.root
    }

    private fun settingToolbar(){
        binding.toolbarChatList.apply {
            title = "채팅"
        }
    }

}