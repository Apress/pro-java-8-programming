BreakIterator bi = BreakIterator.getSentenceInstance();
String sent = "This is a sentence! Is this a sentence too? " +
    "This is the last sentence.";
bi.setText(sent);
int lastIndex = bi.first();
int currentIndex = bi.next();
while (currentIndex != BreakIterator.DONE) {
  System.out.println(sent.substring(lastIndex, currentIndex));
  lastIndex = currentIndex;
  currentIndex = bi.next();
}
