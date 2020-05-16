package kk.myotpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import kk.custom.GenericKeyEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_otp.*
import ns.custonview.GenericTextWatcher

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextOTPField1.addTextChangedListener(GenericTextWatcher(editTextOTPField1, editTextOTPField2 ))
        editTextOTPField2.addTextChangedListener(GenericTextWatcher(editTextOTPField2, editTextOTPField3))
        editTextOTPField3.addTextChangedListener(GenericTextWatcher(editTextOTPField3, editTextOTPField4))
        editTextOTPField4.addTextChangedListener(GenericTextWatcher(editTextOTPField4, null))

        //GenericKeyEvent here works for deleting the element and to switch back to previous EditText
        //first parameter is the current EditText and second parameter is previous EditText
        editTextOTPField1.setOnKeyListener(GenericKeyEvent(editTextOTPField1, null))
        editTextOTPField2.setOnKeyListener(GenericKeyEvent(editTextOTPField2, editTextOTPField1))
        editTextOTPField3.setOnKeyListener(GenericKeyEvent(editTextOTPField3, editTextOTPField2))
        editTextOTPField4.setOnKeyListener(GenericKeyEvent(editTextOTPField4,editTextOTPField3))


        val fragment = supportFragmentManager
        val ft = fragment.beginTransaction()

        ft.add(R.id.cPane, MainFragment(),"")
        ft.commitAllowingStateLoss()

    }
}
