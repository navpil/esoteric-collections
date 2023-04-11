# Esoteric collections

## Implemented

You should not store null in usual collections.
But what if the only thing you need to store are nulls?
These collections might help you.
They are very space efficient, optimized for null storage.

 - NullOnlyList - a very space efficient collection to store only nulls
 - NullOnlySet - a very space efficient collection to store only nulls


## Waiting for implementation

 - NullOnlyDeque
 - Max size collection (removes random element on .add())
 - UniterableMap - keySet() and entrySet() unavailable, only get() is possible
 - SplitByHalfList - allows to split the list exactly into 2 parts
 - SplitByPrimeList - allows to split the list exactly by lowest prime
 - HideMap - adds a `hide` method for uniterable keys
 - NeverKnowTheSizeCollection - size and isEmpty are forbidden
 - NoGetCollection - can only add, but not remove, nor get. One may always use reflection for getting.
 - RemoveOnlyCollection - create a collection with elements and no additional `add` are possible
 - HardcoreImmutableCollection (checks for clone, copy constructor or Serializable, otherwise throws)
 - N2List - guarantees O(n^2) performance on all operations. Can be used for finding weak places.
 - UnorderedList - guarantees that the list will never keep the order of elements added
 - Frozen collection - ability to `freeze` collection, so it can never be ever modified again
 - DoNotWorkOnWeekendsCollections - throws exceptions for every mutable operation on Saturdays and on every operation on Sundays 
