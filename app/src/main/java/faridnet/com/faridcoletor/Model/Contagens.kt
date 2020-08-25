package faridnet.com.faridcoletor.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "contagem_table"
//    ,foreignKeys = [ForeignKey(
//        entity = Produtos::class,
//        parentColumns =["produtoId"],
//        childColumns = ["produtoId"] )
//    ]
)

data class Contagens(

    @PrimaryKey(autoGenerate = true)
    val produtoId: Int,
    val quantidade: Int,
    val dataHora: String

) : Parcelable {

    override fun toString(): String {
        return "ID=$produtoId Qtd='$quantidade' Data='$dataHora\n"
    }
}