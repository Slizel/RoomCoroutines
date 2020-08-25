package faridnet.com.faridcoletor.Fragments.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import faridnet.com.faridcoletor.Model.Contagens
import faridnet.com.faridcoletor.Model.Produtos
import faridnet.com.faridcoletor.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var contagensList = emptyList<Contagens>()
    private var produtosList = emptyList<Produtos>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return contagensList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val contagensItem = contagensList[position]
        val produtosItem = produtosList[position]

        holder.itemView.codInternoTextView.text = produtosItem.produtoId.toString()
        holder.itemView.codBarrasTextView.text = produtosItem.codBarras
        holder.itemView.qtdeTextView.text = contagensItem.quantidade.toString()
        holder.itemView.descricaoTextView.text = produtosItem.descricao

        holder.itemView.rowLayout.setOnClickListener {


            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(
                contagensItem,
                produtosItem
            )
            holder.itemView.findNavController().navigate(action)

        }

    }


    fun setContagensData(contagens: List<Contagens>) {
        this.contagensList = contagens
        notifyDataSetChanged()
    }

    fun setProdutosData(produtos: List<Produtos>) {
        this.produtosList = produtos
        notifyDataSetChanged()
    }


}