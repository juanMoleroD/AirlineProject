public class Pilot extends CabinCrewMember{

    private String licence;

    public Pilot(String name, CrewRank rank, String licence) {
        super(name, rank);
        this.licence = licence;
    }

    public String getLicence() {
        return licence;
    }

    public String flyPlane(Plane plane) {
        return "Pilot is flying the plane";
    }
}
