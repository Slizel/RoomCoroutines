package faridnet.com.faridcoletor.Fragments.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import faridnet.com.faridcoletor.Viewmodel.AppViewModel
import faridnet.com.faridcoletor.R
import kotlinx.android.synthetic.main.fragment_list.view.*


class ListFragment : Fragment() {

    private lateinit var  cAppViewModel: AppViewModel
    private lateinit var  pAppViewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //AppViewModel - > Contagens
        cAppViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        cAppViewModel.Cont_readAllData.observe(viewLifecycleOwner, Observer { contagens ->
            adapter.setContagensData(contagens)

        })

        //AppViewModel - > Produtos
        pAppViewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        pAppViewModel.Prod_readAllData.observe(viewLifecycleOwner, Observer { produto ->
            adapter.setProdutosData(produto)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }


        return view
    }
}