package com.engagepoint.model.questionnaire;

/**
 * Basic properties of beans
 * Must have only methods need fot all bean type
 */
public abstract class BasicBean {
    private String displayedName;

    /** Return type of bean */
    public abstract String getType();

    /** Return ID of bean as String */
    public abstract String getDisplayedId();

    /** Return displayed name of bean */
    public String getDisplayedName() {
        return displayedName;
    }

    /** Set displayed name of bean */
    public void setDisplayedName(String name) {
        this.displayedName = name;
    }
}
