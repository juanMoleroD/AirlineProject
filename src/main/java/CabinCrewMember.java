public class CabinCrewMember {

    private String name;
    private CrewRank rank;

    public CabinCrewMember(String name, CrewRank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return this.name;
    }

    public CrewRank getRank() {
        return this.rank;
    }
}
