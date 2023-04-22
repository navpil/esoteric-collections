# Esoteric collections

## Implemented

You should not store null in usual collections.
But what if the only thing you need to store are nulls?
These collections might help you.
They are very space efficient, optimized for null storage.

 - NullOnlyList - a very space efficient collection to store only nulls
 - NullOnlySet - a very space efficient collection to store only nulls

Following collections restrict usage for some methods due to security reasons or personal considerations

 - GreedyList - a very greedy collection which wants only to receive new elements and tell you how much elements 
it has, but it won't tell you what are these elements excactly.
Removal is also not possible.
 - ShrinkOnlyCollection - create a collection with elements and no additional `add` are possible
 - NeverKnowTheSizeCollection - size and isEmpty are forbidden. Why do you need those anyway?
 - Frozen collection - ability to `freeze` collection, so it can never be ever modified again.
 - UniterableMap - keySet() and entrySet() unavailable, only get() is possible
Also you won't find out what is the size of this collection.
You should know the key to get the value, full stop.

 - Max size collection (removes random element on .add())
 - HideMap - adds a `hide` method for uniterable keys
 - SplitByHalfList - allows to split the list exactly into 2 parts
 - SplitByPrimeList - allows to split the list exactly by lowest prime

## Waiting for implementation

 - NullOnlyDeque
 - HardcoreImmutableCollection (checks for clone, copy constructor or Serializable, otherwise throws)
 - N2List - guarantees O(n^2) performance on all operations. Can be used for finding weak places.
 - UnorderedList - guarantees that the list will never keep the order of elements added
 - DoNotWorkOnWeekendsCollections - throws exceptions for every mutable operation on Saturdays and on every operation on Sundays 

### Actually useful

 - SortedBag (similar to a TreeSet with duplicate elements) 