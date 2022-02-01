import java.util.Scanner;

public class Polygon{
  public int sides;
  public double perimeter;

  public void addSide(int length){
    sides++;
    perimeter += length;
  }

  public int getSides(){
    return sides;
  }

  public double getPerimeter(){
    return perimeter;
  }

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    Polygon p = new Polygon();
    while(true){
      System.out.println("Do you want to add a side? [Y/N]");
      String c = sc.next();
      if(c.equals("Y")){
        System.out.print("Enter side: ");
        int s = sc.nextInt();
        p.addSide(s);
      }else{
        break;
      }
    }
    System.out.println("\nNumber of sides added = "+p.getSides());
    System.out.println("Perimeter of the polygon = "+p.getPerimeter());

  }
}
