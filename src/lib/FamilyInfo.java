package lib;

public class FamilyInfo {
    public boolean isMarried;
    public int numberOfChildren;

    public FamilyInfo(boolean isMarried, int numberOfChildren) {
        this.isMarried = isMarried;
        this.numberOfChildren = Math.min(numberOfChildren, 3);
    }
}
