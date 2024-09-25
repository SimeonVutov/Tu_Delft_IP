class StringList {

    private String[] elements;
    private int amount;

    public StringList(int n) {
        this.amount = 0;
        if(n >= 0) {
            this.elements = new String[n];
        }
        else {
            this.elements = new String[0];
        }
    }

    public void add(String el) {
        if(amount < elements.length) {
            elements[amount] = el;
            amount++;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String get(int i) {
        if(i >= 0 && i < amount) {
            return elements[i];
        }
        else {
            return null;
        }
    }

    public void set(int i, String el) {
        if(i < amount) {
            elements[i] = el;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public int index(String el) {
        for(int i = 0; i < amount; i++) {
            if(elements != null && elements[i].equals(el)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(String el) {
        int index = index(el);
        
        return index != -1;
    }

    public int getSize() {
        return this.amount;
    }

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }

        if(other == null || this.getClass() != other.getClass()) {
            return false;
        }

        StringList that = (StringList) other;

        if(this.amount == that.amount) {
            for(int i = 0; i < that.elements.length; i++) {
                if(this.index(that.elements[i]) != i) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public String toString() {
        String res = "<StringList([";

        for(int i = 0; i < amount - 1; i++) {
            res += elements[i] + ", ";
        }

        res += elements[amount] + "])>";

        return res;
    }
}

public class exercise2 {
    public static void main(String[] args) {
        StringList one = new StringList(3);
        StringList other = new StringList(3);
        System.out.println("Before adding");
        one.add(null);
        one.add("a");
        System.out.println(one.toString());
        other.add(null);
        other.add("a");
        System.out.println(other.toString());
    }
}
