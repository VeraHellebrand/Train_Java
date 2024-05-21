package Train;

public class Engine {

    private final TypeEngine type;


    public enum TypeEngine {
        DIESEL("dieselová"),
        STEAM("parní"),
        ELECTRIC("elektrická");

        private final String displayName;

        TypeEngine(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    public Engine(TypeEngine type) {
        this.type = type;
    }

    public TypeEngine getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Engine: " +
                "typ motoru = " + type.displayName + "\n";
    }
}
