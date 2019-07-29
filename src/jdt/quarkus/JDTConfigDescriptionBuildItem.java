package jdt.quarkus;

//import io.quarkus.builder.item.MultiBuildItem;

/**
 * A build item that is not part of the standard build, but is only used to generate
 * example config files and docs
 */
public final class JDTConfigDescriptionBuildItem implements Comparable<JDTConfigDescriptionBuildItem> {

    private final String propertyName;
    private final Class<?> type;
    private final String defaultValue;
    private final String docs;

    public JDTConfigDescriptionBuildItem(String propertyName, Class<?> type, String defaultValue, String docs) {
        this.propertyName = propertyName;
        this.type = type;
        this.defaultValue = defaultValue;
        this.docs = docs;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Class<?> getType() {
        return type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getDocs() {
        return docs;
    }

    @Override
    public int compareTo(JDTConfigDescriptionBuildItem o) {
        return propertyName.compareTo(o.propertyName);
    }
}
