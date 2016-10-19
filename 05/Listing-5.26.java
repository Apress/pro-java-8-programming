List<String> filteredList =
        myItems.stream()
        .filter(item -> item.startsWith(prefix))
        .map(item -> item.toLowerCase())
        .collect(Collectors.toList());