package bffisher.fasnap.entity

import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<SnapshotEntity> = ArrayList()

    private val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd")

    private val COUNT = 12

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: SnapshotEntity) {
        ITEMS.add(item)
    }

    private fun createDummyItem(position: Int): SnapshotEntity {
        var cal = Calendar.getInstance()
        cal.add(Calendar.MONTH, -position)

        return SnapshotEntity(dateFormat.format(cal.time), 1000 + position * 10)
    }
}
