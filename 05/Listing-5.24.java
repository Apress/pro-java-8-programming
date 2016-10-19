List<String> filteredList =
        myItems.stream()
        .filter(item -> item.startsWith(prefix))
        .collect(Collectors.toList());