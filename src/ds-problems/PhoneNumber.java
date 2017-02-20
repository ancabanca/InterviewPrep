public class PhoneNumber {
    // I tried to declare these as short, but then everytime I passed an int literal
    //  as argument, it needed explicit casting, which is a pain. Surprising that
    //  Java doesn't handle this situation more elegantly.
    private int areaCode;
    private int prefix;
    private int lineNumber;

    // A variable volatile is written to/read from the main memory, rather than CPU cache.
    // This guarantees the visibility of the variable  for read/writes to that variable.
    // Link: http://tutorials.jenkov.com/java-concurrency/volatile.html
    private volatile int hashCode;

    public PhoneNumber(int ac, int p, int ln) {
        rangeCheck(ac,  999, "area code"); // 
        rangeCheck(p,   999, "prefix");
        rangeCheck(ln, 9999, "line number");
        areaCode = ac;
        prefix = p;
        lineNumber = ln;
    }

    // Static factory method
    // String format: "xxx-xxx-xxxx"
    public static PhoneNumber getInstance(String s) {
        String[] tokens = s.split("-");
        return new PhoneNumber(Integer.parseInt(tokens[0]),
            Integer.parseInt(tokens[1]), 
            Integer.parseInt(tokens[2]));
    }

    public int getAreaCode() {
        return areaCode;
    }

    public int getPrefix() {
        return prefix;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        if(this.areaCode   == pn.areaCode && 
           this.prefix     == pn.prefix   &&
           this.lineNumber == pn.lineNumber)
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = hashCode;
        if(result == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + prefix;
            result = 31 * result + lineNumber;
            hashCode = result;
        }
        return result;
    }

    // String format: "xxx-xxx-xxxx"
    @Override
    public String toString() {
        String s = String.format("%03d-%03d-%04d", areaCode, prefix, lineNumber);
        return s;
    }

    private void rangeCheck(int value, int max, String name) {
        if (value < 0 || value > max)
            throw new IllegalArgumentException(name + ": " + value);
    }

    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(206, 555, 4121);
        PhoneNumber pn2 = PhoneNumber.getInstance("206-555-4121");
        PhoneNumber pn3 = PhoneNumber.getInstance("206-555-5176");
        System.out.println(pn1 + (pn1.equals(pn2) ? " == " : " != ") + pn2);
        System.out.println(pn2 + (pn2.equals(pn3) ? " == " : " != ") + pn3);
        System.out.println(pn3 + (pn3.equals(pn1) ? " == " : " != ") + pn1);
    }
}