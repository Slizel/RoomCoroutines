package faridnet.com.faridcoletor.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "product_table")
data class Produtos(
    val codBarras: String,
    @PrimaryKey(autoGenerate = true)
    val produtoId: Int,
    val descricao: String

): Parcelable