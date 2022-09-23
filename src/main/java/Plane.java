public class Plane {

    private PlaneType type;

    public Plane(PlaneType type) {
        this.type = type;
    }

    public PlaneType getType() {
        return type;
    }

    public int getCapacity() {
        return type.getCapacity();
    }

    public int getTotalWeight() {
        return type.getTotalWeight();
    }
}
