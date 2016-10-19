try {
    doWork();
    return 123;
}
catch (Exception e) {
    // Handle exception here
    return 456;
}
finally {
    // The following return will not be executed
    return 789;
}
