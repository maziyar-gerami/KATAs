public enum Action {
    COUNT_CHARS("count chars"),
    COUNT_WORDS("count words"),
    REVERSE("reverse"),
    UPPERCASE("upercase"),
    LOWERCASE("lowercase");

    private final String name;


    Action(String string) {
        this.name = string;
    }

    public String getName() {
        return name;
    }

}
