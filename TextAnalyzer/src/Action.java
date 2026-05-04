public enum Action {
    COUNT_CHARS("chars"),
    COUNT_WORDS("words"),
    REVERSE("reverse"),
    UPPERCASE("upercase"),
    LOWERCASE("lowercase"),
    STATS("stats"),
    DEFAULT("default");

    private final String name;


    Action(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }

}
