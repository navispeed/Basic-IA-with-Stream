package eu.navispeed;

public class Combinaison {
    private int c[];
    private int base;

    public Combinaison(int[] c, int base) {
        this.c = c.clone();
        this.base = base;
    }

    public void increment() {
        _increment(c.length - 1);
    }

    public int[] getC() {
        return c;
    }

    private void _increment(int i) {
        if (i == -1) {
            for (int j = 0; j < c.length; j++) {
                c[j] = 0;
            }
            return;
        }
        if (c[i] == base - 1) {
            c[i] = 0;
            _increment(i - 1);
            return;
        }
        c[i]++;
    }


}
