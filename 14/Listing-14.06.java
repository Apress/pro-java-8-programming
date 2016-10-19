CharacterData charData;
// ...
charData.setData("This is a test");
// The word "is" has an index of 5 (it's the sixth character in the string)
int start = 5;
// The word "is" has a length of 2 (it's two characters long)
int length = 2;
charData.replaceData(start, length, "was");
// The following line prints "This was a test");
System.out.println(charData.getData());
