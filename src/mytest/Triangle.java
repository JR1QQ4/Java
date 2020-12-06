package mytest;

public class Triangle {
    public boolean judgeEdges(int a, int b, int c) {
        boolean result = true;
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        if (a + b <= c) result = false;
        if (c + b <= a) result = false;
        if (a + c <= b) result = false;
        return result;
    }
}
