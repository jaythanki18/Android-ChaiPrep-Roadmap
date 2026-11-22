# Day 3: LazyColumn, LazyRow and item keys

- `Column`/`Row` compose every child up front. `LazyColumn`/`LazyRow` only compose and lay out the items visible on screen (plus a small buffer), so long lists stay cheap.
- Lazy lists use a DSL: `items(list) { item -> ... }` instead of a loop of composables.
- Without a key, an item is identified by its position. Inserting at the top shifts every index, so every row looks "changed".
- With `key = { it.id }`, Compose tracks each row by identity: inserts/removals only compose the new row, existing rows are moved, and per-row state (`remember`) follows the item.
- Keys must be unique and stable (a database id, not the index).
- Use `mutableStateListOf` so list changes trigger recomposition.
- `contentPadding` pads the scrolling content without clipping it; `Arrangement.spacedBy` adds gaps between items.
