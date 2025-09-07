package basics.o11.oop.projekt_uml;

import java.util.ArrayList;
import java.util.List;

public class SalesGroup {

    private List<Seller> members = new ArrayList<>();
    private Seller leader;

    public SalesGroup(Seller leader) {
        setLeader(leader);
    }

    public void addMember(Seller seller) {
        if (!members.contains(seller)) {
            members.add(seller);
            seller.setGroup(this);
        }
    }

    public void removeMember(Seller seller) {
        if (members.contains(seller)) {
            members.remove(seller);
            seller.setGroup(null);

            // jeśli usunięty to lider, to wyczyść
            if (leader != null && leader.equals(seller)) {
                leader = null;
            }
        }
    }

    public List<Seller> getMembers() {
        return members;
    }

    public Seller getLeader() {
        return leader;
    }

    public void setLeader(Seller leader) {
        if (!members.contains(leader)) {
            addMember(leader);
        }
        this.leader = leader;
    }
}
