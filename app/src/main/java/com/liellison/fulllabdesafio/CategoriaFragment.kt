package com.liellison.fulllabdesafio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 */
class CategoriaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_categoria, container, false)
        return view
    }

    companion object{
        fun newInstance(): CategoriaFragment = CategoriaFragment()
    }


}
