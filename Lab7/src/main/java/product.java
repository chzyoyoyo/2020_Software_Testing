public class product {
    double divide(double numA, double numB){
        if (numB == 0.0)
            throw new IllegalArgumentException ("Illegal input divisor");
        else
            return numA/numB;
    }
}
