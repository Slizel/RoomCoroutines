package faridnet.com.faridcoletor.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import faridnet.com.faridcoletor.Model.Inventario
import faridnet.com.faridcoletor.Model.Produtos

@Dao
interface InventarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInventario(inventario: Inventario)

    //    Deleta somente 1 linha
    @Delete
    suspend fun deleteInventario(inventario: Inventario)

    @Query("DELETE FROM inventrio_table")
    suspend fun deleteAllInventarios()

    @Query("SELECT * FROM inventrio_table ORDER BY inventarioId ASC")
    fun readAllData(): LiveData<List<Produtos>>

}