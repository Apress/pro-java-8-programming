switch (myValue) {
    case 1:
        doWork(); // This is a fallthrough
    case -1:
        doMoreWork();
        break;
    default:
        isZero = true;
        break;
}
