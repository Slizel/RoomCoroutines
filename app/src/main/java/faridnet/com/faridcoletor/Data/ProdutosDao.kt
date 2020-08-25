package faridnet.com.faridcoletor.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import faridnet.com.faridcoletor.Model.Contagens
import faridnet.com.faridcoletor.Model.Produtos

@Dao
interface ProdutosDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProduto(produtos: Produtos)

    @Update
    suspend fun updateProdutos(produtos: Produtos)

    //    Deleta somente 1 linha
    @Delete
    suspend fun deleteProdutos(produtos: Produtos)

    @Query("DELETE FROM product_table")
    suspend fun deleteAllProdutos()

    @Query("SELECT * FROM product_table ORDER BY produtoId ASC")
    fun readAllData(): LiveData<List<Produtos>>
}