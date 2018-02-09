package bffisher.fasnap.dummy

import java.util.ArrayList
import java.util.HashMap

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
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: Map<String, DummyItem> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        //        ITEM_MAP.put(item.id, item);
    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position, "Item " + position, 1000 + position * 10)
    }

    /**
     * A dummy item representing a piece of content.
     */
    class DummyItem(val id: Int, val name: String, val amount: Int) {

        override fun toString(): String {
            return String.format("%s: %d", name, amount)
        }
    }
}
