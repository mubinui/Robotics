import java.util.Scanner;

public class ForwardKinematics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double theta01 = 80;
        double theta02 = 30;
        double theta03 = 80;
        double d2 = 32;
        //The lengths of the hands
        double l1 = 26;
        double l2 = 20;
        double l3 = 0;
        //service
        boolean service = false;


        double [] outputs = forward(theta01,theta02,theta03, l1,l2,l3,service,d2);
        for(double i:outputs){
            System.out.print(i+"  ");

        }


    }

    public static double [] forward (double t1, double t2, double t3, double l1, double l2, double l3, boolean service, double d2){
        double [] outputs = new double[3];
        // the output array will output coordinates of x y and z
        double d3 = l1 * Math.sin(Math.toRadians(t2));
        System.out.println("D3--->"+d3);
        // D4
        double d4 = l1 * Math.cos(Math.toRadians(t2));
        System.out.println("D4--->"+d4);
        // Let's calculate dx and dy
        // dx + dy = theta03
        double tx = 180-90-t2;
        System.out.println("Theta X--->"+tx);
        double ty = t3-tx;
        System.out.println("Theta Y--->"+ty);
        double d6 = l2 * Math.cos(Math.toRadians(ty));
        System.out.println("D6 ---->"+d6);
        double d5 = l2 * Math.sin(Math.toRadians(ty));
        System.out.println("D5 ---->"+d5);
        // taking the value of z in output [3]
        double distance;
        if (service){
            outputs[2] = d2 + (d3-d6);
            distance = d4 + d5 + l3;
            System.out.println("Distance with service ---> "+ distance);

        }
        else{
            outputs[2] = d2+(d3-d6-l3);
            distance = d4 + d5;
            System.out.println("Distance without service-->"+ distance);
        }

        outputs[0] = distance*Math.cos(Math.toRadians(t1));
        outputs[1] = distance*Math.sin(Math.toRadians(t1));
        System.out.print("X,Y,Z ->");



        return outputs;

    }
}
