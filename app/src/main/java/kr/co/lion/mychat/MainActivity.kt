package kr.co.lion.mychat

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.transition.MaterialSharedAxis
import kr.co.lion.mychat.ui.ChatListFragment
import kr.co.lion.mychat.ui.ChattingFragment
import kr.co.lion.mychat.ui.EnterFragment
import kr.co.lion.mychat.ui.LoginFragment
import kr.co.lion.mychat.ui.MainFragment
import kr.co.lion.mychat.ui.MypageFragment
import kr.co.lion.mychat.ui.Register2Fragment
import kr.co.lion.mychat.ui.RegisterCompleteFragment
import kr.co.lion.mychat.ui.RegisterFragment
import kr.co.lion.mychat.utils.FragmentName

class MainActivity : AppCompatActivity() {

    // 프래그먼트 객체를 담을 변수
    var oldFragment: Fragment? = null
    var newFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        replaceFragment(FragmentName.ENTER_FRAGMENT, false, false, null);
    }

    fun replaceFragment(name: FragmentName, addToBackStack:Boolean, isAnimate:Boolean, data:Bundle?){
        SystemClock.sleep(200)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if(newFragment != null){
            oldFragment = newFragment
        }

        newFragment = when(name){
            FragmentName.ENTER_FRAGMENT -> { EnterFragment() }
            FragmentName.LOGIN_FRAGMENT -> { LoginFragment() }
            FragmentName.REGISTER_FRAGMENT -> { RegisterFragment() }
            FragmentName.REGISTER2_FRAGMENT -> { Register2Fragment() }
            FragmentName.REGISTER_COMPLETE_FRAGMENT -> { RegisterCompleteFragment() }
            FragmentName.MAIN_FRAGMENT -> { MainFragment() }
            FragmentName.CHAT_LIST_FRAGMENT -> { ChatListFragment() }
            FragmentName.CHATTING_FRAGMENT -> { ChattingFragment() }
            FragmentName.MYPAGE_FRAGMENT -> { MypageFragment() }
        }

        if(data != null){
            newFragment?.arguments = data
        }

        if(newFragment != null){
            if(isAnimate){
                // MaterialSharedAxis : 좌우, 위아래, 공중 바닥 사이로 이동하는 애니메이션 효과
                // X - 좌우
                // Y - 위아래
                // Z - 공중 바닥
                // 두 번째 매개변수 : 새로운 화면이 나타나는 것인지 여부를 설정
                // true : 새로운 화면이 나타나는 애니메이션이 동작한다.
                // false : 이전으로 되돌아가는 애니메이션이 동작한다.
                if(oldFragment != null){
                    // old에서 new가 새롭게 보여질 때 old의 애니메이션
                    oldFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
                    // new에서 old로 되돌아갈 때 old의 애니메이션
                    oldFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

                    oldFragment?.enterTransition = null
                    oldFragment?.returnTransition = null
                }

                // old에서 new가 새롭게 보여질 때 new의 애니메이션
                newFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
                // new에서 old로 되돌아갈 때의 애니메이션
                newFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

                newFragment?.exitTransition = null
                newFragment?.reenterTransition = null
            }

            fragmentTransaction.replace(R.id.fragmentContainerView, newFragment!!)

            if(addToBackStack == true){
                fragmentTransaction.addToBackStack(name.str)
            }

            fragmentTransaction.commit()
        }
    }

    fun removeFragment(name: FragmentName){
        SystemClock.sleep(200)

        supportFragmentManager.popBackStack(name.str, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}

