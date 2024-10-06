package Backtracking;


import java.util.Scanner;

public class TowerOfHanoi {
    

    //In order movement - using following movements
    // 1. pick min and for tower ABC, -> A C B
    // 2. move the larger one with sysout
    // 3. move the min for tower ABC -> B A C
    public static void move(int n, int srcTower, int desTower, int supportTower) {

        if (n == 0) {
            return;
        }

        move(n-1, srcTower, supportTower, desTower); //ACB  //it will pick the min, follwowing all rules
        System.out.println(n+" [ "+ srcTower +" -> "+ desTower+"]");
        move(n-1, supportTower, desTower, srcTower); //BCA

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input for 3 plates in tower 1, 
        // 3, 10, 11, 12 - 10, 11, 12 are towers with 3 plates in tower1 or tower 10

        int n = sc.nextInt();
        int tower1 = sc.nextInt(); //this could be Alphabet names too
        int tower2 = sc.nextInt();
        int tower3 = sc.nextInt();
        move(n, tower1, tower2, tower3);

    }
}
