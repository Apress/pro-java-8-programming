int[] deleteIndices;
List myList;
//  Populate list, get indices of objects to be deleted
.
.
.
for (int i = 0; i < deleteIndices.length; i++) {
   myList.remove(deleteIndices[i]);
}