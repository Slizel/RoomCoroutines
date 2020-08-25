package faridnet.com.faridcoletor.Fragments.Add

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import faridnet.com.faridcoletor.Data.AppDatabase
import faridnet.com.faridcoletor.MainActivity
import faridnet.com.faridcoletor.Model.Contagens
import faridnet.com.faridcoletor.Model.Produtos
import faridnet.com.faridcoletor.Viewmodel.AppViewModel
import faridnet.com.faridcoletor.R
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    private lateinit var cAppViewModel: AppViewModel
    private lateinit var pAppViewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // Criar objeto da View Model
        pAppViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        cAppViewModel = ViewModelProvider(this).get(AppViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        view.add_btn2.setOnClickListener {
            clearDatabase()
        }

        view.add_btn3.setOnClickListener {

        }

        return view
    }


    // Database
    private fun insertDataToDatabase() {
        val codBarras = editTextTextCodBarras.text.toString()
        val qtde = editTextQuantidade.text.toString()
        val descricao = editTextDescricao.text.toString()

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())

        if (inputCheck(codBarras, qtde, descricao)) {
            //Create Product Object
            val contagem = Contagens(0, Integer.parseInt(qtde), currentDate)

            //Precisa criar váriavel que pega o código do produto
            val produto = Produtos(codBarras, 0, descricao)

            // Add Data to Database
            cAppViewModel.addContagens(contagem)
            pAppViewModel.addProdutos(produto)

            Toast.makeText(requireContext(), "Adicionado com sucesso", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Preencha os campos, por gentileza", Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(codBarras: String, qtde: String, descricao: String): Boolean {
        return !(TextUtils.isEmpty(codBarras) && TextUtils.isEmpty(qtde) && TextUtils.isEmpty(
            descricao
        ))
    }

    private fun clearDatabase() {
        //Alert Dialog
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Sim") { _, _ ->
            cAppViewModel.deleteAllContagens()
            pAppViewModel.deleteAllProdutos()


            Toast.makeText(
                requireContext(),
                "Banco foi limpo",
                Toast.LENGTH_SHORT
            ).show()

        }
        builder.setNegativeButton("Não") { _, _ -> }
        builder.setTitle("Limpar Banco de Dados")
        builder.setMessage("Tem certeza que deseja limpar o BD?")
        builder.create().show()
    }



}