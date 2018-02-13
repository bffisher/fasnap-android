package bffisher.fasnap.entity

/**
 * Created by bffisher on 2018/02/11.
 */
data class AssetItemEntity(
        var no: Int = 0,
        var platform: String = "",
        var risk: String = "",
        var term: String = "",
        var name: String = "",
        var amount: Int = 0)