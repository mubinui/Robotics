import java.util.Scanner;

public class ReverseKinematics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Taking x, y, z coordinate value
        double x = 8;
        double y = 3;
        double z = 8;
        // Taking arm lengths
        double l1 = 26;
        double l2 = 20;
        double l3 = 0;
        double d2 = 32;
        // Getting the outputs
        double [] outputs = reverse(x,y,z,l1,l2,l3,d2);
        for(double i:outputs){
            System.out.print(i+" ");
        }

    }

    public static double [] reverse(double x, double y, double z, double l1, double l2, double l3, double d2){
        // Let's find all the theta values
        double [] outputs =new double[3];
        double d1_L3 = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        double d1 = d1_L3 - l3;
        System.out.println("D1+L3--->"+d1_L3);
        System.out.println("D1---->"+d1);
        // Theta 01
        // From Top view
        outputs[0] =Math.round( Math.toDegrees(Math.acos(x/d1_L3)));
        // D6
        double d6 = Math.sqrt(Math.pow(d1,2)+ Math.pow((z-d2),2));
        System.out.println("D6----->"+d6);
        double t7 = Math.toDegrees(Math.acos(d1/d6));
        System.out.println("Theta 7---->"+t7);
        // Theta 2 = Theta 6 + Theta 7

        // Theta 3
        outputs[2] =Math.round(Math.toDegrees(Math.acos((Math.pow(l1,2)+Math.pow(l2,2)-Math.pow(d6,2))/(2*l1*l2))));
        // Theta 6
        double t6 = Math.toDegrees(Math.acos((Math.pow(l1,2)+(Math.pow(d6,2)-Math.pow(l2,2)))/(2*l1*d6)));
        System.out.println("Theta 6----->"+t6);
        outputs[1] = Math.round(t6+t7);
        double t4 = outputs[1]+outputs[2] + 90;
        System.out.println("Theta 4 (Not Servicing)---->"+t4);
        double t4ws = outputs[1]+outputs[2];
        System.out.println("Theta 4 while servicing--->"+t4ws);


        return outputs;
    }
}
