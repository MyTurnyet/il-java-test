package dev.paigewatson.models;

import dev.paigewatson.models.store.ItemName;

public interface ItemMatcher
{
    boolean matchesItemName(ItemName StoreItemName);
}
