package risk.tile;

public record Position(int row, int column) {

    public boolean equals(Position otherPosition) {
        if (otherPosition == null) {
            return false;
        }
        return ((this.row() == otherPosition.row()) && (this.column() == otherPosition.column()));
    }

    public boolean adjacent(Position otherPosition) { // can maybe use this now obsolete but working function as a unittester
        if (otherPosition == null) {
            return false;
        }
        int rowdif = this.row() - otherPosition.row();
        int columndif = this.column() - otherPosition.column();
        boolean adjacent = false;
        boolean even = (this.row %2 == 0);

        if (columndif == 0) {
            if (rowdif != 0) {
                if (rowdif <= 2 && rowdif >= -2) {
                    adjacent = true;
                    System.out.println("adjacent,num 1, column dif = " + columndif + ", row dif = " + rowdif + ", even row = " + even);
                }
            }
        }
        else if (columndif == 1 && this.row %2 != 0) {
            if (rowdif == 1 || rowdif == -1) {
                adjacent = true;
                System.out.println("adjacent,num 2, column dif = " + columndif + ", row dif = " + rowdif + ", even row = false");
            }
        }
        else if (columndif == -1 && this.row %2 == 0) {
            if (rowdif == 1 || rowdif == -1) {
                adjacent = true;
                System.out.println("adjacent, num 3, column dif = " + columndif + ", row dif = " + rowdif + ", even row = true");
            }
        }
        else {
            System.out.println("not adjacent, column dif = " + columndif + ", row dif = " + rowdif + ", even row = " + even);
        }
        return adjacent;
    }

    @Override
    public String toString() {
        return column + ":" + row;
    }
}