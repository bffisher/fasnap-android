package bffisher.fasnap.entity

/**
 * Created by bffisher on 2018/02/11.
 */
data class SnapshotEntity(
        var date: String = "",
        var amount: Int = 0,
        val assetItems: MutableList<AssetItemEntity> = ArrayList())