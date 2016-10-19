// This anonymous inner class is equivalent to the lambda: item -> (item.startsWith(prefix))
Predicate<String> prefixSelector = new Predicate<String>() {
        public boolean test(String candidate)
        {
            return candidate.startsWith(prefix);
        }
};
Stream<String> dataSource = myItems.stream();
Stream<String> filtered = dataSource.filter(prefixSelector);
Collector<String, ?, List<String>> collector = Collectors.toList();
List<String> myList = filtered.collect(collector);